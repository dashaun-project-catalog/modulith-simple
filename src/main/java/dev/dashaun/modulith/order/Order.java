package dev.dashaun.modulith.order;

import java.util.UUID;

import dev.dashaun.modulith.order.Order.OrderIdentifier;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;

public class Order implements AggregateRoot<Order, OrderIdentifier> {

	private OrderIdentifier id = new OrderIdentifier(UUID.randomUUID());

	@Override
	public OrderIdentifier getId() {
		return id;
	}

	public static record OrderIdentifier(UUID id) implements Identifier {}
}