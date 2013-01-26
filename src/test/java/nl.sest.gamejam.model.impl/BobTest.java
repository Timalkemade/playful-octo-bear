package nl.sest.gamejam.model.impl;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

/**
 * @author Tim
 * @since 1/26/13 2:08 AM
 */
public class BobTest {

    private Bob bob;

    @Before
    public void before() {
        bob = new Bob(null, 0, 0);
    }

    @Test
    public void testEquals() throws Exception {
        assertEquals("Objects are the same", bob, bob);
    }

    @Test
    public void testEqualsFalse() {
        Bob otherbob = new Bob(null, 0, 0);
        assertFalse(bob.equals(otherbob));
    }

    @Test
    public void testEqualsNull() {
        assertFalse(bob.equals(null));
    }

    @Test
    public void testEqualsOtherObject() {
        assertFalse(bob.equals("test"));
    }
}
