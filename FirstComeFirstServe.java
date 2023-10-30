package project;

import java.util.ArrayList;


public class FirstComeFirstServe {
	
	public static void main(String args[]) {
		ArrayList<String> names = new ArrayList<String>();
		//ArrayList<ArrayList<Integer>> listOfTimes = new ArrayList<ArrayList<Integer>>();
		int[][] times = {{5, 4, 3}, {5, 5, 2}, {5, 4, 3}, {1, 6, 7}};
		ArrayList<String> schedule = new ArrayList<String>();
		schedule.add("0");
		schedule.add("0");
		schedule.add("0");
		schedule.add("0");
		schedule.add("0");
		schedule.add("0");
		ArrayList<String> word = new ArrayList<String>();
		names.add("Mike");
		names.add("Luke");
		names.add("Todd");
		names.add("Charlie");
		
		
		for(int i = 0; i < names.size(); i++) {
			int j = 0;
			while(j < times[i].length) {
				int x = times[i][j];
		        if(schedule.get(x).equals("0")) {
		        	schedule.add(x, names.get(i));
		        	schedule.remove(x+1);
		        	break;
		        }
		        else {
		        	j++;
		        }
			}
		}
		System.out.print(schedule);
		
		
	}
	
}
