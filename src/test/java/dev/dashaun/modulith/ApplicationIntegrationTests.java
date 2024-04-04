package dev.dashaun.modulith;

import dev.dashaun.modulith.order.Order;
import dev.dashaun.modulith.order.OrderManagement;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationIntegrationTests {

	@Autowired
    OrderManagement orderManagement;

	@Test
	void completesOrder() throws Exception {

		orderManagement.complete(new Order());

		Thread.sleep(2000);
	}
}
