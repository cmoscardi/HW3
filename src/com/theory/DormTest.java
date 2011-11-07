package com.theory;

import java.util.Arrays;
import java.util.Collections;

public class DormTest {
	//this is a test of the Comparable interface
	/**public static void main(String[] args){
		DormRoom[] cats = new DormRoom[20];
		for(int i=0;i<20;i++){
			int size = (int) (20*Math.random()+1);
			System.out.println(size);
			cats[i]=new DormRoom(size,1);
		}
		Collections.sort(Arrays.asList(cats));
		for(int i=0;i<20;i++){
			System.out.println(cats[i].getOccupancy());
		}
		
	}**/
	
	//This is a test of the comparator interface
	
	public static void main (String[] args){
		DormRoom[] cats= new DormRoom[20];
		System.out.println("Floor -- Size");
		for(int i=0;i<20;i++){
			int floorNumber = (int) (20*Math.random()+1);
			int size = (int) (20*Math.random()+1);
			System.out.println(floorNumber+"    " +size);
			cats[i]=new DormRoom(size,floorNumber);
		}
		Collections.sort(Arrays.asList(cats), DormRoom.compareByFloorNumber());
		System.out.println("sorted by floor");
		System.out.println("Floor -- Size");
		for(int i=0;i<20;i++){
			System.out.println(cats[i].getFloorNumber()+"    " +cats[i].getOccupancy());
		}
		Collections.sort(Arrays.asList(cats), DormRoom.compareByOccupancy());
		System.out.println("sorted by occupancy");
		System.out.println("Floor -- Size");
		for(int i=0;i<20;i++){
			System.out.println(cats[i].getFloorNumber()+"    " +cats[i].getOccupancy());
		}
	}
	
}
