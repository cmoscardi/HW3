package com.theory;

import java.util.Comparator;

/**
 * A super cool DormRoom
 * Compares by Occupancy if you're using comparable interface
 * @author Christian
 *
 */
public class DormRoom implements Comparable<DormRoom> {
	private int occupancy;
	private int floorNumber;
	public DormRoom(int occupancy, int floorNumber) {
		this.occupancy=occupancy;
		this.floorNumber=floorNumber;
	}
	
	/**
	 * Compare by occupancy
	 */
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

	public static Comparator<DormRoom> compareByOccupancy(){
		return new Comparator<DormRoom>(){
			public int compare(DormRoom a, DormRoom b){
				if(a.getOccupancy()>b.getOccupancy()){
					return 1;
				}
				else if(a.getOccupancy()==b.getOccupancy()){
					return 0;
				}
				else return -1;
			}
		};
	}

	public static Comparator<DormRoom> compareByFloorNumber(){
		return new Comparator<DormRoom>(){
			public int compare(DormRoom a, DormRoom b){
				if(a.getFloorNumber()>b.getFloorNumber()){
					return 1;
				}
				else if (a.getFloorNumber()==b.getFloorNumber()){
					return 0;
				}
				else return -1;
			}
		};
	}
}
