import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class LinkedListMauricioTest
{
    LinkedListMauricio linkedLi1;
    LinkedListMauricio linkedLi2;
    /**
     * Default constructor for test class LinkedListMauricioTest
     */
    public LinkedListMauricioTest()
    {
        linkedLi1 = new LinkedListMauricio();
        linkedLi2 = new LinkedListMauricio();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        linkedLi1.insert(4, 0);
        linkedLi1.insert(3, 1);
        linkedLi1.insert(8, 2);
        linkedLi1.insert(6, 3);
        linkedLi1.insert(0, 4);
        linkedLi1.insert(9, 5);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void contains_Test()
    {
        assertEquals(true, linkedLi1.contains(3));
        assertEquals(false, linkedLi1.contains(5));
    }

    @Test
    public void insertFirst_Test()
    {
        linkedLi1.insert(5, 0);
    }

    @Test
    public void removeFirst_Test()
    {
        linkedLi1.remove(0);
    }
    
    @Test
    public void insertEmpty_Test()
    {
        linkedLi2.insert(4, 2);
    }

    @Test
    public void removeEmpty_Test()
    {
        linkedLi2.remove(3);
    }
    
    @Test
    public void insertLast_Test()
    {
        linkedLi1.insert(9, 6);
    }

    @Test
    public void removeLast_Test()
    {
        linkedLi1.remove(5);
    }
}