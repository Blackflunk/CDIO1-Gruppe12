package boundary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TUI implements IUI{
	BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
	
	@Override
	public void endMessage() {
		System.out.println("You have terminated the program. ");
		
	}

	@Override
	public String getUserName() throws IOException {
		System.out.println("Enter your full name: ");
		return inFromUser.readLine();
	}

	@Override
	public String cprNumber() throws IOException {
		System.out.println("Enter CPR-Number (XXXXXX-XXXX): ");
		return inFromUser.readLine();
	}

	@Override
	public void showPassword(String password) {
		System.out.println("Your auto-generated password is: " + password + "\n Write it down.");
	}

	@Override
	public void changeNameFailed() {
		System.out.println("Something went wrong when changing your name.");
		
	}

	@Override
	public void changeNameSucces() {
		System.out.println("You succesfully changed your name!");
	}

	@Override
	public void changePasswordFailed() {
		System.out.println("Something went wrong when changing your password.");
		
	}

	@Override
	public void changePasswordSucces() {
		System.out.println("You succesfully changed your password!");		
	}

	@Override
	public void loginSuccesMessage() {
		System.out.println("You succesfully logged in!");
		
	}

	@Override
	public void loginFailedMessage() {
		System.out.println("Your password or username is incorrect.");
		
	}

	@Override
	public void logoutSuccesMessage() {
		System.out.println("You succesfully logged out.");
	}

	@Override
	public void logoutFailedMessage() {
		System.out.println("Something went wrong when trying to log you out.");		
	}

	@Override
	public void createUserFailedMessage(String Errortype) {
		switch(Errortype){
		case "CPRError" : System.out.println("Your CPR-number is not valid.");
		case "nameerror" : System.out.println("Your full name caused an error.");
		default : System.out.println("An error occured creating your account.");
		}
	}

	@Override
	public void createUserSuccesMessage() {
		System.out.println("You succesfully created your account.");		
	}

	@Override
	public int insertWeight() throws IOException {
		int message = 0;
		System.out.println("Enter your weight: ");
		String m = inFromUser.readLine();
		
		try{
			message = Integer.parseInt(m);
		}
		catch(NumberFormatException e){
			System.out.println("Not a valid weight.");
			insertWeight();
		}
		
		return message;	
	}

	@Override
	public int insertTara() throws IOException {
		int message = 0;
		System.out.println("Enter your tara value: ");
		String m = inFromUser.readLine();
		
		try{
			message = Integer.parseInt(m);
		}
		catch(NumberFormatException e){
			System.out.println("Not a valid tara value.");
			insertTara();
		}
		
		return message;	
	}

	@Override
	public void showResult(int gross) {
		System.out.println("The weight shows: " + gross);
		
	}

	@Override
	public void showWeightMessage(String name) {
		System.out.println("Welcome to the IO Interactive weight software, " + name + " Hope you enjoy.");
	}

	@Override
	public String changeName() throws IOException {
		System.out.println("Write your new name: ");
		return inFromUser.readLine();
	}

	@Override
	public String changePassword() throws IOException {
		System.out.println("Write your new password: ");
		return inFromUser.readLine();
	}

	@Override
	public void showUserList(int[] IDList, String[] nameList) {
		for (int i=0; i<IDList.length;i++){
			System.out.println(i+1 + "." + "ID: " + IDList[i] + ": \t Name:" + nameList[i]);
		}
	}

	@Override
	public int deleteUser() throws IOException {
		int message = 0;
		System.out.println("Enter the ID of the user you want to delete: ");
		String m = inFromUser.readLine();
		
		try{
			message = Integer.parseInt(m);
		}
		catch(NumberFormatException e){
			System.out.println("Not a valid user.");
			deleteUser();
		}
		return message;	
	}

	@Override
	public int makeUserAdmin() throws IOException {
		int message = 0;
		System.out.println("Enter the ID of the user you want to make admin: ");
		String m = inFromUser.readLine();
		
		try{
			message = Integer.parseInt(m);
		}
		catch(NumberFormatException e){
			System.out.println("Not a valid user.");
			makeUserAdmin();
		}
		return message;	
	}

	@Override
	public int showUserMenu() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int showManageMenu() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int showAdminMenu() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int showMainMenu() {
		// TODO Auto-generated method stub
		return 0;
	}

}
