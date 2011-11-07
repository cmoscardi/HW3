package com.theory;

public class DormRoom implements Comparable<DormRoom>{
	private int occupancy;
	private int floorNumber;
	public DormRoom(int occupancy, int floorNumber) {
		this.occupancy=occupancy;
		this.floorNumber=floorNumber;
	}
	
	public int compareTo(DormRoom other){
		if(occupancy>other.getOccupancy()){
			return 1;
		}
		else if (occupancy==other.getOccupancy()){
			return 0;
		}
		else return -1;
	}
	
	public int getOccupancy(){
		return occupancy; 
	}
	
	public int getFloorNumber(){
		return floorNumber;
	}
}
