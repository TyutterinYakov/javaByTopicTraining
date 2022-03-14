package com.example.reactivewebservice;

import com.example.reactivewebservice.hello.GreetingClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ReactiveWebServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ReactiveWebServiceApplication.class, args);
		GreetingClient client =  context.getBean(GreetingClient.class);

		System.out.println(">> message = "+client.getMessage().block());
	}

}
