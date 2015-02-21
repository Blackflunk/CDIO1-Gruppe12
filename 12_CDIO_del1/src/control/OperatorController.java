package control;
import boundary.TUI;

public class OperatorController {
	private InputController IC;
	private TUI TUI;
	private boolean admin;
	private String username;
	
	
	public OperatorController() {
		TUI = new TUI();
		IC = new InputController(TUI);
	}
	public void init() {
		startTCPClient();
		runTCPClient();
		terminateTCPClient();
	}
	
	public void runTCPClient() {
		
	}
	
	public void startTCPClient() {
		
	}
	
	public void terminateTCPClient() {
		TUI.endMessage();
	}
	
	public void userLogIn(){
		String CPR = IC.getCPR();
		String password = IC.getPassword();
		// try: password validation 
		// CPR to username funktion
		// check for admin
		// runUserMenu or runAdminMenu
		
	}
	public void runManageMenu() {
		boolean run=true;
		while(run){
		TUI.showManageMenu(username);
		switch(IC.getManageMenu()) {
		case 1: // Change name
		case 2: // Change password
		case 3: run=false;
				break;
		}}
	}
	
	public void runMainMenu() {
		boolean run=true;
		while(run){
		TUI.showMainMenu();
		switch(IC.getMainMenu()) {
		case 1: // Create account
		case 2: userLogIn();
				break;
		case 3: run=false;
				break;
		}}
	}
	
	public void runUserMenu() {
		boolean run=true;
		while(run){
		TUI.showUserMenu(username);
		switch(IC.getUserMenu()) {
		case 1: // Account Management
		case 2: // Acces weight
		case 3: // log out
		}}
	}
	public void runAdminMenu() {
		boolean run=true;
		while(run){
		TUI.showAdminMenu(username);
		switch(IC.getAdminMenu()) {
		case 1: // Account Management
		case 2: // Acces weight
		case 3: // log out
			// 4. Show list of all users \n"+"5. Delete user"+"6. Make user admin
		case 4: // showlist
		case 5:	// delete user
		case 6:	// make user admin
		}}
	}

}
