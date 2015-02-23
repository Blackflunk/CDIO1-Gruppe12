package funktionality;

import exceptions.DALException;


public interface IDatalogic {
	String createUser(String name, String CPR, boolean admin);
	boolean validateUser(String CPR, String password) throws DALException;
	void removeUser(String oprID);
	String[][] getUserList();
	boolean isUserAdmin(String CPR);
	String convertToName(String CPR);
}
