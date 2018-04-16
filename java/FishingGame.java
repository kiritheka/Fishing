package try5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FishingGame {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		PondDetails pondDetails = new PondDetails();
		FishDetails fishDetails = new FishDetails();
		int preferedSize = 0;
		int requiredNoOfFishes = 0;
		String pondName = "";

		try {
			System.out.println("Enter the name Of pond");
			pondName = scan.next();

			System.out.println("Enter the no of fishes he requires");
			requiredNoOfFishes = scan.nextInt();

			System.out.println("Enter the Size Prefered by fishermen");
			preferedSize = scan.nextInt();

		} catch (java.util.InputMismatchException e) {
			System.out.println("Enter a proper INPUT  " + e);
		}

		int position = pondDetails.getAvailablePonds().indexOf(pondName);
		int pondSize = pondDetails.getAvailablePonds().get(position).pondSize;
	    HashMap<String, ArrayList<Fish>> pondWithFishes = pondDetails.addFishesToPond(pondName, pondSize, fishDetails);
		
	    if ((requiredNoOfFishes <= pondSize)) {
			ArrayList<String> fishBucket = pondDetails.goToFishing(pondName, pondWithFishes, fishDetails,
					requiredNoOfFishes, preferedSize);
			System.out.println(("FisherMen Bucket After Fishing " + fishBucket));

			Set<String> unique = new HashSet<String>(fishBucket);
			for (String fishSpecies : unique) {
				System.out.println(fishSpecies + ": " + Collections.frequency(fishBucket, fishSpecies));
			}
		} else {
			System.out.println("Capacity of Pond is Lesser,So enter less no of fishes");
		}
	}

}
