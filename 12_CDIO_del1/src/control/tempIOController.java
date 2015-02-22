package control;

import java.io.IOException;

import exceptions.UnknownInputException;
import boundary.tempTUI;

public class tempIOController {
	private tempTUI TUI = new tempTUI();
	
	
	public String getStringInput() {
		String input = "";
		try{
			input = TUI.getResponse();
		} catch (IOException e) {
			TUI.printMessage("No input detected");
			getStringInput();
		}
		return input;
	}
	public int getIntInput() {
		int output=0;
		String input = getStringInput();
		
		try{
			output = Integer.parseInt(input);
		}
		catch(NumberFormatException e){
			TUI.printMessage("Couldn't recognize the input");
			getIntInput();
		}
		
		return output;	
	}
	
	public void printMainMenu() {
		TUI.printMessage("#######################################");
		TUI.printMessage("Main menu \n");
		TUI.printMessage("1. Create Account \n"+"2. Log in to excisting account \n"+"3. Exit program");
		TUI.printMessage("#######################################");
	}
	
	public void printUserMenu(String username) {
		TUI.printMessage("#######################################");
		TUI.printMessage("Logged in as: "+username);
		TUI.printMessage("#######################################");
		TUI.printMessage("Usermenu \n");
		TUI.printMessage("1. Account management \n"+"2. Acces weight \n"+"3. Log out");
		TUI.printMessage("#######################################");
	}
	
	public void printAdminMenu(String username) {
		TUI.printMessage("#######################################");
		TUI.printMessage("Logged in as: "+username);
		TUI.printMessage("#######################################");
		TUI.printMessage("User options \n");
		TUI.printMessage("1. Account management \n"+"2. Acces weight \n"+"3. Log out \n");
		TUI.printMessage("Admin options \n");
		TUI.printMessage("4. Show list of all users \n"+"5. Delete user"+"6. Make user admin");
		TUI.printMessage("#######################################");
	}
	
	public void printManageMenu(String username) {
		TUI.printMessage("#######################################");
		TUI.printMessage("Logged in as: "+username);
		TUI.printMessage("#######################################");
		TUI.printMessage("Account management \n");
		TUI.printMessage("1. Change name \n"+"2. change password \n"+"3. back");
		TUI.printMessage("#######################################");
	}
	
	public boolean getUserSelection() throws UnknownInputException {
		String input = getStringInput();
		switch(input) {
		case "Y": return true;
		case "N": return false;
		default: throw new UnknownInputException();
		}
	}
	
	public int getUserMenu() throws UnknownInputException, IOException {
		String input = getStringInput();
		switch(input) {
		case "1": return 1;
		case "2": return 2;
		case "3": return 3;
		default: throw new UnknownInputException();
		}
	}

	public int getManageMenu() throws IOException, UnknownInputException {
		String input = getStringInput();
		switch(input) {
		case "1": return 1;
		case "2": return 2;
		case "3": return 3;
		default: throw new UnknownInputException();
		}
	}

	public int getAdminMenu() throws IOException, UnknownInputException{
		String input = getStringInput();
		switch(input) {
		case "1": return 1;
		case "2": return 2;
		case "3": return 3;
		case "4": return 4;
		case "5": return 5;
		case "6": return 6;
		default: throw new UnknownInputException();
		}
	}

	public int getMainMenu() throws IOException, UnknownInputException {
		String input = getStringInput();
		switch(input) {
		case "1": return 1;
		case "2": return 2;
		case "3": return 3;
		default: throw new UnknownInputException();
		}
	}
}
