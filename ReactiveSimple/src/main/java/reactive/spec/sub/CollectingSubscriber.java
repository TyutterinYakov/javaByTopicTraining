package reactive.spec.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import reactive.spec.Subscriber;
import reactive.spec.Subscription;

public class CollectingSubscriber<T> implements Subscriber<T>{

	
	private Subscription subscription;
	private final List<T> results = new ArrayList<>();
	private boolean completed = false; 
	
	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription=subscription;
	}

	@Override
	public void onNext(T value) {
		results.add(value);
	}

	@Override
	public void onComplete() {
		this.completed=true;
	}
	
	public List<T> blockingGet(){
		Objects.requireNonNull(subscription, "No subscription");
		subscription.request(Long.MAX_VALUE);
		while(!completed) {
			Thread.onSpinWait();
			onComplete(); //TODO
		}
		return results;
	}

}
