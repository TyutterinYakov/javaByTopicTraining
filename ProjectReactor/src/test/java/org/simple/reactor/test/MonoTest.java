package org.simple.reactor.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Slf4j
public class MonoTest {

    @Test
    public void monoSubscriber(){
        String name ="Yasha Tyutterin";
        Mono<String> mono = Mono.just(name)
                .log();

        mono.subscribe();
        log.info("---------------");
        StepVerifier.create(mono)
                .expectNext(name)
                .verifyComplete();
        log.info("Mono {}", mono);
        log.info("working");
    }

    @Test
    public void monoSubscriberConsumer(){
        String name ="Yasha Tyutterin";
        Mono<String> mono = Mono.just(name)
                .log();

        mono.subscribe(n->{
            n.toUpperCase();
            System.out.println(n);
        });
    }

    @Test
    public void monoSubscriberConsumerError(){
        String name ="Yasha Tyutterin";
        Mono<String> mono = Mono.just(name)
                .map(s -> {
                    throw new RuntimeException("Testing mono with error");
                });


        mono.subscribe(n->log.info("Name {}", n), n -> log.error("Hello"));
        mono.subscribe(n->log.info("Name {}", n), Throwable::printStackTrace);
        log.info("---------------");
        StepVerifier.create(mono)
                        .expectError(RuntimeException.class)
                        .verify();

        log.info("Mono {}", mono);
        log.info("working");
    }


    @Test
    public void monoSubscriberConsumerComplete(){
        String name ="Yasha Tyutterin";
        Mono<String> mono = Mono.just(name)
                .log()
                .map(String::toUpperCase);

        mono.subscribe(s->log.info("Value {}", s),
                Throwable::printStackTrace,
                ()->log.info("FINISHED!"));
        log.info("---------------");
        StepVerifier.create(mono)
                .expectNext(name.toUpperCase())
                .verifyComplete();
        log.info("Mono {}", mono);
        log.info("working");
    }


    @Test
    public void monoSubscriberConsumerSubscription(){
        String name ="Yasha Tyutterin";
        Mono<String> mono = Mono.just(name)
                .log()
                .map(String::toUpperCase);

        mono.subscribe(s->log.info("Value {}", s),
                Throwable::printStackTrace,
                ()->log.info("FINISHED!"),
                Subscription::cancel);
        mono.subscribe(s->log.info("Value {}", s),
                Throwable::printStackTrace,
                ()->log.info("FINISHED!"),
                sub -> sub.request(5));


        log.info("---------------");
        StepVerifier.create(mono)
                .expectNext(name.toUpperCase())
                .verifyComplete();
    }

        @Test
    public void monoDoOneMethod(){
        String name ="Yasha Tyutterin";
        Mono<String> mono = Mono.just(name)
                .log()
                .map(String::toUpperCase)
                .doOnSubscribe(sb->{
                    log.info("Subscribed {}", sb);
                });

        mono.subscribe(s->log.info("Value {}", s),
                Throwable::printStackTrace,
                ()->log.info("FINISHED!"));
        log.info("---------------");
        StepVerifier.create(mono)
                .expectNext(name.toUpperCase())
                .verifyComplete();
        log.info("Mono {}", mono);
        log.info("working");
    }
}
