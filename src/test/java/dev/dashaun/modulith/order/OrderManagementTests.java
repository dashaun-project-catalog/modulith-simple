package dev.dashaun.modulith.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;
import org.springframework.test.context.event.ApplicationEvents;
import org.springframework.test.context.event.RecordApplicationEvents;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ApplicationModuleTest
@RecordApplicationEvents
class OrderManagementTests {

	@Autowired
    OrderManagement orderManagement;

	@Autowired
	ApplicationEvents events;

	@Test
	void completesOrder() throws Exception {
		orderManagement.complete(new Order());
		Thread.sleep(2000);
		long numEvents = events.stream(OrderCompleted.class).count();
		assertThat(numEvents).isEqualTo(1);
	}

}
