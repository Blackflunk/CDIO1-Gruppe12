package control;

import funktionality.IDatalogic;

public class DataController implements IDatalogic{

	@Override
	public String createUser(String name, String CPR) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateUser(String CPR, String password) {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String convertToName(String CPR) {
		// TODO Auto-generated method stub
		return null;
	}

}
