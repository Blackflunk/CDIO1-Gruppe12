package funktionality;
import java.util.*;

import exceptions.DALException;
import data.IOperatorDTO;
import data.OperatorDTO;


public class Datalogic implements IOperatorDTO,Comparable<OperatorDTO>{
	private ArrayList<OperatorDTO> operatorList = new ArrayList<OperatorDTO>();
	OperatorDTO operatorDTO;
	
	
	public OperatorDTO getOperator(String CPR) throws DALException
	{
		for(int i = 0; i < operatorList.size() ;i++ )
		{
			if(operatorList.get(i).getCpr() == CPR){
				return operatorList.get(i);
			}
			
		}
		throw new DALException();
	}
	
	// Tilf�jer operatør
	public void addToList(OperatorDTO addInput)
	{
		operatorList.add(addInput);
		
	}
	// Slette Operat�r
	public boolean deleteFromList(int index)
	{
		
		for (OperatorDTO o : operatorList) {
			if (o.getOprId()==index){
				operatorList.remove(o);
				return true;
			}
		}
		return false;
		
	}

	@Override
	public String createOperator(String Navn, String CPR, boolean admin)
			throws DALException {
		OperatorDTO opr = new OperatorDTO(generateOprID(),Navn,getIni(Navn),CPR, admin, generatePassword());
		operatorList.add(opr);
		return opr.getPassword();
	}

	@Override
	public void updateOperator(data.OperatorDTO opr) throws DALException {
		// TODO Auto-generated method stub
		
	}
	//Midlertidig Generator til oprID indtil der bestemmes hvordan vi h�ndterer slet operat�r
	public int generateOprID() {
		int counter = 11;
		if(operatorList.size() < 2){
		int newOprID = 11+operatorList.size();
		return newOprID;
		}
		for(OperatorDTO o : operatorList){
			if(o.getOprId() == counter){
				counter++;
			}
			if(o.getOprId() != counter){
				return counter;
			}
		}
		return -1;
		
	}
	public String generatePassword() {

		//initialiserer variable
		String SmaaBogstaver = "abcdefghijklmnopqrstuvwxyz";
		String StoreBogstaver = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String TilladteTegn = ".-_+!?=";
		String Tal = "0123456789";
		ArrayList<char[]> PwD = new ArrayList<char[]>();
		char[] PwDchar = null;
		String password = "";
		Random StringRNG = new Random();
		int counter[] = {0,0,0,0,0}, pwdcount = 0;
		int randomtal = 0, case0 = 0, case1 = 0, case2 = 0, case3 = 0;

		//l�kken s�rger for der er 10 characters i password
		while(pwdcount < 10){

			//Finder et tilf�ldigt tal mellem 0 og 3 til switch-casen
			randomtal = StringRNG.nextInt(4);
			/* 
			 * Her s�rger Switch-casen for der er mindst 1 af hver af de kr�vede
			 * tegn, herudover er det tilf�ldigt hvor mange af hver der kommer, men
			 * stadig ikke mere end 6 i alt.
			 */

			switch(randomtal){
			case 0: counter[0]++;
			if (counter[0] < 3) {
				pwdcount++;
				case0++;
				PwD.add(new char[] {SmaaBogstaver.charAt(StringRNG.nextInt(SmaaBogstaver.length()))});
			}
			else if (case1 > 0 && case2 > 0 && case3 > 0){
				case0++;
				pwdcount++;
				PwD.add(new char[] {SmaaBogstaver.charAt(StringRNG.nextInt(SmaaBogstaver.length()))});
			}
			else {
				break;
			}
			break;

			case 1:  counter[1]++;
			if (counter[1] < 3) {
				case1++;
				pwdcount++;
				PwD.add(new char[] {StoreBogstaver.charAt(StringRNG.nextInt(StoreBogstaver.length()))});
			}
			else if (case0 > 0 && case2 > 0 && case3 > 0){
				case1++;
				pwdcount++;
				PwD.add(new char[] {StoreBogstaver.charAt(StringRNG.nextInt(StoreBogstaver.length()))});
			}
			else {
				break;
			}
			break;

			case 2: counter[2]++;
			if (counter[2] < 3) {
				case2++;
				pwdcount++;
				PwD.add(new char[] {TilladteTegn.charAt(StringRNG.nextInt(TilladteTegn.length()))});
			}
			else if (case0 > 0 && case1 > 0 && case3 > 0){
				case2++;
				pwdcount++;
				PwD.add(new char[] {TilladteTegn.charAt(StringRNG.nextInt(TilladteTegn.length()))});
			}
			else {
				break;
			}
			break;

			case 3: counter[3]++;
			if (counter[3] < 3) {
				case3++;
				pwdcount++;
				PwD.add(new char[] {Tal.charAt(StringRNG.nextInt(Tal.length()))});
			}
			else if (case0 > 0 && case1 > 0 && case2 > 0){
				case3++;
				pwdcount++;
				PwD.add(new char[] {Tal.charAt(StringRNG.nextInt(Tal.length()))});
			}
			else{
				break;
			}
			break;
			default: break;
			}
		}

		//Inds�tter de chars der udg�r kodeordet til String-variablen password
		for (int i = 0;i < PwD.size();i++){
			PwDchar = PwD.get(i);
			password += String.copyValueOf(PwDchar);
		}

		//Her skal der returnes password til databasen n�r den er f�rdiglavet
		return password;
	}
	
