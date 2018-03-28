package try4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Pond {
	Fish fish = new Fish();

	public int getPondCapacity(String pondName) {
		HashMap<String, Integer> pondMaxCapacity = new HashMap<String, Integer>();
		int Capacity = 0;
		pondMaxCapacity.put("PondSmall", 10);
		pondMaxCapacity.put("PondMedium", 100);
		pondMaxCapacity.put("PondBig", 150);

		try {
			Capacity = pondMaxCapacity.get(pondName);
			System.out.println("capacity of given pond = " + Capacity);
		} catch (NullPointerException e) {
			System.out.println("Enter a Correct PondName " + e);
		}
		return Capacity;
	}

	public HashMap<String, ArrayList<String>> addFishesToPond(String PondName, int Capacity,
			HashMap<String, Integer> fishAndsize) {

		ArrayList<String> randomfishesInPond = new ArrayList<String>();
		HashMap<String, ArrayList<String>> pondWithFishes = new HashMap<String, ArrayList<String>>();
		Random random = new Random();

		List<String> keys = new ArrayList<String>(fishAndsize.keySet());
		for (int i = 0; i < Capacity; i++) {
			randomfishesInPond.add(keys.get(random.nextInt(keys.size())));
		}
		pondWithFishes.put(PondName, randomfishesInPond);
		System.out.println("fishesInPond  " + "\n" + pondWithFishes + "\n");
		return pondWithFishes;
	}
}
