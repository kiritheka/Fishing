package try4;

import java.util.HashMap;

public class Fish {

   public HashMap<String, Integer> fishSpeciesAvailble() {
		HashMap<String, Integer> fishAndsize = new HashMap<String, Integer>();
		fishAndsize.put("GoldenFish", 140);
		fishAndsize.put("Bass", 420);
		fishAndsize.put("SunFish", 200);
		fishAndsize.put("Guppy", 80);
		fishAndsize.put("Shark", 330);
		fishAndsize.put("FlowerHorn", 480);
		fishAndsize.put("Pike", 750);
		
	return fishAndsize;
	}

}
