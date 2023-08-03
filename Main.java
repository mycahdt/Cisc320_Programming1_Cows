package chasePractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create HashMap with the Cow's ID as the key and the Cow object as the value
		HashMap<Integer, Cow> cows = new HashMap<Integer, Cow>();
		
		//Create an ArrayList of Cows
		List<Cow> cowList = new ArrayList<>(); //this is O(n)
		
		try {
				
			//Reads the File
			
			File myObj = new File(args[1]);
				//File myObj = new File("/Users/mycahdetorres/chase/chasePractice/src/chasePractice/words.txt");
			Scanner myReader = new Scanner (myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
								   
				//splits the line by spaces
				String[] arrOfStr = data.split(" ");
					
				//4 pieces of information (id, letter, info, timestamp)
				int myId = Integer.parseInt(arrOfStr[0]);
				String myLetter = arrOfStr[1];
				int myInfo = Integer.parseInt(arrOfStr[2]);
				int myTimestamp = Integer.parseInt(arrOfStr[3]);
										
				
				//Checks to see if the given id is already present in the Hashmap
				if(cows.containsKey(myId)){  //this is O(1)
					
					//Changes an existing Cow's fields
					if(myLetter.equals("W")) {
						cows.get(myId).setLatestWeight(myInfo);
						cows.get(myId).setLowestWeight(cows.get(myId).getLowestWeight(), cows.get(myId).getLatestWeight());
					} else if (myLetter.equals("M")) {
						cows.get(myId).setMilk(myInfo);
						cows.get(myId).setMilkNum(cows.get(myId).getMilkNum());
						cows.get(myId).setAvgMilkProduction(cows.get(myId).getMilk(), cows.get(myId).getMilkNum());
					} else if (myLetter.equals("T")) {
						cows.get(myId).setTemp(myInfo);
					}	
				} else {
					//Creates a new Cow and puts it into the Hashmap
					//and adds it to the ArrayList
					Cow myCow = new Cow(myId, myLetter, myInfo, myTimestamp);
					cows.put(myId, myCow);
					cowList.add(myCow);
				}
				
				
				/*	
				for(int i = 0; i<arrOfStr.length; i++) {
					System.out.println(arrOfStr[i]);
				}
				*/
			
			}
			myReader.close();
				
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
				
		//Uses Comparator to group the Hashmap by LowestWight, then LatestWight, then AvgMilkProduction
		Comparator<Cow> groupByComparator = Comparator.comparingInt(Cow::getLowestWeight).thenComparing(Cow::getLatestWeight).thenComparing(Cow::getAvgMilkProduction);
		//This is O(n)
		
		//Uses Collections.sort to sort the ArrayList
		Collections.sort(cowList, groupByComparator);
		//This is O(n*log(n))
		
		
		//Prints out the Cow's id, lowest weight, latest weight, 
		//and average milk production
		//This is O(n)
		for(int i = 0; i < cowList.size(); i++) {   
			if( cowList.get(i).getLowestWeight() != 0 && cowList.get(i).getMilkNum() != 0) {
				System.out.println(cowList.get(i).getId() + " " + cowList.get(i).getLowestWeight() + " " + cowList.get(i).getLatestWeight() + " " + cowList.get(i).getAvgMilkProduction());
			}
	
		}  	
		
		
	}
}
