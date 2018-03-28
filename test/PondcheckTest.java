package test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import try4.Pond;

class PondcheckTest {
	Pond pond = new Pond();
	String pondName;
	int capacity;

	@BeforeEach
	void setUp() throws Exception {
		pondName = "PondSmall";
		capacity = 10;
	}

	@Test
	void testGetPondCapacity() {
		assertEquals(capacity, pond.getPondCapacity(pondName));
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	void doCheckingException() {
		exception.expect(NullPointerException.class);
		exception.expectMessage("NO SUCH POND");
		pond.getPondCapacity("37");
	}
	

	@Test
	void testAddingFishesToPond() {

		HashMap<String, ArrayList<String>> pondWithFishesExpected = new HashMap<String, ArrayList<String>>();
		HashMap<String, Integer> fishAndsize = new HashMap<String, Integer>();
		Pond pond = mock(Pond.class);
		assertEquals(pondWithFishesExpected, pond.addFishesToPond(pondName, capacity, fishAndsize));

		fishAndsize.put("GoldenFish", 140);
		fishAndsize.put("Bass", 420);
		fishAndsize.put("SunFish", 200);
		fishAndsize.put("Guppy", 80);

		pondWithFishesExpected.put("PondSmall", new ArrayList<>(Arrays.asList("GoldenFish", "Guppy", "Bass", "SunFish",
				"GoldenFish", "Bass", "GoldenFish", "Bass", "Guppy", "Guppy")));
		doReturn(pondWithFishesExpected).when(pond).addFishesToPond(pondName, capacity, fishAndsize);

		assertEquals(pondWithFishesExpected, pond.addFishesToPond(pondName, capacity, fishAndsize));
		
	}
	
	
	@AfterEach
	void tearDown() throws Exception {
		pondName = null;
		capacity = 0;
	}

}
