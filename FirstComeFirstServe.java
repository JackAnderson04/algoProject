package project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class FirstComeFirstServe {
	
	public static void main(String args[]) throws IOException {		
		String shows[] = new String[99];
        int years[] = new int[99];
        int times[][] = new int[99][3];
        
        BufferedReader br = new BufferedReader(new FileReader("Radio Schedule.txt"));
        for (int i = 0; i < 99; i++) {
        	shows[i] = br.readLine();
        	int w = 0;
        	while(w < 10) {
        		br.readLine();
        		w++;
        	}
        }
        BufferedReader br2 = new BufferedReader(new FileReader("Radio Schedule.txt"));
       
        br2.readLine();
        br2.readLine();
        for (int i = 0; i < 99; i++) {
        	years[i] = Integer.parseInt(br2.readLine());
        	int w = 0;
        	while(w < 10) {
        		br2.readLine();
        		w++;
        	}
        }
        BufferedReader br3 = new BufferedReader(new FileReader("Radio Schedule.txt"));
        
        int time = 0;
        int index = 0;
       
		mergeSort object = new mergeSort();
		ArrayList<String> finalList = new ArrayList<String>(years.length);
        finalList = object.switchs(years, shows);
        ArrayList<String> reverseList = new ArrayList<String>(years.length);
        reverseList = object.reverse(finalList);
        

		ArrayList<String> schedule = new ArrayList<String>();
		
		int num = 0;
		while(num < 84) {
			schedule.add("0");
			num++;
		}
		
		System.out.println(reverseList);
		for (int i = 0; i < reverseList.size(); i++) {
			for (int j = 0; j < shows.length; j++) {
				if (reverseList.get(i).equals(shows[j])) {
					br3.mark(90000);
					String tempName = br3.readLine();
				    while(!tempName.equals(reverseList.get(i))) {
				    	tempName = br3.readLine();
				    }
				    
				    br3.readLine();
					br3.readLine();
					br3.readLine();
					
					for(int k = 0; k < 3; k++) {
						
					String temp = br3.readLine();
	        		if(temp.equals("Monday")) {
	            		String line = br3.readLine();
	            		String newLine = line.split("-")[0];
	            		if(newLine.contains("pm")){
	            			String timeLine = newLine.split(":")[0];
	            			time = Integer.parseInt(timeLine) + 12;
	            			if (time == 24) {
	            				time = time - 12;
	            			}
	            			if(time == 12) {
	            				index = 4;
	            			}
	            			else if(time == 13) {
	            				index = 5;
	            			}
	            			else if(time == 14) {
	            				index = 6;
	            			}
	            			else if(time == 15) {
	            				index = 7;
	            			}
	            			else if(time == 16) {
	            				index = 8;
	            			}
	            			else if(time == 17) {
	            				index = 9;
	            			}
	            			else if(time == 18) {
	            				index = 10;
	            			}
	            			else if(time == 19) {
	            				index = 11;
	            			}
	            			else {
	            				index = 300;
	            			}
	            		}
	            		else {
	            			String timeLine = newLine.split(":")[0];
	            			time = Integer.parseInt(timeLine)* 1;        
	            			if(time == 8) {
	            				index = 0;
	            			}
	            			else if(time == 9) {
	            				index = 1;
	            			}
	            			else if(time == 10) {
	            				index = 2;
	            			}
	            			else if(time == 11) {
	            				index = 3;
	            			}
	            		}
	            		if(index == 300) {
	            			k++;
            			}
	            		else if(schedule.get(index).equals("0")) {
	    		        	schedule.add(index, reverseList.get(i));
	    		        	schedule.remove(index+1);
	    		        	break;
	            		}
	            		else {
	    		        	k++;
	    		        }
	            	}
	        		else if(temp.equals("Tuesday")) {
	            		String line = br3.readLine();
	            		String newLine = line.split("-")[0];
	            		if(newLine.contains("pm")){
	            			String timeLine = newLine.split(":")[0];
	            			time = Integer.parseInt(timeLine) + 12;
	            			if (time == 24) {
	            				time = time - 12;
	            			}
	            			if(time == 12) {
	            				index = 4+12;
	            			}
	            			else if(time == 13) {
	            				index = 5+12;
	            			}
	            			else if(time == 14) {
	            				index = 6+12;
	            			}
	            			else if(time == 15) {
	            				index = 7+12;
	            			}
	            			else if(time == 16) {
	            				index = 8+12;
	            			}
	            			else if(time == 17) {
	            				index = 9+12;
	            			}
	            			else if(time == 18) {
	            				index = 10+12;
	            			}
	            			else if(time == 19) {
	            				index = 11+12;
	            			}
	            			else {
	            				index = 300;
	            			}
	            		}
	            		else {
	            			String timeLine = newLine.split(":")[0];
	            			time = Integer.parseInt(timeLine)* 1;
	         
	            			if(time == 8) {
	            				index = 0+12;
	            			}
	            			else if(time == 9) {
	            				index = 1+12;
	            			}
	            			else if(time == 10) {
	            				index = 2+12;
	            			}
	            			else if(time == 11) {
	            				index = 3+12;
	            			}
	            		}
	            		if(index == 300) {
	            			k++;
            			}
	            		else if(schedule.get(index).equals("0")) {
	    		        	schedule.add(index, reverseList.get(i));
	    		        	schedule.remove(index+1);
	    		        	break;
	            		}
	            		else {
	    		        	k++;
	    		        }
	            	}
	        		else if(temp.equals("Wednesday")) {
	            		String line = br3.readLine();
	            		String newLine = line.split("-")[0];
	            		if(newLine.contains("pm")){
	            			String timeLine = newLine.split(":")[0];
	            			time = Integer.parseInt(timeLine) + 12;
	            			if (time == 24) {
	            				time = time - 12;
	            			}
	            			if(time == 12) {
	            				index = 4+24;
	            			}
	            			else if(time == 13) {
	            				index = 5+24;
	            			}
	            			else if(time == 14) {
	            				index = 6+24;
	            			}
	            			else if(time == 15) {
	            				index = 7+24;
	            			}
	            			else if(time == 16) {
	            				index = 8+24;
	            			}
	            			else if(time == 17) {
	            				index = 9+24;
	            			}
	            			else if(time == 18) {
	            				index = 10+24;
	            			}
	            			else if(time == 19) {
	            				index = 11+24;
	            			}
	            			else {
	            				index = 300;
	            			}
	            		}
	            		else {
	            			String timeLine = newLine.split(":")[0];
	            			time = Integer.parseInt(timeLine)* 1;        
	            			if(time == 8) {
	            				index = 0+24;
	            			}
	            			else if(time == 9) {
	            				index = 1+24;
	            			}
	            			else if(time == 10) {
	            				index = 2+24;
	            			}
	            			else if(time == 11) {
	            				index = 3+24;
	            			}
	            		}
	            		if(index == 300) {
	            			k++;
            			}
	            		else if(schedule.get(index).equals("0")) {
	            			
	    		        	schedule.add(index, reverseList.get(i));
	    		        	schedule.remove(index+1);
	    		        	break;
	            		}
	            		else {
	    		        	k++;
	    		        }
	            	}
	        		else if(temp.equals("Thursday")) {
	            		String line = br3.readLine();
	            		String newLine = line.split("-")[0];
	            		if(newLine.contains("pm")){
	            			String timeLine = newLine.split(":")[0];
	            			time = Integer.parseInt(timeLine) + 12;
	            			if (time == 24) {
	            				time = time - 12;
	            			}
	            			if(time == 12) {
	            				index = 4+36;
	            			}
	            			else if(time == 13) {
	            				index = 5+36;
	            			}
	            			else if(time == 14) {
	            				index = 6+36;
	            			}
	            			else if(time == 15) {
	            				index = 7+36;
	            			}
	            			else if(time == 16) {
	            				index = 8+36;
	            			}
	            			else if(time == 17) {
	            				index = 9+36;
	            			}
	            			else if(time == 18) {
	            				index = 10+36;
	            			}
	            			else if(time == 19) {
	            				index = 11+36;
	            			}
	            			else {
	            				index = 300;
	            			}
	            		}
	            		else {
	            			String timeLine = newLine.split(":")[0];
	            			time = Integer.parseInt(timeLine)* 1;         
	            			if(time == 8) {
	            				index = 0+36;
	            			}
	            			else if(time == 9) {
	            				index = 1+36;
	            			}
	            			else if(time == 10) {
	            				index = 2+36;
	            			}
	            			else if(time == 11) {
	            				index = 3+36;
	            			}
	            		}
	            		if(index == 300) {
            				k++;
            			}
	            		else if(schedule.get(index).equals("0")) {	
	    		        	schedule.add(index, reverseList.get(i));
	    		        	schedule.remove(index+1);
	    		        	break;
	            		}
	            		else {
	    		        	k++;
	    		        }
	            	}
	        		else if(temp.equals("Friday")) {
	            		String line = br3.readLine();
	            		String newLine = line.split("-")[0];
	            		if(newLine.contains("pm")){
	            			String timeLine = newLine.split(":")[0];
	            			time = Integer.parseInt(timeLine) + 12;
	            			if (time == 24) {
	            				time = time - 12;
	            			}
	            			if(time == 12) {
	            				index = 4+48;
	            			}
	            			else if(time == 13) {
	            				index = 5+48;
	            			}
	            			else if(time == 14) {
	            				index = 6+48;
	            			}
	            			else if(time == 15) {
	            				index = 7+48;
	            			}
	            			else if(time == 16) {
	            				index = 8+48;
	            			}
	            			else if(time == 17) {
	            				index = 9+48;
	            			}
	            			else if(time == 18) {
	            				index = 10+48;
	            			}
	            			else if(time == 19) {
	            				index = 11+48;
	            			}
	            			else {
	            				index = 300;
	            			}
	            		}
	            		else {
	            			String timeLine = newLine.split(":")[0];
	            			time = Integer.parseInt(timeLine)* 1;         
	            			if(time == 8) {
	            				index = 0+48;
	            			}
	            			else if(time == 9) {
	            				index = 1+48;
	            			}
	            			else if(time == 10) {
	            				index = 2+48;
	            			}
	            			else if(time == 11) {
	            				index = 3+48;
	            			}
	            		}
	            		if(index == 300) {
	            			k++;
            			}
	            		else if(schedule.get(index).equals("0")) {
	    		        	schedule.add(index, reverseList.get(i));
	    		        	schedule.remove(index+1);
	    		        	break;
	            		}
	            		else {
	    		        	k++;
	    		        }
	            	}
	        		else if(temp.equals("Saturday")) {
	            		String line = br3.readLine();
	            		String newLine = line.split("-")[0];
	            		if(newLine.contains("pm")){
	            			String timeLine = newLine.split(":")[0];
	            			time = Integer.parseInt(timeLine) + 12;
	            			if (time == 24) {
	            				time = time - 12;
	            			}
	            			if(time == 12) {
	            				index = 4+60;
	            			}
	            			else if(time == 13) {
	            				index = 5+60;
	            			}
	            			else if(time == 14) {
	            				index = 6+60;
	            			}
	            			else if(time == 15) {
	            				index = 7+60;
	            			}
	            			else if(time == 16) {
	            				index = 8+60;
	            			}
	            			else if(time == 17) {
	            				index = 9+60;
	            			}
	            			else if(time == 18) {
	            				index = 10+60;
	            			}
	            			else if(time == 19) {
	            				index = 11+60;
	            			}
	            			else {
	            				index = 300;
	            			}
	            		}
	            		else {
	            			String timeLine = newLine.split(":")[0];
	            			time = Integer.parseInt(timeLine)* 1;     
	            			if(time == 8) {
	            				index = 0+60;
	            			}
	            			else if(time == 9) {
	            				index = 1+60;
	            			}
	            			else if(time == 10) {
	            				index = 2+60;
	            			}
	            			else if(time == 11) {
	            				index = 3+60;
	            			}
	            		}
	            		if(index == 300) {
	            			k++;
            			}
	            		else if(schedule.get(index).equals("0")) {
	    		        	schedule.add(index, reverseList.get(i));
	    		        	schedule.remove(index+1);
	    		        	break;
	            		}
	            		else {
	    		        	k++;
	    		        }
	            	}
	        		else if(temp.equals("Sunday")) {
	            		String line = br3.readLine();
	            		String newLine = line.split("-")[0];
	            		if(newLine.contains("pm")){
	            			String timeLine = newLine.split(":")[0];
	            			time = Integer.parseInt(timeLine) + 12;
	            			if (time == 24) {
	            				time = time - 12;
	            			}
	            			if(time == 12) {
	            				index = 4+72;
	            			}
	            			else if(time == 13) {
	            				index = 5+72;
	            			}
	            			else if(time == 14) {
	            				index = 6+72;
	            			}
	            			else if(time == 15) {
	            				index = 7+72;
	            			}
	            			else if(time == 16) {
	            				index = 8+72;
	            			}
	            			else if(time == 17) {
	            				index = 9+72;
	            			}
	            			else if(time == 18) {
	            				index = 10+72;
	            			}
	            			else if(time == 19) {
	            				index = 11+72;
	            			}
	            			else {
	            				index = 300;
	            			}
	            		}
	            		else {
	            			String timeLine = newLine.split(":")[0];
	            			time = Integer.parseInt(timeLine)* 1;
	            			if(time == 8) {
	            				index = 0+72;
	            			}
	            			else if(time == 9) {
	            				index = 1+72;
	            			}
	            			else if(time == 10) {
	            				index = 2+72;
	            			}
	            			else if(time == 11) {
	            				index = 3+72;
	            			}
	            		}
	            	}
	        		if(index == 300) {
	        			k++;
        			}
	        		else if(schedule.get(index).equals("0")) {
            			
    		        	schedule.add(index, reverseList.get(i));
    		        	schedule.remove(index+1);
    		        	break;
            		}
	        		else {
			        	k++;
			        }
	            	
					}
					br3.reset();
				}
			}
		}
		
		
		System.out.print(schedule);
		
		System.out.println("");
		System.out.println("Final Radio Schedule:  ");
    	System.out.println("");
    	String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	    for (int i = 0; i < schedule.size(); i++) {
	    	int ind = i / 12; 
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
    		System.out.println(daysOfWeek[ind] + " from " + sTime + ":00" + sAmPm + " to " + eTime + ":00" + eAmPm + ":");
	    	if(schedule.get(i) != null) {
    			System.out.println(schedule.get(i));
	    	}
	    	else {
                System.out.println("This slot is blank");
            }
	    	System.out.println("");
	    }
	}
}
