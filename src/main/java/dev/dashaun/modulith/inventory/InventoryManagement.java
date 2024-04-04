package dev.dashaun.modulith.inventory;

import dev.dashaun.modulith.order.OrderCompleted;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.modulith.ApplicationModuleListener;
import org.springframework.stereotype.Service;

/**
 * A Spring {@link Service} exposed by the inventory module.
 *
 * @author Oliver Drotbohm
 */
@Service
class InventoryManagement {

	private static final Logger LOG = LoggerFactory.getLogger(InventoryManagement.class);

	private final InventoryInternal dependency;

	public InventoryManagement(InventoryInternal dependency) {
		this.dependency = dependency;
	}

	@ApplicationModuleListener
	void on(OrderCompleted event) throws InterruptedException {

		var orderId = event.orderId();

		LOG.info("Received order completion for {}.", orderId);

		// Simulate busy work
		Thread.sleep(1000);

		LOG.info("Finished order completion for {}.", orderId);
	}

}
