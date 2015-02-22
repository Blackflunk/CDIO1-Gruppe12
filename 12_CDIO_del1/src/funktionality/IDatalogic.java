package funktionality;


public interface IDatalogic {
	String createUser(String name, String CPR);
	boolean validateUser(String CPR, String password);
	void removeUser(String oprID);
	String[][] getUserList();
	boolean isUserAdmin(String CPR);
	String convertToName(String CPR);
}
