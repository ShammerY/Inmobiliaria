package model;

public abstract class Person{

	protected String id;
	protected IdType idType;
	protected String name;
	protected PhoneType phoneType;
	protected String phone;
	
	public Person(String id, int aidType, String name, int aphoneType, String phone){
		this.id = id;
		this.name = name;
		this.phone = phone;
		setIdType(aidType);
		setPhoneType(aphoneType);
	}

	public String getName(){
		return name;
	}
	public void setIdType(int type){
		switch(type){
			case 1:
				idType = IdType.CC;
				break;
			case 2:
				idType = IdType.TI;
				break;
			case 3:
				idType = IdType.OTHER;
				break;
		}
	}
	public void setPhoneType(int type){
		switch(type){
			case 1:
				phoneType = PhoneType.HOME;
				break;
			case 2:
				phoneType = PhoneType.OFFICE;
				break;
			case 3:
				phoneType = PhoneType.MOVIL;
				break;
			case 4:
				phoneType = PhoneType.FAMILY;
				break;
			case 5:
				phoneType = PhoneType.OTHER;
				break;
		}
	}
}