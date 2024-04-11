package dev.dashaun.modulith;

import dev.dashaun.modulith.order.Order;
import dev.dashaun.modulith.order.OrderManagement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(OutputCaptureExtension.class)
class ApplicationIntegrationTests {

    @Autowired
    OrderManagement orders;

    @Test
    void completesOrder(CapturedOutput output) throws Exception {
        orders.complete(new Order());
        Thread.sleep(2000);
        assertThat(output).contains("Received order completion");
        assertThat(output).contains("Finished order completion");
    }
}
