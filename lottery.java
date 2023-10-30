package Lottery;

import java.util.ArrayList;
import java.util.Random;

public class lottery {
	public static ArrayList<Integer> LotteryOrder(int n) {
        Random random = new Random();
        ArrayList<Integer> finalOrder = new ArrayList<>();
	    ArrayList<Integer> availableNumbers = new ArrayList<>();
	    for (int i = 0; i <= n; i++) {
	    	availableNumbers.add(i);
	    }
	    while (!availableNumbers.isEmpty()) {
	    	int randomi = random.nextInt(availableNumbers.size());
	        int selectedNumber = availableNumbers.remove(randomi);
	            finalOrder.add(selectedNumber);
	        }

	        return finalOrder;
	    }
	public static String[] HashSchedule(ArrayList<Integer> Order, ArrayList<String> ShowNames){
		int count = 1;
		String[] schedule = new String[80];
		for(int i = 0; i < Order.size(); i++) {
			int j = Order.get(i);
			int key = j % 80;
			if (schedule[key] != null) {
				while (schedule[key] != null) {
					count +=1;
					key+=1;
					if (key > 79) {
						key = 0;
					}
					if (count > 80) {
						break;
					}
				}
			}
			schedule[key] = ShowNames.get(j);
			}
		return schedule;
	}

	public static void main(String[] args) {
		ArrayList<String> ShowNames = new ArrayList<String>();
		ShowNames.add("Alice");
		ShowNames.add("Bob");
		ShowNames.add("Charlie");
		ShowNames.add("David");
		ShowNames.add("Eva");
		ShowNames.add("Frank");
		ShowNames.add("Grace");
		ShowNames.add("Henry");
		ShowNames.add("Ivy");
		ShowNames.add("Jack");
		ShowNames.add("Katie");
		ShowNames.add("Liam");
		ShowNames.add("Mia");
		ShowNames.add("Nathan");
		ShowNames.add("Olivia");
		ShowNames.add("Patrick");
		ShowNames.add("Quinn");
		ShowNames.add("Rachel");
		ShowNames.add("Samuel");
		ShowNames.add("Tara");
		ShowNames.add("Ulysses");
		ShowNames.add("Violet");
		ShowNames.add("William");
		ShowNames.add("Xander");
		ShowNames.add("Yasmine");
		ShowNames.add("Zachary");
		ShowNames.add("Ava");
		ShowNames.add("Benjamin");
		ShowNames.add("Catherine");
		ShowNames.add("Daniel");
		ShowNames.add("Emily");
		ShowNames.add("Fiona");
		ShowNames.add("George");
		ShowNames.add("Hannah");
		ShowNames.add("Isaac");
		ShowNames.add("Jessica");
		ShowNames.add("Kevin");
		ShowNames.add("Lily");
		ShowNames.add("Michael");
		ShowNames.add("Natalie");
		ShowNames.add("Oscar");
		ShowNames.add("Penelope");
		ShowNames.add("Quincy");
		ShowNames.add("Riley");
		ShowNames.add("Samantha");
		ShowNames.add("Thomas");
		ShowNames.add("Uma");
		ShowNames.add("Victoria");
		ShowNames.add("Wesley");
		ShowNames.add("Xia");
		ShowNames.add("Yael");
		ShowNames.add("Zane");
		ShowNames.add("Amelia");
		ShowNames.add("Bryce");
		ShowNames.add("Chloe");
		ShowNames.add("Dylan");
		ShowNames.add("Ella");
		ShowNames.add("Finn");
		ShowNames.add("Grace");
		ShowNames.add("Hazel");
		ShowNames.add("Isaiah");
		ShowNames.add("Jasmine");
		ShowNames.add("Kai");
		ShowNames.add("Lila");
		ShowNames.add("Mason");
		ShowNames.add("Nora");
		ShowNames.add("Oliver");
		ShowNames.add("Peyton");
		ShowNames.add("Quinn");
		ShowNames.add("Riley");
		ShowNames.add("Sophia");
		ShowNames.add("Theo");
		ShowNames.add("Uma");
		ShowNames.add("Violet");
		ShowNames.add("Winston");
		ShowNames.add("Xander");
		ShowNames.add("Yara");
		ShowNames.add("Zara");
		ShowNames.add("Aiden");
		ShowNames.add("Bella");
		ShowNames.add("Caleb");
		ShowNames.add("Delilah");
		ShowNames.add("Elijah");
		ShowNames.add("Felicity");
		ShowNames.add("Dan");
		ShowNames.add("Mari");
		int size = ShowNames.size();
	    ArrayList<Integer> Order = LotteryOrder(size - 1);
	    String[] schedule = HashSchedule(Order, ShowNames);
	    System.out.println("Schedule in a random order: ");
	    for (int i = 0; i < schedule.length; i++) {
            if (schedule[i] == null) {
                System.out.println("blank " + i);
            } else {
                System.out.println(schedule[i] + " " + i);
            }
	    }
	}
}

	
