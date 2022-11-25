package model;

public class Building{

	private Appartment[] appartments;
	private Tenant[] tenants;
	private Owner[] owners;
	private String name;
	private int appartmentNumber;
	private String adress;

	public Building(String aName, String aAdress, int aAppartmentNumber){
		appartmentNumber = aAppartmentNumber;
		appartments = new Appartment[aAppartmentNumber];
		tenants = new Tenant[aAppartmentNumber];
		owners = new Owner[aAppartmentNumber];
		name = aName;
		adress = aAdress;
	
	}

	public String getName(){
		return name;
	}
	public String getAdress(){
		return adress;
	}
	public int getAppartmentNumber(){
		return appartmentNumber;
	} 

	public String addAppartment(int number, double value,int roomNumber,int bathNumber,String balcony){
		String msj = "";
		int pos = -1;
		pos = searchAppartmentEmptyPos();
		if(pos != -1){
			appartments[pos] = new Appartment(number, value, roomNumber, bathNumber, balcony);
			msj = "\n APPARTMENT REGISTERED SUCCESFULLY";
		}else{msj = "\n APPARTMENT LIMIT REACHED";}
		return msj;
	}
	public int searchAppartmentEmptyPos(){
		int pos = -1;
		boolean isFound = false;
		for(int i = 0; i<appartmentNumber && isFound==false; i++){
			if(appartments[i] == null){
				pos = i;
				isFound = true;
			}
		}
		return pos;
	}
	public int searchAppartment(int number){
		int pos = -1;
		boolean isFound = false;
		for(int i = 0; i<appartments.length && isFound==false; i++){
			if(appartments[i]!=null){
				if(appartments[i].getNumber() == number && appartments[i].getAvailable() == true){
					pos = i;
					isFound = true;
				}
			}
		}
		return pos;
	}
	public String showAvailableAppartments(){
		String msj = "";
		int cont = 0;
		for(int i = 0; i<appartmentNumber; i++){
			if(appartments[i]!=null){
				if(appartments[i].getAvailable()==true){
					cont++;
					msj += ""+
					"\n   APPARTMENT NUMBER : "+ appartments[i].getNumber()+
					"\n       MENSUAL VALUE : $"+ appartments[i].getValue()+
					"\n     NUMBER OF ROOMS : "+ appartments[i].getRoomNumber()+
					"\n NUMBER OF BATHROOMS : "+ appartments[i].getBathNumber()+
					"\n             BALCONY : "+ appartments[i].getBalcony()+"\n";
				}
			}
		}
		if(cont == 0){
			msj = "\n NO AVAILABLE APPARTMENTS";
		}
		return msj;
	}
	public int searchOwnerEmptyPos(){
		int pos = -1;
		boolean isFound = false;
		for(int i = 0; i<tenants.length && isFound==false; i++){
			if(owners[i] == null){
				pos = i;
				isFound = true;
			}
		}
		return pos;
	}
	public void addOwner(String personName,int idType,String id,int phoneType,String phone,String bank,String bankNumber){
		int pos = searchOwnerEmptyPos();
		owners[pos] = new Owner(id, idType,personName, phoneType, phone, bank, bankNumber);
	}
	public int searchTenant(String name){
		int pos = -1;
		boolean isFound = false;
		for(int i = 0; i<tenants.length && isFound==false; i++){
			if(tenants[i]!=null){
				if(tenants[i].getName().equals(name)){
					pos = i;
					isFound = true;
				}
			}
		}
		return pos;
	}
	public int searchTenantEmptyPos(){
		int pos = -1;
		boolean isFound = false;
		for(int i = 0; i<tenants.length && isFound==false; i++){
			if(tenants[i] == null){
				pos = i;
				isFound = true;
			}
		}
		return pos;
	}
	public void setTenant(String name,int idType,String id,int phoneType,String phone,int appartmentPos){
		int pos = -1;
		pos = searchTenantEmptyPos();
		tenants[pos] = new Tenant( id, idType, name, phoneType, phone);
		appartments[appartmentPos].setAvailable();
		appartments[appartmentPos].setTenant(name);
	}
}