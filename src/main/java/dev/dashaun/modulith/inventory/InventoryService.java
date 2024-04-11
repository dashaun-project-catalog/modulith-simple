package dev.dashaun.modulith.inventory;

import dev.dashaun.modulith.order.OrderCompleted;
import org.jmolecules.ddd.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.modulith.ApplicationModuleListener;

@Service
class InventoryService {

    private static final Logger LOG = LoggerFactory.getLogger(InventoryService.class);

    @SuppressWarnings("unused") //
    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
        LOG.info("InventoryService initialized.");
    }

    /**
     * Updates the stock for all line items contained in the order.
     */
    @ApplicationModuleListener
    void updateStock(OrderCompleted order) throws InterruptedException {
        var orderId = order.orderId();

        LOG.info("Received order completion for {}.", orderId);

        // Simulate busy work
        Thread.sleep(1000);

        LOG.info("Finished order completion for {}.", orderId);
    }
}
