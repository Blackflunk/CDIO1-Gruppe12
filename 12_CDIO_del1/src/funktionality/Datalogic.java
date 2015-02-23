package funktionality;
import java.util.*;

import exceptions.DALException;
import data.IOperatorDTO;
import data.OperatorDTO;


public class Datalogic implements IOperatorDTO{
	private List<OperatorDTO> operatorList = new ArrayList<OperatorDTO>();
	
	public Datalogic()
	{
		operatorList.add(new OperatorDTO(generateOprID(), "sysadmin", "sysadm", "000000-0000", true, generatePassword()));
		
	}
	
	public OperatorDTO getOperator(int oprId) throws DALException
	{
		for(int i = 0; i < operatorList.size() ;i++ )
		{
			if(operatorList.get(i).getOprId()== oprId){
				return operatorList.get(i);
			}
			
		}
		throw new DALException(oprId);
	}
	@Override
	public List<OperatorDTO> getOperators() {
		// TODO Auto-generated method stub
		return operatorList;
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
	//Laver nyt object, tilf�jer OprId og Password
	@Override
	public String createOperator(OperatorDTO opr) throws DALException {
		opr.setOprId(generateOprID());
		opr.setPassword(generatePassword());
		operatorList.add(new OperatorDTO(opr.getOprId(),opr.getOprNavn(),opr.getIni(),opr.getCpr(), opr.getAdmin(), opr.getPassword()));
		return opr.getPassword();
		
	}

	@Override
	public void updateOperator(data.OperatorDTO opr) throws DALException {
		// TODO Auto-generated method stub
		
	}
	//Midlertidig Generator til oprID indtil der bestemmes hvordan vi h�ndterer slet operat�r
	public int generateOprID() {

		int oprId = 0, Idcounter = 11;
		int ListLength = operatorList.size();
		OperatorDTO TempObject;

		for(int i = 0;i < ListLength;i++) {
			TempObject = operatorList.get(i);
			if(ListLength < 88) {
				return ListLength + 11;
			}
			else if(Idcounter == 99) {
				return -1;
			}
			else if(TempObject.getOprId() == Idcounter){
				Idcounter++;
			}
			else if(TempObject.getOprId() != Idcounter) {
				oprId = Idcounter; 
				return oprId;
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
	
	// Finder navn ud fra CPR-nummer.
	public String getOprName(String CPR){
		OperatorDTO operatorDTO;
		//Finder alle CPR numre i arraylisten for operatørene.
			for (int i = 0;i<operatorList.size()-1;i++){
				// Henter og sammenligner nuværende objekt med det givne CPR-nummer.
				operatorDTO = operatorList.get(i);
				if(CPR == operatorDTO.getCpr()){
					return operatorDTO.getOprNavn();
				}
			}
		return "-1";
	}
	
	// Ser på om brugernavnet matcher password.
	public boolean validateUser(String username, String password){
		OperatorDTO operatorDTO;
		// Tager fat i alle operatørene i vores arraylist.
		for (int i = 0;i<operatorList.size()-1;i++){
			operatorDTO = operatorList.get(i);
			// Sammenligner om nuværende objects CPR nummer og password passer sammen.
				if(username == operatorDTO.getCpr() && password == operatorDTO.getPassword()){
					return true;
				}
			}	
		return false;	
	}

	@Override
	public ArrayList<OperatorDTO> getOperatorList() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}



}
