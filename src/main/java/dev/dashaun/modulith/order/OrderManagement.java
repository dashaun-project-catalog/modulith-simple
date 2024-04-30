package dev.dashaun.modulith.order;

import dev.dashaun.modulith.order.internal.OrderInternal;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderManagement {

	private final ApplicationEventPublisher events;

	private final OrderInternal dependency;

	public OrderManagement(ApplicationEventPublisher events, OrderInternal dependency) {
		this.events = events;
		this.dependency = dependency;
	}

	@Transactional
	public void complete(Order order) {
		events.publishEvent(new OrderCompleted(order.getId()));
	}
}
