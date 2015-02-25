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
			password = data.createOperator(name,CPR,admin);
		}catch(DALException e){

		}
		
		return password;
	}

	@Override
	public void validateUser(String CPR, String password) throws LoginMatchException{
		if (data.validateUser(CPR, password)==false){
			throw new LoginMatchException();
		}
	}

	@Override
	public boolean validatePassword(String password){
		try {
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
		try {
			list = data.getOperatorList();
		} catch (DALException e) {
			IO.printMessage("No users found");
		}
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
		data.deleteFromList(ID);
		data.sortUserList();
	}

	@Override
	public boolean isUserAdmin(String CPR) {
		return data.isUserAdmin(CPR);
	}

	@Override
	public String convertToName(String CPR) {
		return data.getOprName(CPR);
	}

	public void updateUser(String CPR, int Cnum, String Change) {
		try{
			data.updateOperator(CPR,Cnum,Change);
		}catch(DALException e){
			System.out.println("Fejlede for groft i updateUser");
		}
	}
	public void writeNewFile() {
		try {
			//Whatever the file path is.
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
		data.addToList(new OperatorDTO(10,"SysAdmin","syad","111111-1111",true,">02324it!<"));
		createUser("Martin Hansen", "123412-1234", false);
		createUser("Preben Poulsen", "000000-1234", true);
		createUser("Bent T. Ulrichsen", "666666-7777", false);
		createUser("Poul Hansen", "010101-0101", false);
		try {
			//Whatever the file path is.
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
