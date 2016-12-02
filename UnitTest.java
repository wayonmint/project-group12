import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalculateHome1() {
		CalculateHome n = new CalculateHome(0, 15);
		if(((float)n.getResults())!=(float)41.16504){
			fail();
		}
	}
	
	@Test
	public void testCalculateHome2() {
		CalculateHome n = new CalculateHome(0, 250);
		if((float)n.getResults()!=(float)925.7212){
			fail();
		}
	}
	
	@Test
	public void testCalculateInsideBFM1() {
		CalculateBFM c = new CalculateBFM(1, 300.14);
		if((float)c.getResults()!=(float)1495.7){
			fail();
		}
	}
	
	@Test
	public void testCalculateInsideBFM2() {
		CalculateBFM c = new CalculateBFM(1, 401);
		System.out.println(c.getResults());
		if((float)c.getResults()!=(float)2400.0){
			fail();
		}
	}
	
	@Test
	public void testCalculateInsideACE1() {
		CalculateACE c = new CalculateACE(1, 151);
		if((float)c.getResults()!=(float)750.0){
			fail();
		}
	}
	
	@Test
	public void testCalculateInsideACE2() {
		CalculateACE c = new CalculateACE(1, 200);
		if((float)c.getResults()==(float)1200.0){
			fail();
		}
	}
	
	@Test
	public void testCalculateOutside() {
		CalculateOut c = new CalculateOut(1, 11, 7);
		if((float)c.getResults()!=(float)70.0){
			fail();
		}
	}
}
