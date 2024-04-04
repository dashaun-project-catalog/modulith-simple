package dev.dashaun.modulith.inventory;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("inventory")
class InventorySettings {

    /**
     * Some Javadoc.
     */
    int threshold;
}
