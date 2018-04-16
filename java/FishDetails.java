package try5;

import java.util.ArrayList;
import java.util.List;

public class FishDetails {

	Fish goldenFish = new Fish("GoldenFish", 140);
	Fish bass = new Fish("Bass", 420);
	Fish sunFish = new Fish("SunFish", 200);
	Fish guppy = new Fish("Guppy", 80);
	Fish shark = new Fish("Shark", 330);
	Fish flowerHorn = new Fish("FlowerHorn", 480);
	Fish pike = new Fish("Pike", 750);

	public List<Fish> getAvailableFishes() {
		List<Fish> availableFishes = new ArrayList<Fish>();
		availableFishes.add(goldenFish);
		availableFishes.add(bass);
		availableFishes.add(sunFish);
		availableFishes.add(guppy);
		availableFishes.add(shark);
		availableFishes.add(flowerHorn);
		availableFishes.add(pike);
		return availableFishes;

	}

}
