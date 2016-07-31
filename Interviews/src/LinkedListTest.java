import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 */

/**
 * @author sunlin
 *
 */
public class LinkedListTest {
	LinkedList llist1 = new LinkedList();
	LinkedList llist2 = new LinkedList();
	final int SIZE = 5;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	      for (int i = 0; i < SIZE; i++) {
	    	  llist1.insert(i);
	    	  llist2.insert(i);
		  }
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	
	}

//	@Test
//	public void print() {
//		llist1.print();
//		assertEquals(1, 1);
//	}

	@Test
	public void TestExist() {
		assertEquals(true, llist1.exist(4));
	}
	
	@Test
	public void TestNonExist() {
		assertEquals(false, llist1.exist(106));
	}
	
	@Test
	public void TestSize() {
		// System.out.println(llist1.size);
		LinkedList l = new LinkedList();
	    for (int i = 0; i < SIZE; i++) {
	    	  l.insert(i);
		}
	    System.out.println(llist1.size);
		assertEquals(5, llist1.size);
	}
	
	

}
