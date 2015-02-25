package control;

import exceptions.LoginMatchException;

public class OperatorController {
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
		IO.printMessage("#######################################");
		IO.printMessage("################WELCOME################");
		IO.printMessage("#######################################");
	}
	
	public void terminateTCPClient() {
		IO.printEndMessage();
	}
	
	public void userLogIn() {
		if (validateLogIn()) {
		username = DC.convertToName(cpr);
		if (DC.isUserAdmin(cpr)) {
			runAdminMenu();
			System.out.println("check");
		}
		else
			runUserMenu();
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
		case 1: IO.printMessage("Rename user \n"+"#######################################");
		if (validateLogIn()) {
			IO.printMessage("Type in your new name");
			String input = IO.getStringInput();
			DC.updateUser(cpr, 1, input);
			username = DC.convertToName(cpr);
			DC.updateUser(cpr, 4, username);
		} break;
		case 2: IO.printMessage("Change password \n"+"#######################################");
		if (validateLogIn()) {
			boolean run_password = true;
			while (run_password){
			IO.printMessage("Type in your new password");
			String input = IO.getStringInput();
			if (DC.validatePassword(input)) {
				DC.updateUser(cpr, 2, input);
				IO.printMessage("You succesfully changed your password");
				run_password=false;
				break;
			} else {
				IO.printMessage("The password didnt match the requirements");
				IO.printMessage("See the requirements at https://password.dtu.dk/ \n");
				IO.printMessage("Do you want to try again? Y/N");
				if (IO.getUserSelection()==false)
					run_password=false;
			}}
		} break;
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
		case 5:	
			IO.printMessage("#######################################");
			IO.printMessage("Delete user by OPR-ID");
			IO.printMessage("#######################################");
			int input=IO.getIntInput();
			DC.deleteUser(input);
			break;
		case 6:	
			IO.printMessage("#######################################");
			IO.printMessage("Make User Admin by CPR");
			IO.printMessage("#######################################");
			String adminset = IO.getStringInput();
			DC.updateUser(adminset, 3, "true");
			break;
		case 7:	
			IO.printMessage("#######################################");
			IO.printMessage("Udskriver nuværende database til fil");
			IO.printMessage("#######################################");
			DC.writeNewFile();
			break;
		}
	}
	}
	
	public String createAccount(String name, String CPR) {
		String password = DC.createUser(name, CPR, false);
		return password;
	}
	
	public boolean validateLogIn() {
		IO.printMessage("Enter your CPR-number: ");
		cpr = IO.getStringInput();
		IO.printMessage("Enter your password: ");
		String password = IO.getStringInput();
		try {
		DC.validateUser(cpr, password);
		} catch (LoginMatchException e) {
			IO.printMessage("The CPR-number and the password didn't match. Try again? Y/N");
			if (IO.getUserSelection()==false)
				return false;
			else
				return validateLogIn();
		}
		return true;
	}
	
	
	

}
