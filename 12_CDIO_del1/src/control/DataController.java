package control;

import java.io.*;
import java.util.ArrayList;

import data.OperatorDTO;
import exceptions.DALException;
import exceptions.InvalidPasswordException;
import exceptions.LoginMatchException;
import funktionality.IDatalogic;
import funktionality.Datalogic;

public class DataController implements IDatalogic{
	Datalogic data = new Datalogic();
	IOController IO;

	public DataController(IOController IO) {
		this.IO=IO;
	}

	@Override
	public String createUser(String name, String CPR, boolean admin) {
		String password = "";
		try{
			// laver ny operatør med de data bruger har tastet ind
			password = data.createOperator(name,CPR,admin);
		}catch(DALException e){
			
		}
		return password;
	}

	@Override
	public void validateUser(String CPR, String password) throws LoginMatchException{
		// tjekker om brugeren og password matcher
		if (data.validateUser(CPR, password)==false){
			throw new LoginMatchException();
		}
	}

	@Override
	public boolean validatePassword(String password){
		try {
			// tjekker om password følger reglerne
			data.validateChangePassword(password);
		} catch (InvalidPasswordException e) {
			return false;
		}
		return true;
	}

	@Override
	public String[][] getUserList() {
		data.sortUserList();
		ArrayList<OperatorDTO> list = new ArrayList<OperatorDTO>();
		// henter operatørliste og lægger den over i det nye arraylist list
		try {
			list = data.getOperatorList();
		} catch (DALException e) {
			IO.printMessage("No users found");
		}
		// String-array til overskuelig data der kan udprintes på skærm hos sysadmin
		String[][] output = new String[list.size()][3];
		for (int i=0; i<list.size(); i++) {
			output[i][0] = Integer.toString(data.getOperatorFromIndex(i).getOprId());
		}
		for (int i=0; i<list.size(); i++) {
			output[i][1] = data.getOperatorFromIndex(i).getCpr();
		}
		for (int i=0; i<list.size(); i++) {
			output[i][2] = data.getOperatorFromIndex(i).getOprNavn();
		}
		return output;
	}

	public void deleteUser(int ID) {
		// sletter bruger og sorterer operatørlisten
		data.deleteFromList(ID);
		data.sortUserList();
	}

	@Override
	public boolean isUserAdmin(String CPR) {
		// sender navn tilhørende CPR til menu
		return data.isUserAdmin(CPR);
	}

	@Override
	public String convertToName(String CPR) {
		return data.getOprName(CPR);
	}

	public void updateUser(String CPR, int Cnum, String Change) {
		// sender data til Datalogic om at opdatere bruger, enten navn,pwd,admin,initialer
		try{
			data.updateOperator(CPR,Cnum,Change);
		}catch(DALException e){
			System.out.println("Fejlede for groft i updateUser");
		}
	}
	public void writeNewFile() {
		try {
			//Tilføjet funktion for administrator at udskrive til fil som menu-punkt
			File userBase = new File("userdatabase.txt");
			FileOutputStream is = new FileOutputStream(userBase);
			OutputStreamWriter osw = new OutputStreamWriter(is);    
			Writer w = new BufferedWriter(osw);
			for(OperatorDTO o : data.getOperatorList()) {
				w.write(o.getOprId() + " " + o.getOprNavn() + " " + o.getIni() + " " + o.getCpr() + " " + o.getAdmin() + " " + o.getPassword());
				w.write(System.getProperty( "line.separator" ));
			}
			w.close();
		} catch (IOException | DALException e) {
			System.err.println("Problem med at skrive til filen");
		}

	}
	
	public void createDefaultUsers() {
		
		// Genererer standard system administrator #10 og tilføjer 4 nye brugere
		 
		data.addToList(new OperatorDTO(10,"SysAdmin","syad","111111-1111",true,">02324it!<"));
		createUser("Martin Hansen", "123412-1234", false);
		createUser("Preben Poulsen", "000000-1234", true);
		createUser("Bent T. Ulrichsen", "666666-7777", false);
		createUser("Poul Hansen", "010101-0101", false);
		// for overskuelighed og for at lettere kunne se alle data om personer skrives de til fil ved opstart
		try {
			File userBase = new File("userdatabase.txt");
			FileOutputStream is = new FileOutputStream(userBase);
			OutputStreamWriter osw = new OutputStreamWriter(is);    
			Writer w = new BufferedWriter(osw);
			for(OperatorDTO o : data.getOperatorList()) {
				w.write(o.getOprId() + " " + o.getOprNavn() + " " + o.getIni() + " " + o.getCpr() + " " + o.getAdmin() + " " + o.getPassword());
				w.write(System.getProperty( "line.separator" ));
			}
			w.close();
		} catch (IOException | DALException e) {
			System.err.println("Problem med at skrive til filen");
		}
	}
}
