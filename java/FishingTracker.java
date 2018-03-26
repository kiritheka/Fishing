package try4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FishingTracker {

	public static void main(String[] args) {

		Fish fish = new Fish();
		Pond pond = new Pond();
		Fishing fishing = new Fishing();

		Scanner scan = new Scanner(System.in);
		 int preferedSize = 0;
		 int requiredNoOfFishes=0;
		 String pondName="";
		 try {
			 System.out.println("Enter the Size Prefered by fishermen");
			  preferedSize = scan.nextInt();	

				System.out.println("Enter the no of fishes he requires");
				 requiredNoOfFishes = scan.nextInt();
				 
					System.out.println("Enter the name Of pond");
				      pondName = scan.next();
			
				}
	        catch (java.util.InputMismatchException e) {
	        	System.out.println("Enter a proper INPUT  " + e);
	        }
		 
	

		HashMap<String, Integer> fishAndsize = fish.fishSpeciesAvailble();
		int Capacity = pond.getPondCapacity(pondName);
		HashMap<String, ArrayList<String>> pondWithFishes = pond.addingFishesToPond(pondName, Capacity, fishAndsize);
		ArrayList<String> fishBucket = fishing.goToFishing(pondName, pondWithFishes, fishAndsize, requiredNoOfFishes,
				preferedSize);
		System.out.println(("FisherMen Bucket After Fishing " + fishBucket));

		Set<String> unique = new HashSet<String>(fishBucket);
		for (String fishSpecies : unique) {
			System.out.println(fishSpecies + ": " + Collections.frequency(fishBucket, fishSpecies));
		}
	}
}

