package dev.dashaun.modulith.order;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;

@ApplicationModuleTest
class OrderManagementTests {

	@Autowired
    OrderManagement orderManagement;

	@Test
	void completesOrder() throws Exception {

		orderManagement.complete(new Order());

		Thread.sleep(2000);
	}
}
