package ui; 

import model.*; 
import java.util.Scanner;


public class Main{

	private Scanner reader;
	private RealEstate realEstate;

	public Main(){
		reader = new Scanner(System.in);
		realEstate = new RealEstate();
		print(""+Math.cos(30));
	}

	public static void main(String[] args) {
		Main main = new Main();
		String option = "";
		do{
			option = main.showMenu();
			main.executeOption(option);
		}while(option.equals("0")==false);

	}
	public void print(String text){
		System.out.println(text);
	}
	public String showMenu(){
		String option = "";
		print("\n----------------------------------------------\n"+
			"             REAL ESTATE APP              \n"+
			"----------------------------------------------\n"+
			"(1)  Register BUILDING \n"+
			"(2)  Register APPARTMENT  \n"+
			"(3)  Register TENANT \n"+
			"(4)  Available Appartments\n"+
			"(5)  Search Appartment\n"+
			"(6)  Calculate TOTAL RENT\n"+
			"(7)  Appartment Rent per TENANT\n"+
			"(8)  Calculate OWNER TOTAL\n"+
			"(0)  Exit Program");
		option = reader.next();
		return option;
	}
	public void executeOption(String option){
		String msj = "";
		int pos = -1;
		int appartmentPos = -1;
		int sw = 0;

		String name = "";
		String adress = "";
		int number = 0;

		int roomNumber = 0;
		int bathNumber = 0;
		String balcony = "";
		double value = 0;

		String personName = "";
		int idType = 0;
		String id = "";
		int phoneType = 0;
		String phone = "";
		String bank = "";
		String bankNumber = "";

		switch(option){
			case "1":
				print("\n  BUILDING REGISTRATION\n\n Enter Building Name :");
				name = reader.next();
				pos = realEstate.searchBuilding(name);
				if(pos == -1){
					print("\n Enter number of APPARTMENTS :");
					do{
						sw = 0;
						if(reader.hasNextInt()){
							number = reader.nextInt();
							if(number<=0){print("\n Number must be above 0");}
						}else{print("\n INVALID NUMBER");reader.next();sw = 1;}
					}while(number<=0 || sw == 1);
					print("\n Enter Building ADRESS :");
					adress = reader.next();
					msj = realEstate.addBuilding(name,number,adress,pos);
				}else{msj = "\n BUILDING ALREADY REGISTERED";}
				print(msj);
				break;
			case "2":
				print("\n APPARTMENT REGISTRATION \n\n Enter BUILDING Name :");
				name = reader.next();
				pos = realEstate.searchBuilding(name);
				if(pos != -1){
					print("\n Enter Appartment Number :");
					do{
						sw = 0;
						if(reader.hasNextInt()){
							number = reader.nextInt();
							if(number<0){print("\n INVALID NUMBER");}
						}else{print("\n INVALID NUMBER"); reader.next();sw = 1;}
					}while(number<0 || sw == 1);
					print("\n Enter MENSUAL VALUE");
					do{
						sw = 0;
						if(reader.hasNextDouble()){
							value = reader.nextDouble();
							if(value<0){print("\n INVALID VALUE");}
						}else{print("\n INVALID VALUE");reader.next();sw = 1;}
					}while(value<0 || sw == 1);
					print("\n Enter Number of Rooms :");
					do{
						sw = 0;
						if(reader.hasNextInt()){
							roomNumber = reader.nextInt();
							if(roomNumber<0){print("\n INVALID NUMBER");}
						}else{print("\n INVALID NUMBER"); reader.next();sw = 1;}
					}while(roomNumber<0 || sw == 1);
					print("\n Enter Number of Bathrooms :");
					do{
						sw = 0;
						if(reader.hasNextInt()){
							bathNumber = reader.nextInt();
							if(bathNumber<0){print("\n INVALID NUMBER");}
						}else{print("\n INVALID NUMBER"); reader.next();sw = 1;}
					}while(bathNumber<0 || sw == 1);
					do{
						print("\n Balcony : \n(1) YES\n(2) NO");
						balcony = reader.next();
						if(balcony.equals("1")){
							balcony = "YES";
						}else{
							if(balcony.equals("2")){
								balcony = "NO";
							}else{print("\n INVALID OPTION");}
						}
					}while(!balcony.equals("YES") && !balcony.equals("NO"));
					msj = realEstate.addAppartment(number, value, roomNumber, bathNumber, balcony, pos);
				}else{msj = "\n BUILDING NOT FOUND";}
				print(msj);
				print("\n \n OWNER REGISTRATION : \n \n Enter Name :");
				personName = reader.next();
				print("\n Enter Owner ID TYPE :");
				msj = showIdType();
				print(msj);
				do{
					if(reader.hasNextInt()){
						idType = reader.nextInt();
						if(idType!=1 && idType!=2 && idType!=3){print("\n INVALID OPTION");}
					}else{print("\n INVALID OPTION");reader.next();}
				}while(idType!=1 && idType!=2 && idType!=3);
				print("\n Enter Owner ID :");
				id = reader.next();
				print("\n Enter PHONE TYPE :");
				msj = showPhoneType();
				print(msj);
				do{
					if(reader.hasNextInt()){
						phoneType = reader.nextInt();
						if(phoneType!=1 && phoneType!=2 && phoneType!=3 && phoneType!=4 && phoneType!=5){print("\n INVALID OPTION");}
					}else{print("\n INVALID OPTION");reader.next();}
				}while(phoneType!=1 && phoneType!=2 && phoneType!=3 && phoneType!=4 && phoneType!=5);
				print("\n Enter Phone :");
				phone = reader.next();
				print("\n Enter bank :");
				bank = reader.next();
				print("\n Enter Bank Number :");
				bankNumber = reader.next();
				msj = realEstate.addOwner(personName, idType, id, phoneType, phone, bank, bankNumber, pos);
				print(msj);
				break;
			case "3":
				print("\n TENANT REGISTRATION \n\n Enter Name :");
				personName = reader.next();
				pos = realEstate.searchTenant(personName);
				if(pos==-1){
					print("\n Enter Tenant ID TYPE :");
					msj = showIdType();
					print(msj);
					do{
						if(reader.hasNextInt()){
							idType = reader.nextInt();
							if(idType!=1 && idType!=2 && idType!=3){print("\n INVALID OPTION");}
						}else{print("\n INVALID OPTION");reader.next();}
					}while(idType!=1 && idType!=2 && idType!=3);
					print("\n Enter Tenant ID :");
					id = reader.next();
					print("\n Enter PHONE TYPE :");
					msj = showPhoneType();
					print(msj);
					do{
						if(reader.hasNextInt()){
							phoneType = reader.nextInt();
							if(phoneType!=1 && phoneType!=2 && phoneType!=3 && phoneType!=4 && phoneType!=5){print("\n INVALID OPTION");}
						}else{print("\n INVALID OPTION");reader.next();}
					}while(phoneType!=1 && phoneType!=2 && phoneType!=3 && phoneType!=4 && phoneType!=5);
					print("\n Enter Phone :");
					phone = reader.next();
					print("\n SELECT BUILDING :");
					msj = realEstate.showBuildings();
					print(msj);
					do{
						sw = 0;
						name = reader.next();
						pos = realEstate.searchBuilding(name);
						if(pos!=-1){
							msj = realEstate.showAppartments(pos);
							if(msj.equals("")){pos = 1;sw = 1;}
							print(msj);
							if(sw == 0){
								do{
									sw = 0;
									if(reader.hasNextInt()){
										number = reader.nextInt();
										appartmentPos = realEstate.searchAppartment(pos, number);
										if(appartmentPos != -1){
											realEstate.setTenant(name, idType, id, phoneType, phone, pos, appartmentPos);
											msj = "\n TENANT REGISTERED SUCCESFULLY";
										}else{print("\n INVALID APPARTMENT");sw = 1;}
									}else{print("\n APPARTMENT NOT FOUND"); reader.next();sw=1;}
								}while(sw==1);
							}else{msj = "\n NO AVAILABLE APPARTMENTS";}

						}else{print("\n BUILDING NOT FOUND");reader.next();}
					}while(pos == -1);
				}else{msj="\n TENANT ALREADY REGISTERED";}
				print(msj);
				break;
			case "4":
				print("\n APPARTMENT LIST \n\n Enter BUILDING :");
				name = reader.next();
				pos = realEstate.searchBuilding(name);
				if(pos != -1){
					msj = realEstate.showAppartments(pos);
				}else{msj = "\n BUILDING NOT FOUND";}
				print(msj);
				break;
			case "5":
				
				break;
			case "6":
				
				break;
			case "7":
				
				break;
			case "8":
				
				break;
			case "0":
				print("\n SEE YOU NEXT TIME :)");
				break;
			default:
				print("\n INVALID OPTION");
		}
	}
	public String showIdType(){
		String msj = "\n"+
		"\n (1) CC "+
		"\n (2) TI "+
		"\n (3) OTHER ";
		return msj;
	}
	public String showPhoneType(){
		String msj = "\n"+
		"\n (1) HOME"+
		"\n (2) OFFICE"+
		"\n (3)MOVIL"+
		"\n (4)FAMILY"+
		"\n (5)OTHER";
		return msj;
	}
	

}