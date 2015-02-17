package funktionality;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import data.IOperatorDAO;
import data.OperatorDTO;

public class Datalogic implements IOperatorDAO {
	
	
	
	
	
	
	
	/*
	 * Har udkommenteret alt vi sad og roddede med idag indtil pigerne har 
	 * vist os deres vidunder :D woot woot, så vi ikke sidder og laver dobbelt
	 * arbejde i funktionalitetslaget.
	 * 
	 */
	/*
	private ArrayList<OperatorDTO> OperatorList = new ArrayList<OperatorDTO>();
	
	

	@Override
	public void getOperator(int oprId) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<OperatorDTO> getOperatorList()	throws DALException {
		// TODO Auto-generated method stub
		return OperatorList;
	}

	@Override
	public String createOperator(OperatorDTO opr) throws DALException {
		// TODO Auto-generated method stub
		opr.setOprId(GenerateoprID());
		opr.setPassword(GeneratePassword());
		OperatorList.add(opr.getOprId(),opr.getOprNavn(),opr.getIni(),opr.getCpr(), opr.getAdmin(), opr.getPassword());
		return opr.getPassword();
		
	}

	@Override
	public void updateOperator(data.OperatorDTO opr) throws DALException {
		// TODO Auto-generated method stub
		
	}
	String OperatorDTO getOperator(int oprId) throws DALException {
		
	}

	data.ArrayList<data.OperatorDTO> getOperatorList() throws DALException {

	}

	void updateOperator(OperatorDTO opr) throws DALException;
	
	public int GenerateoprID() {

		int oprId = 0, Idcounter = 11;
		int ListLength = OperatorList.size();
		OperatorDTO TempObject;

		for(int i = 0;i < ListLength;i++) {
			TempObject = OperatorList.get(i);
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
	}
	*/
	public String GeneratePassword() {

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

		//løkken sørger for der er 10 characters i password
		while(pwdcount < 10){

			//Finder et tilfældigt tal mellem 0 og 3 til switch-casen
			randomtal = StringRNG.nextInt(4);
			/* 
			 * Her sørger Switch-casen for der er mindst 1 af hver af de krævede
			 * tegn, herudover er det tilfældigt hvor mange af hver der kommer, men
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

		//Indsætter de chars der udgør kodeordet til String-variablen password
		for (int i = 0;i < PwD.size();i++){
			PwDchar = PwD.get(i);
			password += String.copyValueOf(PwDchar);
		}

		//Her skal der returnes password til databasen når den er færdiglavet
		return password;
	}

}
