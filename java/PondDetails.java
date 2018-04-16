package try5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class PondDetails {

	Pond smallPond = new Pond("smallPond", 10);
	Pond mediumPond = new Pond("MediumlPond", 50);
	Pond largePond = new Pond("LargePond", 70);

	public List<Pond> getAvailablePonds() {
		List<Pond> availablePonds = new ArrayList<Pond>();
		availablePonds.add(smallPond);
		availablePonds.add(mediumPond);
		availablePonds.add(largePond);

		return availablePonds;
	}

	public HashMap<String, ArrayList<Fish>> addFishesToPond(String pondName, int pondSize, FishDetails fishDetails) {

		ArrayList<Fish> randomfishesInPond = new ArrayList<Fish>();
		HashMap<String, ArrayList<Fish>> pondWithFishes = new HashMap<String, ArrayList<Fish>>();
		Random random = new Random();
		List<Fish> availableFishes = new ArrayList<Fish>(fishDetails.getAvailableFishes());
		
		for (int i = 0; i < pondSize; i++) {
			randomfishesInPond.add(availableFishes.get(random.nextInt(availableFishes.size())));
		}
		pondWithFishes.put(pondName, randomfishesInPond);
		System.out.println("fishes in pond  " + "\n" + pondWithFishes + "\n");

		return pondWithFishes;
	}

	public ArrayList<String> goToFishing(String pondName, HashMap<String, ArrayList<Fish>> pondWithFishes,
			FishDetails fishDetails, int requiredNoOfFishes, int preferedSize) {

		ArrayList<String> fisherManBucket = new ArrayList<String>();
		int pondCapacity = pondWithFishes.get(pondName).size();
		try {
			Random random = new Random();
			int count = 0;
			while (fisherManBucket.size() != requiredNoOfFishes) {
				int randomFish = random.nextInt(pondWithFishes.get(pondName).size());
				Fish fishNowCaught = pondWithFishes.get(pondName).get(randomFish);
				System.out.println("Current Fish " + fishNowCaught.fishName);

				if (fishNowCaught.fishSize >= preferedSize) {
					fisherManBucket.add(fishNowCaught.fishName);
					pondWithFishes.get(pondName).remove(randomFish);
					System.out.println(fishNowCaught.fishName + " removed from pond and added to bucket ");
					System.out.println();
				} else {
					System.out.println(fishNowCaught.fishName + " is of not PrefferedSize" + "\n");
				}
				count++;

				if (count > pondCapacity) {
					System.out.println("NO MORE FISHES OF PREFFERED SIZE IN POND" + "\n");
					break;
				}
			}
		} catch (IllegalArgumentException e) {
			System.out.println("There is no pond with such a name " + e);
		}
		System.out.println("After Fishing Remaining Fishes in Pond   " + pondWithFishes.get(pondName).size() + "\n");

		return fisherManBucket;
	}
}
