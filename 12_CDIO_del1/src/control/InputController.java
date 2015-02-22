package control;

import java.io.IOException;
import exceptions.UnknownInputException;
import boundary.oldTUI;

public class InputController {
	private oldTUI TUI;
	
	public InputController(oldTUI TUI){
		this.TUI = TUI;
	}
	public String getUserName() {
		String option = "";
		try{
			option = TUI.enterUserName();
		} catch (IOException e) {
			TUI.showNoInput();
			getUserName();
		}
		return option;
	}
	public String getCPR() {
		String option = "";
		try{
			option = TUI.enterCPR();
		} catch (IOException e) {
			TUI.showNoInput();
			getCPR();
		}
		return option;
	}
	public String getPassword() {
		String option = "";
		try{
			option = TUI.enterPassword();
		} catch (IOException e) {
			TUI.showNoInput();
			getPassword();
		}
		return option;
	}
	
	public int getMainMenu() {
		int option=-1;
		try {
			option = TUI.getMainMenu();
		} catch (UnknownInputException e) {
			TUI.showInputFailure();
			getMainMenu();
		} catch (IOException e) {
			TUI.showNoInput();
			getMainMenu();
		}
		return option;
	}
	public int getUserMenu() {
		int option=-1;
		try {
			option = TUI.getUserMenu();
		} catch (UnknownInputException e) {
			TUI.showInputFailure();
			getUserMenu();
		} catch (IOException e) {
			TUI.showNoInput();
			getUserMenu();
		}
		return option;
	}
	public int getAdminMenu() {
		int option=-1;
		try {
			option = TUI.getAdminMenu();
		} catch (UnknownInputException e) {
			TUI.showInputFailure();
			getAdminMenu();
		} catch (IOException e) {
			TUI.showNoInput();
			getAdminMenu();
		}
		return option;
	}
	public int getManageMenu() {
		int option=-1;
		try {
			option = TUI.getManageMenu();
		} catch (UnknownInputException e) {
			TUI.showInputFailure();
			getManageMenu();
		} catch (IOException e) {
			TUI.showNoInput();
			getManageMenu();
		}
		return option;
	}

}
