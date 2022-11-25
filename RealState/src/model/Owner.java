package model;

public final class Owner extends Person{

	private String bankName;
	private String bankNumber;

	public Owner(String id, int idType, String name, int phoneType, String phone, String bankName, String bankNumber){
		super(id, idType, name, phoneType,  phone);
		this.bankName = bankName;
		this.bankNumber = bankNumber;
		
	}
}