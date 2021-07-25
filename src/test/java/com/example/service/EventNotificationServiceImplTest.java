package com.example.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Attendee;
import com.example.Event;
import com.example.EventType;

class EventNotificationServiceImplTest {
	EventNotificationServiceImpl service ;
	Event event;

	@BeforeEach
	void setUp() throws Exception {
		service = new EventNotificationServiceImpl();
		event = new Event(1L, "", EventType.MARKETING, service);
	}

	@Test
	void testNulos() {

		Attendee asistente1 = new Attendee();
		event.addAttendee(asistente1);
		
		//
		assertEquals(0, asistente1.getNotifications().size());
		service.announce(null);
		assertEquals(0, asistente1.getNotifications().size());

		// 
		event.setAttendees(null);
		service.announce(event);
		assertEquals(0, asistente1.getNotifications().size());

		// 
		event.setAttendees(new ArrayList<Attendee>());
		service.announce(event);
		assertEquals(0, asistente1.getNotifications().size());

	}


































}
