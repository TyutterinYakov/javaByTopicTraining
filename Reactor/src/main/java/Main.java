import java.time.Duration;
import java.util.Arrays;

import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		Mono.empty();
		Flux.empty();
		Mono<Integer> mono = Mono.just(1);
		Flux<Integer> flux = Flux.just(1,2,3,4);
		
		Flux<Integer> fluxForMono = mono.flux();
		Mono<Boolean> monoFromFlux = flux.any(s->s.equals(1));
		Mono<Integer> integerMono = flux.elementAt(1);
		
//		Flux.range(1, 5).subscribe(System.out::println);
//		Flux.fromIterable(Arrays.asList(1,2,3,4,5,6,7)).subscribe(System.out::println);
//		
//		Flux.<String>generate(sink->{
//			sink.next("hello");
//		})
//		.delayElements(Duration.ofMillis(500))
//		.take(10)
//		.subscribe(System.out::println);
		
		
//		Flux
//		.generate(
//				()->2356,
//				(state, sink)->{
//					if(state>2366) {
//						sink.complete();
//					} else {
//						sink.next("Step: "+state);
//					}
//					return state+3;
//				}
//		).subscribe(System.out::println);
		
		
		Flux
		.create(
			sink->
				telegramProducer.subscribe(new BaseSubscriber<Object>() {

					@Override
					protected void hookOnNext(Object value) {
						sink.next(value);
					}

					@Override
					protected void hookOnComplete() {
						sink.complete();
					}
					
					
				});
				
		).subscribe(System.out::println);
		
		
		Thread.sleep(4000);
	}
}
