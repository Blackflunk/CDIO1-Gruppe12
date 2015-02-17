package boundary;

public interface IUI {
	// Inden logget ind.
	void endMessage();

	//Oprettelse af bruger
	String getUserName();
	String cprNumber();
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
	void createUserFailedMessage();
	void createUserSuccesMessage();
	
	//Vægtprogram
	int insertWeight();
	int insertTara();
	void showResult();
	void showWeightMessage();
	
	//Login valgmuligheder
	String changeName();
	String changePassword();

	//Adminstrations menu
	void showUserList(int[] IDList,String[] nameList);
	int deleteUser();
	int makeUserAdmin();

	//Menuer
	int showUserMenu();
	int showManageMenu();
	int showAdminMenu();
	int showMainMenu();
	
	
}