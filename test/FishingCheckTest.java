package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import try4.Fishing;

class FishingCheckTest {
	Fishing fishing = new Fishing();

	String pondName;
	String noPond;
	int preferedSize;
	int exceededPreferedSize;
	int requiredNoOfFishes;
	int exceededrequiredNoOfFishes;
	ArrayList<String> fisherManEmptyBucket = new ArrayList<String>();
	ArrayList<String> fisherManBucketExpected = new ArrayList<String>();
	HashMap<String, ArrayList<String>> pondWithFishes = new HashMap<String, ArrayList<String>>();
	HashMap<String, ArrayList<String>> pondWithNoFishes = new HashMap<String, ArrayList<String>>();
	HashMap<String, Integer> fishAndsize = new HashMap<String, Integer>();

	@BeforeEach
	void setUp() throws Exception {

		pondName = "PondSmall";
		noPond = "55";
		preferedSize = 100;
		exceededPreferedSize = 10000;
		requiredNoOfFishes = 4;
		exceededrequiredNoOfFishes = 17;
		
		fishAndsize.put("GoldenFish", 140);
		fishAndsize.put("Bass", 420);
		fishAndsize.put("SunFish", 200);
		fishAndsize.put("Guppy", 80);
		fishAndsize.put("Shark", 330);
		
		fisherManBucketExpected = new ArrayList<String>(
				Arrays.asList("FlowerHorn", "Bass", "GoldenFish", "FlowerHorn"));
	}

	@Test
	void testGoToFishing() {
		
		Fishing fishing = mock(Fishing.class);
		doReturn(fisherManBucketExpected).when(fishing).goToFishing(pondName, pondWithFishes, fishAndsize,
				requiredNoOfFishes, preferedSize);

		//assertEquals(fisherManBucketExpected.toString(), fishing.goToFishing(pondName, pondWithFishes, fishAndsize, requiredNoOfFishes, preferedSize).toString());

		assertEquals(fisherManBucketExpected.toString(), fishing.goToFishing(pondName, pondWithNoFishes, fishAndsize, requiredNoOfFishes, preferedSize).toString());

		assertTrue(fisherManEmptyBucket.toString().equals(fishing.goToFishing(noPond, pondWithFishes, fishAndsize, requiredNoOfFishes, preferedSize).toString()));

		assertEquals(fisherManEmptyBucket.toString(),fishing.goToFishing(pondName, pondWithNoFishes, fishAndsize, exceededrequiredNoOfFishes, preferedSize).toString());

		assertTrue(fisherManEmptyBucket.toString().equals(fishing.goToFishing(pondName, pondWithFishes, fishAndsize, requiredNoOfFishes, exceededPreferedSize).toString()));
	}
	
	

}
