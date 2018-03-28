package try4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Fishing {

	public ArrayList<String> goToFishing(String pondName, HashMap<String, ArrayList<String>> pondWithFishes,
			HashMap<String, Integer> fishAndsize, int requiredNoOfFishes, int preferedSize) {

		ArrayList<String> fisherManBucket = new ArrayList<String>();
		int pondCapacity = pondWithFishes.get(pondName).size();

		try {
			Random random = new Random();
			int count = 0;
			while (fisherManBucket.size() != requiredNoOfFishes) {
				int randomFish = random.nextInt(pondWithFishes.get(pondName).size());
				String fishNowCaught = pondWithFishes.get(pondName).get(randomFish);
				System.out.println("Current Fish " + fishNowCaught);

				if (fishAndsize.get(fishNowCaught) >= preferedSize) {
					fisherManBucket.add(fishNowCaught);
					pondWithFishes.get(pondName).remove(randomFish);
					System.out.println(fishNowCaught + " removed from pond and added to bucket ");
					System.out.println();
				} else {
					System.out.println(fishNowCaught + " is of not PrefferedSize" + "\n");
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
