package funktionality;

import data.OperatorDTO;
import exceptions.LoginMatchException;


public interface IDatalogic {
	String createUser(String name, String CPR, boolean admin);
	void validateUser(String CPR, String password) throws LoginMatchException;
	void deleteUser(int ID);
	String[][] getUserList();
	boolean isUserAdmin(String CPR);
	String convertToName(String CPR);
	boolean validatePassword(String password);
	OperatorDTO getOperator(String CPR);
	void updateUser(String CPR, int Cnum, String Change);
	void writeNewFile();
	void createDefaultUsers();
}
