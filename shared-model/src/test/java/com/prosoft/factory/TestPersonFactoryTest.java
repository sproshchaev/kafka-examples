package com.prosoft.factory;

import com.prosoft.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TestPersonFactoryTest {

    private TestPersonFactory factory;
    private static final Instant FIXED_TIME = Instant.parse("2023-12-01T10:30:45Z");
    private static final Clock FIXED_CLOCK = Clock.fixed(FIXED_TIME, ZoneId.of("UTC"));

    @BeforeEach
    void setUp() {
        factory = new TestPersonFactory(FIXED_CLOCK);
    }

    @Test
    void shouldCreateTestPersonWithValidData() {
        // When
        Person person = factory.createTestPerson();

        // Then
        assertNotNull(person);
        assertNotNull(person.getId());
        assertNotNull(person.getName());
        assertNotNull(person.getEmail());
        assertNotNull(person.getCreatedAt());

        // Проверяем, что данные не пустые
        assertFalse(person.getId().isEmpty());
        assertTrue(person.getName().startsWith("Test Person "));
        assertTrue(person.getEmail().endsWith("@prosoft.com"));
        assertEquals(FIXED_TIME, person.getCreatedAt());

        // Проверяем возраст в диапазоне
        assertTrue(person.getAge() >= 18 && person.getAge() <= 65,
                "Age should be between 18 and 65, but was: " + person.getAge());
    }

    @Test
    void shouldCreatePersonsWithSequentialIds() {
        // When
        Person person1 = factory.createTestPerson();
        Person person2 = factory.createTestPerson();
        Person person3 = factory.createTestPerson();

        // Выводим для отладки
        System.out.println("Person1 ID: " + person1.getId());
        System.out.println("Person2 ID: " + person2.getId());
        System.out.println("Person3 ID: " + person3.getId());

        // Then - проверяем, что ID не пустые и уникальные
        assertNotNull(person1.getId());
        assertNotNull(person2.getId());
        assertNotNull(person3.getId());

        assertNotEquals(person1.getId(), person2.getId());
        assertNotEquals(person2.getId(), person3.getId());
        assertNotEquals(person1.getId(), person3.getId());

        // Проверяем, что имена содержат ID
        assertTrue(person1.getName().contains(person1.getId()));
        assertTrue(person2.getName().contains(person2.getId()));
        assertTrue(person3.getName().contains(person3.getId()));
    }

    @Test
    void shouldClearCountersAndResetSequence() {
        // Given
        Person person1 = factory.createTestPerson();
        String firstId = person1.getId();

        // When
        factory.clearCounters();
        Person person2 = factory.createTestPerson();
        String secondId = person2.getId();

        // Then
        assertNotNull(firstId);
        assertNotNull(secondId);
        System.out.println("First ID: " + firstId);
        System.out.println("Second ID after clear: " + secondId);
    }

    @Test
    void shouldWorkWithDefaultConstructor() {
        // Given
        TestPersonFactory defaultFactory = new TestPersonFactory();

        // When
        Person person = defaultFactory.createTestPerson();

        // Then
        assertNotNull(person);
        assertNotNull(person.getId());
        assertNotNull(person.getName());
        assertNotNull(person.getEmail());
        assertNotNull(person.getCreatedAt());
    }

    @Test
    void shouldGenerateAgeInRange() {
        // Given
        TestPersonFactory factoryWithFixedRandom = new TestPersonFactory(FIXED_CLOCK, new Random(123L));

        // When
        Person person = factoryWithFixedRandom.createTestPerson();

        // Then
        assertTrue(person.getAge() >= 18, "Age should be >= 18, but was: " + person.getAge());
        assertTrue(person.getAge() <= 65, "Age should be <= 65, but was: " + person.getAge());
    }
}