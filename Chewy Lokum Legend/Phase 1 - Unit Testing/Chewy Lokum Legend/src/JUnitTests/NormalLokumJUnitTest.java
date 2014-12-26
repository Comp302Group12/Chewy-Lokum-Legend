package JUnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NormalLokumJUnitTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetLokum() {
		Lokum lokum =new NormalLokum();
		lokum.setLokum(1,2,3);
		lokum.repOk();
		//assertTrue(lokum.getColor()==1);
		
	}

	@Test
	public void testGetColor() {
		Lokum lokum =new NormalLokum();
		lokum.setLokum(4,2,3);
		lokum.repOk();
		//assertTrue(lokum.getColor()==4);
	}

	@Test
	public void testDestroy() {
		Lokum lokum =new NormalLokum();
		lokum.destroy();
		assertTrue(lokum.getColor()==0);
	}

	@Test
	public void testSetRandomly() {
		Lokum lokum =new NormalLokum();
		lokum.SetRandomly();
		lokum.repOk();
		//assertTrue(lokum.getColor()==1 || lokum.getColor()==2 || lokum.getColor()==3 || lokum.getColor()==4);
	}

}
