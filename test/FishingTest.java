package test;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import try4.Fishing;

class FishingTest {
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	void testGoToFishing() {
		HashMap<String, ArrayList<String>> pondWithFishes = new HashMap<String, ArrayList<String>>();
		HashMap<String, ArrayList<String>> pondWithNoFishes = new HashMap<String, ArrayList<String>>();
		HashMap<String, Integer> fishAndsize = new HashMap<String, Integer>();
		ArrayList<String> fisherManBucketExpected = new ArrayList<String>();
		ArrayList<String> fisherManEmptyBucket = new ArrayList<String>();

		fishAndsize.put("GoldenFish", 140);
		fishAndsize.put("Bass", 420);
		fishAndsize.put("SunFish", 200);
		fishAndsize.put("Guppy", 80);
		fishAndsize.put("Shark", 330);
		fishAndsize.put("FlowerHorn", 480);
		fishAndsize.put("Pike", 750);

		String pondName = "PondSmall";
		String noPond = "";
		int preferedSize = 100;
		int exceededPreferedSize = 10000;
		int requiredNoOfFishes = 4;
		int exceededrequiredNoOfFishes = 17;

		fisherManBucketExpected = new ArrayList<String>(Arrays.asList("FlowerHorn", "Bass", "GoldenFish", "FlowerHorn"));
		fisherManEmptyBucket = new ArrayList<String>(Arrays.asList(""));
		pondWithFishes.put("PondSmall", new ArrayList<>(Arrays.asList("GoldenFish", "Guppy", "Bass", "FlowerHorn","GoldenFish", "Bass", "FlowerHorn", "FlowerHorn", "Guppy", "Guppy")));

		Fishing fishing = mock(Fishing.class);
		doReturn(fisherManBucketExpected).when(fishing).goToFishing(pondName, pondWithFishes, fishAndsize,
				requiredNoOfFishes, preferedSize);

		assertEquals(fisherManEmptyBucket.toString(), 
				fishing.goToFishing(pondName, pondWithNoFishes, fishAndsize, requiredNoOfFishes, preferedSize).toString());

		assertTrue(fisherManEmptyBucket.toString()
				.equals(fishing.goToFishing(noPond, pondWithFishes, fishAndsize, requiredNoOfFishes, preferedSize).toString()));

		assertEquals(fisherManEmptyBucket.toString(),
				fishing.goToFishing(pondName, pondWithNoFishes, fishAndsize, exceededrequiredNoOfFishes, preferedSize).toString());

		assertTrue(fisherManEmptyBucket.toString()
				.equals(fishing.goToFishing(pondName, pondWithFishes, fishAndsize, requiredNoOfFishes, exceededPreferedSize).toString()));

		exception.expect(NullPointerException.class);
		exception.expectMessage("NO SUCH POND");
		fishing.goToFishing(noPond, pondWithFishes, fishAndsize, requiredNoOfFishes, exceededPreferedSize).toString();

	}

}
