package control;
import boundary.oldTUI;

public class OperatorController {
	private InputController IC;
	private oldTUI TUI;
	private boolean admin;
	private String username;
	private String cpr;
	private WeightController WC;
	private DataController DC = new DataController();
	private IOController IO = new IOController();
	
	public OperatorController() {
		TUI = new oldTUI();
		IC = new InputController(TUI);
		WC = new WeightController(TUI);
	}
	public void init() {
		startTCPClient();
		runTCPClient();
		terminateTCPClient();
	}
	
	public void runTCPClient() {
		runMainMenu();
	}
	
	public void startTCPClient() {
	}
	
	public void terminateTCPClient() {
		TUI.endMessage();
	}
	
	public void userLogIn(){
		
		cpr = IO.getStringInput();
		String password = TUI.enterPassword();
		if (DC.validateUser(cpr, password)) {
		// check for admin
		// runUserMenu or runAdminMenu
			username = "user";
			runUserMenu();
		}
	}
	public void createAccount() {
		String CPR = IC.getCPR();
		String name = IC.getUserName();
		// create account in database
		TUI.showPassword("password");
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
		case 1: createAccount();
				break;
		case 2: userLogIn();
				break;
		case 3: run=false;
				break;
		}}
	}
	
	public void runUserMenu() {
		boolean run=true;
		TUI.loginSuccesMessage();
		while(run){
		TUI.showUserMenu(username);
		switch(IC.getUserMenu()) {
		case 1: runManageMenu();
				break;
		case 2: WC.runWeight(username);
				break;
		case 3: run=false;
				TUI.logoutSuccesMessage();
				break;
		}}
	}
	public void runAdminMenu() {
		boolean run=true;
		while(run){
		TUI.showAdminMenu(username);
		switch(IC.getAdminMenu()) {
		case 1: runManageMenu();
				break;
		case 2: WC.runWeight(username);
				break;
		case 3: run=false;
				TUI.logoutSuccesMessage();
				break;
		case 4: // showlist
		case 5:	// delete user
		case 6:	// make user admin
		}}
	}

}
