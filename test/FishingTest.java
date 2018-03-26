package test;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import try4.Fishing;

class FishingTest {

	@Test
	void testGoToFishing() {
		HashMap<String, ArrayList<String>> pondWithFishes = new HashMap<String, ArrayList<String>>();
		HashMap<String, Integer> fishAndsize = new HashMap<String, Integer>();
		ArrayList<String> fisherManBucketExpected = new ArrayList<String>();
		
		fishAndsize.put("GoldenFish", 140);
		fishAndsize.put("Bass", 420);
		fishAndsize.put("SunFish", 200);
		fishAndsize.put("Guppy", 80);
		fishAndsize.put("Shark", 330);
		fishAndsize.put("FlowerHorn", 480);
		fishAndsize.put("Pike", 750);
		
		String pondName = "PondSmall";
		int preferedSize =100;
		int requiredNoOfFishes=4;
		fisherManBucketExpected= new ArrayList<String>(Arrays.asList("FlowerHorn","Bass","GoldenFish","FlowerHorn"));
		pondWithFishes.put("PondSmall", new ArrayList<>(Arrays.asList("GoldenFish", "Guppy", "Bass", "FlowerHorn", "GoldenFish", "Bass", "FlowerHorn", "FlowerHorn", "Guppy", "Guppy")));

		
		Fishing fishing = mock(Fishing.class);
        doReturn(fisherManBucketExpected).when(fishing).goToFishing(pondName, pondWithFishes, fishAndsize, requiredNoOfFishes,
 				preferedSize);
		
	}

}
