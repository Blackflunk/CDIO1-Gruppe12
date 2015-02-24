package funktionality;

import exceptions.DALException;
import exceptions.LoginMatchException;


public interface IDatalogic {
	String createUser(String name, String CPR, boolean admin);
	void validateUser(String CPR, String password) throws LoginMatchException;
	void removeUser(String oprID);
	String[][] getUserList();
	boolean isUserAdmin(String CPR);
	String convertToName(String CPR);
}
