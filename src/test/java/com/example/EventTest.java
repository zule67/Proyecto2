package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.service.EventNotificationServiceImpl;

class EventTest {

	Event event;

	@BeforeEach
	void setUp() throws Exception {
		event = new Event();
	}

	@Test
	void testAddAttendee() {

		assertEquals(0, event.getAttendees().size());

		Attendee person1 = new Attendee(1L, "Persona1", "");
		Attendee person2 = new Attendee(2L, "Persona2", "");
		event.addAttendee(person1);
		assertEquals(1, event.getAttendees().size());

		event.addAttendee(person2);
		assertEquals(2, event.getAttendees().size());

		assertEquals("Persona1", event.getAttendees().get(0).getNickname());
		assertEquals("Persona2", event.getAttendees().get(1).getNickname());

	}

	@Test
	void testAddAttendeeNull() {

		assertEquals(0, event.getAttendees().size());

		event.addAttendee(null);

		assertEquals(0, event.getAttendees().size());

	}

	@Test
	void testAddAttendeeListNull() throws Exception {
		Event evento = new Event(1L, "El evento del año", EventType.BUSINESS, new EventNotificationServiceImpl());

		evento.setAttendees(null);
		assertEquals(null, evento.getAttendees());
		Attendee person1 = new Attendee(1L, "Persona1", "");

		evento.addAttendee(person1);
		assertEquals(1, evento.getAttendees().size());

	}

	@Test
	void testAddAttendeeAlreadyContains() {

		assertEquals(0, event.getAttendees().size());
		Attendee person1 = new Attendee(1L, "Persona1", "");
		event.addAttendee(person1);
		assertEquals(1, event.getAttendees().size());
		event.addAttendee(person1);
		assertEquals(1, event.getAttendees().size());

	}

	@Test
	void testAddAttendees() {
		List<Attendee> attendees = new ArrayList<>();
		Attendee person1 = new Attendee(1L, "Persona1", "");
		Attendee person2 = new Attendee(2L, "Persona2", "");
		attendees.add(person2);
		attendees.add(person1);
		event.addAttendees(attendees);
	}

	@Test
	void testAddAttendeesNull() {
		List<Attendee> attendees = new ArrayList<>();
		Attendee person1 = new Attendee(1L, "Persona1", "");
		attendees.add(person1);
		event.addAttendees(attendees);
		assertEquals(1, event.getAttendees().size());
		
		event.setAttendees(null); 
		event.addAttendees(attendees);
		assertEquals(1, event.getAttendees().size());
	}
	
	@Test
	void testAddAttendeesListNull() throws Exception{
		List<Attendee> attendees = null;
		assertEquals(0, event.getAttendees().size());

		event.addAttendees(attendees);

		assertEquals(0, event.getAttendees().size());
	}
	
	@Test
	void testAddAttendeesAlreadyContains() {
		List<Attendee> attendees = new ArrayList<>();
		assertEquals(0, event.getAttendees().size());
		Attendee person1 = new Attendee(1L, "Persona1", "");
		attendees.add(person1);
		attendees.add(person1);
		event.addAttendees(attendees);
		attendees = event.getAttendees();
		assertEquals(1, attendees.size());

	}

	@Test
	void testRemoveAttendee() throws Exception {
		Attendee person1 = new Attendee(2L, "Persona2", "");
		event.addAttendee(person1);
		assertEquals(1, event.getAttendees().size());
		event.removeAttendee(person1);
		assertEquals(0, event.getAttendees().size());
	}

	@Test
	void testRemoveAttendeeNull() {
		Attendee person1 = new Attendee(2L, "Persona2", "");
		event.addAttendee(person1);
		assertEquals(1, event.getAttendees().size());
		event.removeAttendee(null);
		assertEquals(1, event.getAttendees().size());
	}

	@Test
	void testRemoveAttendeeGetIsNull() {
		List<Attendee> attendees = new ArrayList<>();
		Attendee person1 = new Attendee(2L, "Persona2", "");
		event.addAttendee(person1);
		event.setAttendees(null);
		event.removeAttendee(person1);
		assertEquals(0, attendees.size());
	}
	
	@Test
	void testRemoveAttendees() {
		Attendee person1 = new Attendee(2L, "Persona1", "");
		event.addAttendee(person1);
		Attendee person2 = new Attendee(3L, "Persona2", "");
		event.addAttendee(person2);
		assertEquals(2, event.getAttendees().size());
		event.removeAttendees(event.getAttendees());
		assertEquals(0, event.getAttendees().size());
	}

	@Test
	void testRemoveAttendeesNull() {
		
		List<Attendee> attendees = new ArrayList<>();
		Attendee person1 = new Attendee(2L, "Persona1", "");
		attendees.add(person1);
		event.addAttendees(attendees);
		assertEquals(1, event.getAttendees().size());
		
		event.setAttendees(null);
		event.getAttendees();
		event.removeAttendees(null);
	}
	
	@Test
	void testRemoveAttendeesGetIsNull() {
		List<Attendee> attendees = new ArrayList<>();
		Attendee person1 = new Attendee(2L, "Persona2", "");
		event.addAttendee(person1);
		event.setAttendees(null);
		event.removeAttendees(attendees);
		assertEquals(0, attendees.size());
	}

	@Test
	void testAddSpeaker() {
		assertEquals(0, event.getSpeakers().size());

		Speaker person1 = new Speaker(1L, "Persona1", "");
		Speaker person2 = new Speaker(2L, "Persona2", "");
		event.addSpeaker(person1);
		assertEquals(1, event.getSpeakers().size());

		event.addSpeaker(person2);
		assertEquals(2, event.getSpeakers().size());

	}

	@Test
	void testAddSpeakerNull() {
		assertEquals(0, event.getSpeakers().size());

		event.addSpeaker(null);

		assertEquals(0, event.getSpeakers().size());

	}

	@Test
	void testRemoveSpeaker() {
		Speaker person1 = new Speaker(2L, "Persona2", "");
		event.addSpeaker(person1);
		assertEquals(1, event.getSpeakers().size());
		event.removeSpeaker(person1);
		assertEquals(0, event.getSpeakers().size());

	}

	@Test
	void testRemoveSpeakerNull() {
		Speaker person1 = new Speaker(2L, "Persona2", "");
		event.addSpeaker(person1);
		assertEquals(1, event.getSpeakers().size());
		event.removeSpeaker(null);
		assertEquals(1, event.getSpeakers().size());

	}

}
