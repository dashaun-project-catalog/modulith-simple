package dev.dashaun.modulith.order;

import dev.dashaun.modulith.order.Order.OrderIdentifier;
import org.jmolecules.event.types.DomainEvent;

public record OrderCompleted(OrderIdentifier orderId) implements DomainEvent {}