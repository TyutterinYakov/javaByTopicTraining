package reactive.spec;


import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import reactive.spec.pub.DefferedPublisher;
import reactive.spec.pub.JustPublisher;
import reactive.spec.pub.MapPublisher;
import reactive.spec.sub.CollectingSubscriber;

public interface Publisher<T> {
	
	void subscribe(Subscriber<T> subscriber);
	
	@SafeVarargs
	static <V> Publisher<V> just(V... values){
		return new JustPublisher<>(values);
	}
	
	static <V> Publisher<V> from(Supplier<V> supplier){
		return new DefferedPublisher<>(()-> Publisher.just(supplier.get()));
	}
	
	static <V> Publisher<V> defer(Supplier<Publisher<V>> supplier){
		return new DefferedPublisher<>(supplier);
	}
	
	default <R> Publisher<R> map(Function<T, R> mapper){
		return new MapPublisher<>(this, mapper);
	}
	
	default Publisher<T> peek(Consumer<T> consumer){
		return new MapPublisher<>(this, val->{
			consumer.accept(val);
			return val;
		});
	}
	
	default List<T> collect(){
		CollectingSubscriber<T> subscriber = new CollectingSubscriber<>();
		subscribe(subscriber);
		return subscriber.blockingGet();
	}
	

}
