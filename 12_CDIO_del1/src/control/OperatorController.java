package control;

public class OperatorController {
	private boolean admin;
	private String username;
	private String cpr;
	private WeightController WC;
	private DataController DC = new DataController();
	private IOController IO;
	
	public OperatorController() {
		IO = new IOController();
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
	}
	
	public void terminateTCPClient() {
		IO.printEndMessage();
	}
	
	public void userLogIn(){
		boolean run = true;
		while (run) {
		IO.printMessage("Enter your CPR-number: ");
		cpr = IO.getStringInput();
		IO.printMessage("Enter your password: ");
		String password = IO.getStringInput();
		if (DC.validateUser(cpr, password)) {
		// check for admin
		// runUserMenu or runAdminMenu
			username = "user";
			runUserMenu();
		} else if (IO.getUserSelection()==false)
			run=false;
		}
	}
	public void createAccount() {
		IO.printMessage("Account creation \n"+"#######################################");
		IO.printMessage("Enter your CPR-number: ");
		String CPR = IO.getStringInput();
		IO.printMessage("Enter your full name: ");
		String name = IO.getStringInput();
		// create account in database
		IO.printMessage("password");
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
		case 4: // showlist
		case 5:	// delete user
		case 6:	// make user admin
		}}
	}

}
