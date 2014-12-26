package JUnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BombLokumJUnitTest {

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
		Lokum lokum =new BombLokum();
		lokum.setLokum(1,0,1);
		lokum.repOk();
		//assertTrue(lokum.getColor()==1);
	}

	@Test
	public void testGetColor() {
		Lokum lokum =new BombLokum();
		lokum.setLokum(4,0,1);
		lokum.repOk();
		//assertTrue(lokum.getColor()==4);
	}

	@Test
	public void testDestroy() {
		Lokum lokum =new BombLokum();
		lokum.destroy();
		assertTrue(lokum.getColor()==0);
	}

}
