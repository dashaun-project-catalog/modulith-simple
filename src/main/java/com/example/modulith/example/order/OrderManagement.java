/*
 * Copyright 2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.example.modulith.example.order;

import com.example.modulith.example.order.internal.OrderInternal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderManagement {

	private final ApplicationEventPublisher events;

	private final OrderInternal dependency;

	@Autowired
	public OrderManagement(ApplicationEventPublisher events, OrderInternal dependency) {
		this.events = events;
		this.dependency = dependency;
	}

	@Transactional
	public void complete(Order order) {
		events.publishEvent(new OrderCompleted(order.getId()));
	}
}
