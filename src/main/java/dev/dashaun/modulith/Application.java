package dev.dashaun.modulith;

import dev.dashaun.modulith.order.Order;
import dev.dashaun.modulith.order.OrderManagement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
@ConfigurationPropertiesScan
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args)
				.getBean(OrderManagement.class)
				.complete(new Order());
	}

}
