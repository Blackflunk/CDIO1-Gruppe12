package control;

import exceptions.DALException;

public class OperatorController {
	private boolean admin;
	private String username;
	private String cpr;
	private WeightController WC;
	private DataController DC;
	private IOController IO;
	
	public OperatorController() {
		IO = new IOController();
		DC = new DataController(IO);
		WC = new WeightController(IO);
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
		DC.createDefaultUsers();
	}
	
	public void terminateTCPClient() {
		IO.printEndMessage();
	}
	
	public void userLogIn() {
		boolean run = true;
		while (run) {
		IO.printMessage("Enter your CPR-number: ");
		cpr = IO.getStringInput();
		IO.printMessage("Enter your password: ");
		String password = IO.getStringInput();
		if (DC.validateUser(cpr, password)) {
			username = cpr;
			if (DC.isUserAdmin(cpr))
				runAdminMenu();
			else
				runUserMenu();
		} else {
			IO.printMessage("The CPR-number and the password didn't match. Try again? Y/N");
			if (IO.getUserSelection()==false)
			run=false;
			}
		}
	}
	public void createAccount() {
		IO.printMessage("Account creation \n"+"#######################################");
		IO.printMessage("Enter your CPR-number: ");
		String CPR = IO.getStringInput();
		IO.printMessage("Enter your full name: ");
		String name = IO.getStringInput();
		String password = createAccount(name, CPR);
		IO.printMessage("your auto-generated password is: "+password);
	}
	
	public void runManageMenu() {
		boolean run=true;
		while(run){
		IO.printManageMenu(username);
		switch(IO.getManageMenu()) {
		case 1: // Change name
		case 2: // Change password
		case 3: run=false;
				break;
		}}
	}
	
	public void runMainMenu() {
		boolean run=true;
		while(run){
		IO.printMainMenu();
		switch(IO.getMainMenu()) {
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
		IO.printMessage("You succesfully logged in!");
		while(run){
		IO.printUserMenu(username);
		switch(IO.getUserMenu()) {
		case 1: runManageMenu();
				break;
		case 2: WC.runWeight(username);
				break;
		case 3: run=false;
				IO.printMessage("You succesfully logged out. \n see you again, "+username);
				break;
		}}
	}
	public void runAdminMenu() {
		boolean run=true;
		while(run){
		IO.printAdminMenu(username);
		switch(IO.getAdminMenu()) {
		case 1: runManageMenu();
				break;
		case 2: WC.runWeight(username);
				break;
		case 3: run=false;
				IO.printMessage("You succesfully logged out. \n see you again, "+username);
				break;
		case 4: IO.printUserList(DC.getUserList());
				break;
		case 5:	// delete user
		case 6:	// make user admin
		}}
	}
	
	public String createAccount(String name, String CPR) {
		String password = DC.createUser(name, CPR, false);
		return password;
	}
	
	
	

}
