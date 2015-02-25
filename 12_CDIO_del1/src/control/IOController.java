package control;

import java.io.IOException;

import exceptions.UnknownInputException;
import boundary.TUI;

public class IOController {
	private TUI TUI = new TUI();
	
	
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
	public void printEndMessage() {
		TUI.printMessage("#######################################");
		TUI.printMessage("You have terminated the program. ");
		TUI.printMessage("Bye bye");
		TUI.printMessage("#######################################");
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
		TUI.printMessage("4. Show list of all users \n"+"5. Delete user \n"+"6. Make user admin \n"+"7. Write New Datalist");
		TUI.printMessage("#######################################");
	}
	
	public void printManageMenu(String username) {
		TUI.printMessage("#######################################");
		TUI.printMessage("Logged in as: "+username);
		TUI.printMessage("#######################################");
		TUI.printMessage("Account management \n");
		TUI.printMessage("1. Change name \n"+"2. Change password \n"+"3. Back");
		TUI.printMessage("#######################################");
	}
	public void printUserList(String[][] userlist) {
		TUI.printMessage("#######################################");
		TUI.printMessage("List of users");
		TUI.printMessage("#######################################");
		for (int i=0; i<userlist.length; i++){
			TUI.printMessage("ID: "+userlist[i][0]+"\t CPR: "+userlist[i][1]+"\t Name: "+userlist[i][2]);
		}
	}
	
	public boolean getUserSelection() {
		String input = getStringInput();
		boolean output =false;
		try {
		switch(input) {
		case "Y": output = true;
		break;
		case "N": output = false;
		break;
		default: throw new UnknownInputException();
		} } catch (UnknownInputException e) {
			TUI.printMessage("Couldn't recognize the input");
			return getUserSelection();
		}
		return output;
	}
	
	public int getUserMenu() {
		String input = getStringInput();
		int output = 0;
		try {
		switch(input) {
		case "1": output = 1;
		break;
		case "2": output = 2;
		break;
		case "3": output = 3;
		break;
		default: throw new UnknownInputException();
		} } catch (UnknownInputException e) {
			TUI.printMessage("Couldn't recognize the input");
			return getUserMenu();
		} 
		return output;
	}

	public int getManageMenu() {
		String input = getStringInput();
		int output = 0;
		try {
		switch(input) {
		case "1": output = 1;
		break;
		case "2": output = 2;
		break;
		case "3": output = 3;
		break;
		default: throw new UnknownInputException();
		} } catch (UnknownInputException e) {
			TUI.printMessage("Couldn't recognize the input");
			return getUserMenu();
		} 
		return output;
	}

	public int getAdminMenu(){
		String input = getStringInput();
		int output = 0;
		try {
		switch(input) {
		case "1": output = 1;
		break;
		case "2": output = 2;
		break;
		case "3": output = 3;
		break;
		case "4": output = 4;
		break;
		case "5": output = 5;
		break;
		case "6": output = 6;
		break;
		case "7": output = 7;
		break;
		default: throw new UnknownInputException();
		} } catch (UnknownInputException e) {
			TUI.printMessage("Couldn't recognize the input");
			return getUserMenu();
		} 
		return output;
	}

	public int getMainMenu() {
		String input = getStringInput();
		int output = 0;
		try {
		switch(input) {
		case "1": output = 1;
		break;
		case "2": output = 2;
		break;
		case "3": output = 3;
		break;
		default: throw new UnknownInputException();
		} } catch (UnknownInputException e) {
			TUI.printMessage("Couldn't recognize the input");
			return getUserMenu();
		} 
		return output;
	}
	
	public void printMessage(String message) {
		TUI.printMessage(message);
	}
}
