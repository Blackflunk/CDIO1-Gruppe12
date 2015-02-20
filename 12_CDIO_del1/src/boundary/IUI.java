package boundary;

import java.io.IOException;

import exceptions.UnknownInputException;

public interface IUI {
	// Inden logget ind.
	void endMessage();

	//Oprettelse af bruger
	String getUserName() throws IOException;
	String cprNumber() throws IOException;
	void showPassword(String password);
	
	//Fejlbeskeder
	void changeNameFailed();
	void changeNameSucces();
	void changePasswordFailed();
	void changePasswordSucces();
	void loginSuccesMessage();
	void loginFailedMessage();
	void logoutSuccesMessage();
	void logoutFailedMessage();
	void createUserFailedMessage(String CPR);
	void createUserSuccesMessage();
	
	//Vægtprogram
	int insertWeight() throws IOException;
	int insertTara() throws IOException;
	void showResult(int gross);
	void showWeightMessage(String name);
	
	//Login valgmuligheder
	String changeName() throws IOException;
	String changePassword() throws IOException;

	//Adminstrations menu
	void showUserList(int[] IDList,String[] nameList);
	int deleteUser() throws IOException;
	int makeUserAdmin() throws IOException;

	//Menuer
	int showUserMenu(String username) throws UnknownInputException, IOException;
	int showManageMenu(String username) throws UnknownInputException, IOException;
	int showAdminMenu(String username) throws UnknownInputException, IOException;
	int showMainMenu() throws IOException, UnknownInputException;
	
	
}