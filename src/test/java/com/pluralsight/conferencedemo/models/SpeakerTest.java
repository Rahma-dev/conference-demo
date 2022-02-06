package com.pluralsight.conferencedemo.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpeakerTest {

    @Test
    void removeSession(Session removedSession) {
        assertNull(removedSession);
    }

    @Test
    void remove(List<Speaker> speakers) {
        assertNull(speakers);
    }
}