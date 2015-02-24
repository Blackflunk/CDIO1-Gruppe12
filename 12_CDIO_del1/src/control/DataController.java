package control;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import data.OperatorDTO;
import exceptions.DALException;
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
		// TODO Auto-generated method stub
		String password = "";
		try{
		password = data.createOperator(name,CPR,admin);
		}catch(DALException e){
			System.out.println("FEJL SKETE");
		}
		return password;
	}

	@Override
	public boolean validateUser(String CPR, String password) {
		return data.validateUser(CPR, password);
		
	}

	@Override
	public void removeUser(String oprID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[][] getUserList() {
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

	@Override
	public boolean isUserAdmin(String CPR) {
		return data.isUserAdmin(CPR);
	}

	@Override
	public String convertToName(String CPR) {
		// TODO Auto-generated method stub
		return data.getOprName(CPR);
	}
	
	public void createDefaultUsers() {
		createUser("Martin Hansen", "123412-1234", false);
		createUser("sysadmin", "000000-1234", true);
		createUser("Bent T. Ulrichsen", "666666-7777", false);
		createUser("Poul Hansen", "010101-0101", false);
        try {
            //Whatever the file path is.
            File userBase = new File("userdatabase.txt");
            FileOutputStream is = new FileOutputStream(userBase);
            OutputStreamWriter osw = new OutputStreamWriter(is);    
            Writer w = new BufferedWriter(osw);
            for(OperatorDTO o : data.getOperatorList()) {
            w.write(o.getOprId() + " " + o.getOprNavn() + " " + o.getCpr() + " " + o.getAdmin() + " " + o.getPassword());
            w.write(System.getProperty( "line.separator" ));
            }
            w.close();
        } catch (IOException | DALException e) {
            System.err.println("Problem med at skrive til filen");
        }
	}

}