	public String getIni(String name) {
			int dotindex = 0, spaceindex = 0;
			spaceindex = name.indexOf(' ');
			dotindex = name.indexOf('.');
			String newIni = "";
			if(dotindex > 2){
				newIni = name.substring(0, 2) + name.substring(dotindex+2, dotindex+4);	
			}
			else if (spaceindex > 2){
				newIni = name.substring(0, 2) + name.substring(spaceindex+1, spaceindex+3);
			}

			else {
				newIni = name.substring(0, 4);
			}
			return newIni;
		}
	
	// Finder navn ud fra CPR-nummer.
	public String getOprName(String CPR){
		//Finder alle CPR numre i arraylisten for operatørene.
			for (OperatorDTO o : operatorList) {
				if(CPR.equals(o.getCpr())) {
					return o.getOprNavn();
				}
			}
		return "-1";
	}
	
	// Ser på om brugernavnet matcher password.
	public boolean validateUser(String username, String password){
		// Tager fat i alle operatørene i vores arraylist.
		for (OperatorDTO o : operatorList) {
			if(password.equals(o.getPassword()) && username.equals(o.getCpr())) {
				return true;
			}
		}
		return false;	
	}
	
	public void sortUserList(){
		// Collections.sort(tempID<T> operatorList);
	}

	@Override
	public ArrayList<OperatorDTO> getOperatorList() throws DALException {
		if (operatorList.size()==0)
			throw new DALException();
		return operatorList;
	}
	
	public boolean isUserAdmin(String CPR) {
		OperatorDTO operatorDTO;
		// Tager fat i alle operatørene i vores arraylist.
		for (int i = 0;i<operatorList.size()-1;i++){
			operatorDTO = operatorList.get(i);
				if(CPR.equals(operatorDTO.getCpr())){
					return operatorDTO.getAdmin();
				}
			}	
		return false;
	}

	@Override
	public int compareTo(OperatorDTO o) {
		 	final int BEFORE = -1;
		    final int EQUAL = 0;
		    final int AFTER = 1;

		    //this optimization is usually worthwhile, and can
		    //always be added
		    // if (this.tempID == o.getOprId()) return EQUAL;

		    //primitive numbers follow this form
		    //if (this.tempID < o.getOprId()) return BEFORE;
		    //if (this.tempID > o.getOprId()) return AFTER;
		    
		    return EQUAL;
	}

	@Override
	public OperatorDTO getOperatorFromIndex(int index) {
		return operatorList.get(index);
	}
}
