package funktionality;

import exceptions.LoginMatchException;


public interface IDatalogic {
	String createUser(String name, String CPR, boolean admin);
	void validateUser(String CPR, String password) throws LoginMatchException;
	void deleteUser(int ID);
	String[][] getUserList();
	boolean isUserAdmin(String CPR);
	String convertToName(String CPR);
	boolean validatePassword(String password);
}
