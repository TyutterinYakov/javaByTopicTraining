package reactive.spec.pub;

import reactive.spec.Publisher;
import reactive.spec.Subscriber;
import reactive.spec.Subscription;

public class JustPublisher<T> implements Publisher<T> {

	private final T[] values;
	
	public JustPublisher(T[] values) {
		super();
		this.values = values;
	}

	public void subscribe(Subscriber<T> subscriber) {
		Subscription subscription = new JustSubscription(subscriber);
		subscriber.onSubscribe(subscription);
	}
	
	
	
	private class JustSubscription implements Subscription {

		private final Subscriber<T> subscriber;
		private int position = 0;
		
		public JustSubscription(Subscriber<T> subscriber) {
			super();
			this.subscriber = subscriber;
		}

		public void request(Long n) {
			for(int i=0; i<n; i++) {
				if(position == values.length) {
					subscriber.onComplete();
					return;
				}
				subscriber.onNext(values[position++]);
			}
		}
		
	}

}
