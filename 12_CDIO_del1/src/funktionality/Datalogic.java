package funktionality;
import java.util.*;

import exceptions.DALException;
import exceptions.InvalidPasswordException;
import data.IOperatorDTO;
import data.OperatorDTO;


public class Datalogic implements IOperatorDTO {
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
		if(operatorList.size() < 89){
			operatorList.add(addInput);
		}
		else {
			System.out.println("The Database is Full, please delete someone before trying to add more");
		}
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
	public void updateOperator(String CPR, int Cnum, String Change) throws DALException {
		//Unders�g hvilket element er �ndret i forhold til oprindelige element
		for(OperatorDTO o : operatorList) {
			if(CPR.equals(o.getCpr())) {
				if(Cnum == 3){
					o.setAdmin(true);
				}
				else if(Cnum == 1) {
					o.setOprNavn(Change);
				}
				else if(Cnum == 2) {
					o.setPassword(Change);
				}
				else if(Cnum == 4) {
					o.setIni(getIni(Change));
				}
			}
		}

	}
	//Midlertidig Generator til oprID indtil der bestemmes hvordan vi h�ndterer slet operat�r
	public int generateOprID() {
		OperatorDTO o;

		for(int i = 0;i < operatorList.size();i++){
			o = operatorList.get(i);
			if(i+10 == o.getOprId() && operatorList.size() == i+1){
				return i+11;
			}
			if(i+10 != o.getOprId()){
				return i+10;
			}
		}
		return 0;		
	}				
	public void validateChangePassword(String password) throws InvalidPasswordException{
		int countUpper = 0,countLower = 0,countDigit = 0,countSymbol=0,countTotal=0;
		String TilladteTegn = ".-_+!?=";
		int chartype=0;

		if (password.length() <= 6){
			throw new InvalidPasswordException();
		}
		for(int i = 0; i < password.length(); i++){
			if (Character.isUpperCase(password.charAt(i))){
				chartype=1;
			}

			else if (Character.isLowerCase(password.charAt(i))){
				chartype=2;
			}

			else if (Character.isDigit(password.charAt(i))){
				chartype=3;
			}
			for(int k = 0; k<TilladteTegn.length();k++){
				if (password.charAt(i)==TilladteTegn.charAt(k)){
					chartype=4;
				}
			}
			switch(chartype) {
			case 1: countUpper++;
			break;
			case 2: countLower++;
			break;
			case 3: countDigit++;
			break;
			case 4: countSymbol++;
			break;
			default: throw new InvalidPasswordException();
			}
		}

		if (countUpper>=1){
			countTotal++;
		}
		if (countLower>=1){
			countTotal++;
		}
		if (countDigit>=1){
			countTotal++;
		}
		if (countSymbol>=1){
			countTotal++;
		}
		if (countTotal < 3){
			throw new InvalidPasswordException();
		}
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
		//Returnerer password til metoden der kaldte den.
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
		return newIni.toLowerCase();
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
		Collections.sort(operatorList, new IDComparator());
	}

	@Override
	public ArrayList<OperatorDTO> getOperatorList() throws DALException {
		if (operatorList.size()==0)
			throw new DALException();
		return operatorList;
	}

	public boolean isUserAdmin(String CPR) {
		// Tager fat i alle operatørene i vores arraylist.
		for (OperatorDTO o : operatorList){
			if(CPR.equals(o.getCpr())){
				return o.getAdmin();
			}
		}	
		return false;
	}


	@Override
	public OperatorDTO getOperatorFromIndex(int index) {
		return operatorList.get(index);
	}
	
	class IDComparator implements Comparator<OperatorDTO>{
		public  int compare(OperatorDTO o1, OperatorDTO o2) {
			final int BEFORE = -1;
			final int EQUAL = 0;
			final int AFTER = 1;

			//this optimization is usually worthwhile, and can
			//always be added
			if (o1.getOprId() == o2.getOprId()) return EQUAL;

			//primitive numbers follow this form
			if (o1.getOprId() < o2.getOprId()) return BEFORE;
			if (o1.getOprId() > o2.getOprId()) return AFTER;

			return EQUAL;
		}
	}
}
