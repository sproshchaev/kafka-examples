package com.prosoft.factory;

import com.prosoft.model.Person;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TestPersonFactory {
    private static final DateTimeFormatter ID_FORMATTER =
            DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneId.systemDefault());

    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 65;

    private final ConcurrentHashMap<String, AtomicInteger> idCounters = new ConcurrentHashMap<>();
    private final Clock clock;
    private final Random random;

    public TestPersonFactory() {
        this(Clock.systemDefaultZone(), new Random());
    }

    public TestPersonFactory(Clock clock) {
        this(clock, new Random());
    }

    public TestPersonFactory(Clock clock, Random random) {
        this.clock = clock;
        this.random = random;
    }

    public Person createTestPerson() {
        String baseId = ID_FORMATTER.format(Instant.now(clock));
        AtomicInteger counter = idCounters.computeIfAbsent(baseId, k -> new AtomicInteger(0));
        int count = counter.incrementAndGet();
        String finalId = count == 1 ? baseId : baseId + "-" + count;

        int randomAge = MIN_AGE + random.nextInt(MAX_AGE - MIN_AGE + 1);

        return Person.builder()
                .id(finalId)
                .name("Test Person " + finalId)
                .age(randomAge)
                .email("Test Person " + finalId + "@prosoft.com")
                .createdAt(Instant.now(clock))
                .build();
    }

    public void clearCounters() {
        idCounters.clear();
    }
}