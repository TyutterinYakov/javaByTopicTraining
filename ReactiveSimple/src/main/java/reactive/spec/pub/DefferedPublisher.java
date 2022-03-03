package reactive.spec.pub;

import java.util.function.Supplier;

import reactive.spec.Publisher;
import reactive.spec.Subscriber;

public class DefferedPublisher<T> implements Publisher<T>{

	
	private final Supplier<Publisher<T>> supplier;
	
	public DefferedPublisher(Supplier<Publisher<T>> supplier) {
		super();
		this.supplier = supplier;
	}





	@Override
	public void subscribe(Subscriber<T> subscriber) {
		supplier.get().subscribe(subscriber);
	}

	
}
