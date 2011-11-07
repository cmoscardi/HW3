package com.theory;

import java.util.Arrays;
import java.util.Collections;

public class DormTest {
	
	
	public static void main (String[] args){
		//creating a bunch of dorm rooms
		DormRoom[] cats= new DormRoom[20];
		System.out.println("Floor -- Size");
		for(int i=0;i<20;i++){
			int floorNumber = (int) (20*Math.random()+1);
			int size = (int) (20*Math.random()+1);
			System.out.println(floorNumber+"    " +size);
			cats[i]=new DormRoom(size,floorNumber);
		}
		//comparable test
		System.out.println("sorted by occupancy using comparable");
		Collections.sort(Arrays.asList(cats));
		System.out.println("Floor -- Size");
		for(int i=0;i<20;i++){
			System.out.println(cats[i].getFloorNumber()+"    " +cats[i].getOccupancy());
		}
		//comparable test 1
		Collections.sort(Arrays.asList(cats), DormRoom.compareByFloorNumber());
		System.out.println("sorted by floor");
		System.out.println("Floor -- Size");
		for(int i=0;i<20;i++){
			System.out.println(cats[i].getFloorNumber()+"    " +cats[i].getOccupancy());
		}
		//comparable test 2
		Collections.sort(Arrays.asList(cats), DormRoom.compareByOccupancy());
		System.out.println("sorted by occupancy using comparator");
		System.out.println("Floor -- Size");
		for(int i=0;i<20;i++){
			System.out.println(cats[i].getFloorNumber()+"    " +cats[i].getOccupancy());
		}
	}
	
}
