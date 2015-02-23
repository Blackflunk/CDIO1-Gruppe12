package control;

import funktionality.IDatalogic;
import funktionality.Datalogic;

public class DataController implements IDatalogic{
	Datalogic data = new Datalogic();

	@Override
	public String createUser(String name, String CPR, boolean admin) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUserAdmin(String CPR) {
		return data.isUserAdmin(CPR);
	}

	@Override
	public String convertToName(String CPR) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void createDefaultUsers() {
		createUser("Martin Hansen", "123412-1234", false);
		createUser("sysadmin", "000000-0000", true);
		createUser("Bent T. Ulrichsen", "666666-7777", false);
	}

}
