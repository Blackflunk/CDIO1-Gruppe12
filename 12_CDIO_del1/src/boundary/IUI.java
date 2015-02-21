package boundary;

import java.io.IOException;

import exceptions.UnknownInputException;

public interface IUI {
	//Termination of program
	void endMessage();

	//Creation of user
	String getUserName() throws IOException;
	String cprNumber() throws IOException;
	void showPassword(String password);
	
	// Enter
	String enterUserName() throws IOException;
	String enterCPR() throws IOException;
	String enterPassword() throws IOException;
	
	//Error messages
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
	void showInputFailure();
	void showNoInput();
	
	//Weight program
	int insertWeight() throws IOException;
	int insertTara() throws IOException;
	void showResult(int gross);
	void showWeightMessage(String name);
	boolean tryAgain() throws UnknownInputException, IOException;
	
	//Login possibilities
	String changeName() throws IOException;
	String changePassword() throws IOException;

	//Administration menu
	void showUserList(int[] IDList,String[] nameList);
	int deleteUser() throws IOException;
	int makeUserAdmin() throws IOException;

	//Menus
	int getUserMenu() throws UnknownInputException, IOException;
	int getManageMenu() throws UnknownInputException, IOException;
	int getAdminMenu() throws UnknownInputException, IOException;
	int getMainMenu() throws IOException, UnknownInputException;
	void showMainMenu();
	void showUserMenu(String username);
	void showAdminMenu(String username);
	void showManageMenu(String username);
	
	
}