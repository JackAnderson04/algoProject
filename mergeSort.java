package project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class mergeSort {

    void merge(int arr[], int left, int mid, int right)
    {
        int n1 = mid - left + 1;
        int n2 = right - mid;
 
        int Left[] = new int[n1];
        int Right[] = new int[n2];
 
        for (int i = 0; i < n1; ++i)
            Left[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            Right[j] = arr[mid + 1 + j];
 
 
        int i = 0, j = 0;
 
        int k = left;
        while (i < n1 && j < n2) {
            if (Left[i] <= Right[j]) {
                arr[k] = Left[i];
                i++;
            }
            else {
                arr[k] = Right[j];
                j++;
            }
            k++;
        }
 
        while (i < n1) {
            arr[k] = Left[i];
            i++;
            k++;
        }
 
        while (j < n2) {
            arr[k] = Right[j];
            j++;
            k++;
        }
    }
 
    void sort(int arr[], int left, int right)
    {
        if (left < right) {
 
            int mid = left + (right - left) / 2;
 
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
 
            merge(arr, left, mid, right);
        }
        
    }
    
    ArrayList<String> switchs(int arr[], String[] names) {
    	int n = arr.length;
    	ArrayList<String> name2 = new ArrayList<String>(n);
        ArrayList<Integer> temp = new ArrayList<Integer>(n);
        for (int i = 0; i < n; ++i) {
    	    temp.add(arr[i]);
    	    name2.add(names[i]);
        }
   
        sort(arr, 0, arr.length-1);
        
        ArrayList<String> final2 = new ArrayList<String>(n);
        
        for (int i = 0; i < n; ++i) {
           int index = temp.indexOf(arr[i]);
           final2.add(name2.get(index));
           temp.remove(index);
           name2.remove(index);
        }
        return final2;
     }
  
    ArrayList<String> reverse(ArrayList<String> list) {
        for (int i = 0, j = list.size() - 1; i < j; i++) {
            list.add(i, list.remove(j));
        }
        return list;
    }

    
    public static void main(String args[]) throws IOException {
        String shows[] = new String[99];
        int years[] = new int[99];
        
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
        
        ArrayList<String> final2 = new ArrayList<String>(years.length);
        ArrayList<String> final3 = new ArrayList<String>(years.length);
        mergeSort object = new mergeSort();
        final2 = object.switchs(years, shows);
        System.out.println(final2);
        final3 = object.reverse(final2);
        System.out.println(final3);
        
     }
}
