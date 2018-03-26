package test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import static org.mockito.Mockito.*;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import try4.Pond;

class PondTest {
	Pond pond = new Pond();

	@Test
	void testGetPondCapacity() {
		String pondName = "PondSmall";
		int expectedCapacity = 10;
		assertEquals(expectedCapacity, pond.getPondCapacity(pondName));
	}

	@Test
	void testAddingFishesToPond() {
		HashMap<String, ArrayList<String>> pondWithFishesExpected = new HashMap<String, ArrayList<String>>();
		HashMap<String, Integer> fishAndsize = new HashMap<String, Integer>();
		String pondName = "PondSmall";
		int capacity = 10;
		
		fishAndsize.put("GoldenFish", 140);
		fishAndsize.put("Bass", 420);
		fishAndsize.put("SunFish", 200);
		fishAndsize.put("Guppy", 80);
		fishAndsize.put("Shark", 330);
		fishAndsize.put("FlowerHorn", 480);
		fishAndsize.put("Pike", 750);

		pondWithFishesExpected.put("PondSmall", new ArrayList<>(Arrays.asList("GoldenFish", "Guppy", "Bass", "FlowerHorn", "GoldenFish", "Bass", "FlowerHorn", "FlowerHorn", "Guppy", "Guppy")));
		Pond pond = mock(Pond.class);
        doReturn(pondWithFishesExpected).when(pond).addingFishesToPond(pondName, capacity, fishAndsize);
        
        assertEquals(pondWithFishesExpected, pond.addingFishesToPond(pondName, capacity, fishAndsize));
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	void doCheckingException() {
		exception.expect(NullPointerException.class);
		exception.expectMessage("NO SUCH POND");
		pond.getPondCapacity("37");
	}

}



