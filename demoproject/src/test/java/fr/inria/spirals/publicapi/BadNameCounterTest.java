package fr.inria.spirals.publicapi;

import fr.inria.spirals.publicapi.utils.BadNameCounter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class BadNameCounterTest {
    @Test
    public void testGetOrCreate() {
        BadNameCounter badNameCounter = new BadNameCounter();
        assertNull(badNameCounter.getCounter());
        assertNotNull(badNameCounter.getOrCreateInnerCounter());
    }

    @Test
    public void testNext() {
        BadNameCounter badNameCounter = new BadNameCounter();
        assertEquals(1, badNameCounter.next());
    }
}
