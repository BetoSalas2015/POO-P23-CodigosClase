

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class TestHora.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestHora
{
    /**
     * Default constructor for test class TestHora
     */
    public TestHora()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testCase01()
    {
        Hora miHora = new Hora(14, 8);
        assertEquals(8, miHora.getMinutos());
    }

    @Test
    public void testCase02()
    {
        Hora miHora = new Hora(14, 17);
        assertEquals("2:17:00 PM", miHora.toString());
    }
}


