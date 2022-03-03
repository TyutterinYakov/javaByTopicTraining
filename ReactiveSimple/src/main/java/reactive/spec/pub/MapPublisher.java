package reactive.spec.pub;

import java.util.function.Function;

import reactive.spec.Publisher;
import reactive.spec.Subscriber;
import reactive.spec.Subscription;

public class MapPublisher<T, R> implements Publisher<R>{

	
	private final Publisher<T> source;
	private final Function<T, R> mapper;
	
	public MapPublisher(Publisher<T> source, Function<T, R> mapper) {
		super();
		this.source = source;
		this.mapper = mapper;
	}


	@Override
	public void subscribe(Subscriber<R> subscriber) {
		source.subscribe(new MapSubscriber(subscriber));
		
	}
	
	
	private class MapSubscriber implements Subscriber<T>{

		
		private final Subscriber<? super R> subscriber;
		
		public MapSubscriber(Subscriber<? super R> subscriber) {
			super();
			this.subscriber = subscriber;
		}

		@Override
		public void onSubscribe(Subscription subscription) {
			subscriber.onSubscribe(subscription);
		}

		@Override
		public void onNext(T value) {
			subscriber.onNext(mapper.apply(value));
		}

		@Override
		public void onComplete() {
			source.subscribe( new MapSubscriber(subscriber));
		}
		
	}

}
