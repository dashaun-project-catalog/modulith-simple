package dev.dashaun.modulith.inventory;

import dev.dashaun.modulith.order.Order;
import dev.dashaun.modulith.order.OrderCompleted;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.modulith.test.ApplicationModuleTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationModuleTest
@ExtendWith(OutputCaptureExtension.class)
class InventoryServiceTests {

    @Autowired
    ApplicationEventPublisher events;

    @Test
    void completesOrder(CapturedOutput output) throws Exception {
        InventoryService inventoryService = new InventoryService(new InventoryRepository());
        inventoryService.updateStock(new OrderCompleted(new Order().getId()));
        assertThat(output).contains("Received order completion");
        assertThat(output).contains("Finished order completion");
    }
}
