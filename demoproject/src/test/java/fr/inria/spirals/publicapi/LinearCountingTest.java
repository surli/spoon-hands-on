package fr.inria.spirals.publicapi;

import fr.inria.spirals.publicapi.utils.LinearCounting;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class LinearCountingTest {
    @Test
    public void testGetOrCreate() {
        LinearCounting linearCounting = new LinearCounting();
        assertNull(linearCounting.getCounter());
        assertNotNull(linearCounting.getOrCreateInnerCounter());
    }

    @Test
    public void testNext() {
        LinearCounting linearCounting = new LinearCounting();
        assertEquals(1, linearCounting.next());
    }
}
