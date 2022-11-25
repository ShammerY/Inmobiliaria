package model;

public class Appartment{

	private String owner;
	private String tenant;
	private int number;
	private double value;
	private int roomNumber;
	private int bathNumber;
	private String haveBalcony;
	private boolean available;

	public Appartment(int aNumber, double aValue, int aRoomNumber, int aBathNumber, String aHaveBalcony){

		number = aNumber;
		value = aValue;
		roomNumber = aRoomNumber;
		bathNumber = aBathNumber;
		haveBalcony = aHaveBalcony;
		available = true;
	}
	public int getNumber(){
		return number;
	}
	public double getValue(){
		return value;
	}
	public int getRoomNumber(){
		return roomNumber;
	}
	public int getBathNumber(){
		return bathNumber;
	}
	public String getBalcony(){
		return haveBalcony;
	}
	public boolean getAvailable(){
		return available;
	}
	public void setAvailable(){
		available = false;
	}
	public void setTenant(String name){
		tenant = name;
	}
}