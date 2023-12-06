package Lottery;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class lottery {
	public static ArrayList<Integer> LotteryOrder(int n) {
        Random random = new Random();
        ArrayList<Integer> finalOrder = new ArrayList<>();
	    ArrayList<Integer> availableNumbers = new ArrayList<>();
	    for (int i = 0; i < n; i++) {
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
		String[] schedule = new String[84];
		for(int i = 0; i < schedule.length; i++) {
			int j = Order.get(i);
			int key = i % 84; //8 to 8 7 days a week
			if (schedule[key] != null) {
				while (schedule[key] != null) {
					count += 1;
					key += 1;
					if (key > 83) {
						key = 0;
					}
					if (count > 84) {
						break;
					}
				}
			}
			schedule[key] = ShowNames.get(j);
			}
		return schedule;
	}

	public static void main(String[] args) {
        String fileName = "Radio Schedule (1).txt";
        ArrayList<String> showsAndNames = new ArrayList<>();
        ArrayList<String> filter = new ArrayList<>();
        filter.add("8:00am-9:00am");
        filter.add("9:00am-10:00am");
        filter.add("10:00am-11:00am");
        filter.add("11:00am-12:00pm");
        filter.add("12:00pm-1:00pm");
        filter.add("1:00pm-2:00pm");
        filter.add("2:00pm-3:00pm");
        filter.add("3:00pm-4:00pm");
        filter.add("4:00pm-5:00pm");
        filter.add("5:00pm-6:00pm");
        filter.add("6:00pm-7:00pm");
        filter.add("7:00pm-8:00pm");
        filter.add("8:00pm-9:00pm");
        filter.add("9:00pm-10:00pm");
        filter.add("10:00pm-11:00pm");
        filter.add("11:00pm-12:00am");
        filter.add("8:30am-9:00am");
        filter.add("9:30am-10:00am");
        filter.add("10:30am-11:00am");
        filter.add("11:30am-12:00pm");
        filter.add("12:30pm-1:00pm");
        filter.add("1:30pm-2:00pm");
        filter.add("2:30pm-3:00pm");
        filter.add("3:30pm-4:00pm");
        filter.add("4:30pm-5:00pm");
        filter.add("5:30pm-6:00pm");
        filter.add("6:30pm-7:00pm");
        filter.add("7:30pm-8:00pm");
        filter.add("8:30pm-9:00pm");
        filter.add("9:30pm-10:00pm");
        filter.add("10:30pm-11:00pm");
        filter.add("11:30pm-12:00am");
        filter.add("8:00am-8:30am");
        filter.add("9:00am-9:30am");
        filter.add("10:00am-10:30am");
        filter.add("11:00am-11:30am");
        filter.add("12:00pm-12:30pm");
        filter.add("1:00pm-1:30pm");
        filter.add("2:00pm-2:30pm");
        filter.add("3:00pm-3:30pm");
        filter.add("4:00pm-4:30pm");
        filter.add("5:00pm-5:30pm");
        filter.add("6:00pm-6:30pm");
        filter.add("7:00pm-7:30pm");
        filter.add("8:00pm-8:30pm");
        filter.add("9:00pm-9:30pm");
        filter.add("10:00pm-10:30pm");
        filter.add("11:00pm-11:30pm");
        filter.add("60");
        filter.add("30");
        filter.add("1");
        filter.add("2");
        filter.add("3");
        filter.add("4");
        filter.add("Monday");
        filter.add("Wednesday");
        filter.add("Tuesday");
        filter.add("Thursday");
        filter.add("Friday");
        filter.add("Saturday");
        filter.add("Sunday");
        filter.add("Sunday ");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty() && !filter.contains(line)) {
                    showsAndNames.add(line);
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> finalShowString = new ArrayList<>();
        //combine names and shows into one element "showname by djname"
        for (int i = 0; i+1 < showsAndNames.size(); i+=2) {
        	  String temp = showsAndNames.get(i) + " by " + showsAndNames.get(i+1);
        	  finalShowString.add(temp);
        }
		int size = finalShowString.size();
	    ArrayList<Integer> Order = LotteryOrder(size);
	    String[] schedule = HashSchedule(Order, finalShowString);
	    String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	    System.out.println("Final Radio Schedule:  ");
    	System.out.println("");
	    for (int i = 0; i < schedule.length; i++) {
	    	int index = i / 12; 
	    	int sTime = i % 12;
	   		sTime = sTime + 8;
	   		int eTime = sTime + 1;
            String sAmPm = "am";
            String eAmPm = "am";
            if (sTime > 12) {
                sAmPm = "pm";
                eAmPm = "pm";
                sTime -= 12;
                eTime -= 12;
            }
            else if (sTime == 12){
                sAmPm = "pm";
                eAmPm = "pm";
                eTime -= 12;
            }
            else if (sTime == 11) {
                eAmPm = "pm";
            }
    		System.out.println(daysOfWeek[index] + " from " + sTime + ":00" + sAmPm + " to " + eTime + ":00" + eAmPm + ":");
	    	if(schedule[i] != null) {
    			System.out.println(schedule[i]);
	    	}
	    	else {
                System.out.println("This slot is blank");
            }
	    	System.out.println("");
	    }
	}
}

