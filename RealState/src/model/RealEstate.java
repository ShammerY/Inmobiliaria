package model;

public class RealEstate{

	public static final int TOTAL_BUILDINGS = 10;
	private Building[] buildings;

	public RealEstate(){
		buildings = new Building[TOTAL_BUILDINGS];
	}

	public int searchBuilding(String name){
		int pos = -1;
		boolean isFound = false;
		for(int i = 0; i<TOTAL_BUILDINGS; i++){
			if(buildings[i] != null){
				if(buildings[i].getName().equals(name) && isFound==false){
					pos = i;
					isFound = true;
				}
			}
				
		}
		return pos;
	}
	public int searchBuildingEmptypos(){
		int pos = -1;
		boolean isFound = false;
		for(int i = 0; i<TOTAL_BUILDINGS && isFound==false; i++){
			if(buildings[i] == null ){
				pos = i;
				isFound = true;
			}
		}
		return pos;
	}
	public String addBuilding(String name, int appartmentNumber, String adress, int buildingPos){
		String msj = "";
		int pos = -1;
		pos = searchBuildingEmptypos();
		if(pos != -1){
			buildings[pos] = new Building(name,adress, appartmentNumber);
			msj = "\n BUILDING REGISTERED SUCCESFULLY";
		}else{msj = "\n REACHED LIMIT OF BUILDINGS";}
		return msj;
	}
	public String addAppartment(int number, double value,int roomNumber,int bathNumber,String balcony,int buildingPos){
		String msj = "";
		msj = buildings[buildingPos].addAppartment(number, value, roomNumber, bathNumber, balcony);
		return msj;
	}
	public String showBuildings(){
		String msj = "";
		for(int i = 0; i<TOTAL_BUILDINGS; i++){
			if(buildings[i]!=null){
				msj += "\n"+
				" BUILDING : "+ buildings[i].getName()+
				"   ADRESS : "+ buildings[i].getAdress()+"\n";
			}
		}
		return msj;
	}
	public String showAppartments(int buildingPos){
		String msj = "";
		msj = buildings[buildingPos].showAvailableAppartments();
		return msj;
	}
	public int searchAppartment(int buildingPos, int number){
		int pos = -1;
		pos = buildings[buildingPos].searchAppartment(number);
		return pos;
	}
	public int searchTenant(String name){
		int pos = -1;
		boolean isFound = false;
		for(int i = 0; i<TOTAL_BUILDINGS && isFound==false; i++){
			if(buildings[i]!=null){
				pos = buildings[i].searchTenant(name);
				if(pos!=-1){isFound=true;}
			}
		}
		return pos;
	}
	public void setTenant(String name,int  idType,String id,int phoneType,String phone,int buildingPos,int appartmentPos){
		buildings[buildingPos].setTenant(name, idType, id, phoneType, phone, appartmentPos);
	}
	public String addOwner(String personName,int idType,String id,int phoneType,String phone,String bank,String bankNumber, int buildingPos){
		String msj = "";
		buildings[buildingPos].addOwner(personName, idType, id, phoneType, phone, bank, bankNumber);
		msj = "\n OWNER REGISTERED SUCCESFULLY";
		return msj;
	}
}