package boundary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import exceptions.UnknownInputException;

public class oldTUI implements IUI{
	private BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
	
	@Override
	public void endMessage() {
		System.out.println("#######################################");
		System.out.println("You have terminated the program. ");
		System.out.println("Bye bye");
		System.out.println("#######################################");
		
	}

	@Override
	public String getUserName() throws IOException {
		System.out.println("Enter your full name: ");
		return inFromUser.readLine();
	}
	@Override
	public String enterUserName() throws IOException{
		System.out.println("Enter your full name");
		return inFromUser.readLine();
	}
	@Override 
	public String enterCPR() throws IOException {
		System.out.println("Enter your CPR");
		return inFromUser.readLine();
	}
	@Override 
	public String enterPassword() throws IOException {
		System.out.println("Enter your password");
		return inFromUser.readLine();
	}
	@Override
	public void showNoInput() {
		System.out.println("No input detected");
	}

	@Override
	public String cprNumber() throws IOException {
		System.out.println("Enter your CPR-Number (format: XXXXXX-XXXX): ");
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
	public void tryAgainWeight() {
		System.out.println("Run weight again? Y/N");
	}

	@Override
	public void showWeightMessage(String name) {
		System.out.println("Welcome to the IO Interactive weight software, " + name + " \n Hope you enjoy.");
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
	
	
	
	// Menus

	@Override
	public int getUserMenu() throws UnknownInputException, IOException {
		String input = inFromUser.readLine();
		switch(input) {
		case "1": return 1;
		case "2": return 2;
		case "3": return 3;
		default: throw new UnknownInputException("Not a valid Input");
		}
	}

	@Override
	public int getManageMenu() throws IOException, UnknownInputException {
		String input = inFromUser.readLine();
		switch(input) {
		case "1": return 1;
		case "2": return 2;
		case "3": return 3;
		default: throw new UnknownInputException("Not a valid Input");
		}
	}

	@Override
	public int getAdminMenu() throws IOException, UnknownInputException{
		String input = inFromUser.readLine();
		switch(input) {
		case "1": return 1;
		case "2": return 2;
		case "3": return 3;
		case "4": return 4;
		case "5": return 5;
		case "6": return 6;
		default: throw new UnknownInputException("Not a valid Input");
		}
	}

	@Override
	public int getMainMenu() throws IOException, UnknownInputException {
		String input = inFromUser.readLine();
		switch(input) {
		case "1": return 1;
		case "2": return 2;
		case "3": return 3;
		default: throw new UnknownInputException("Not a valid Input");
		}
	}
	
	@Override
	public void showMainMenu() {
		System.out.println("#######################################");
		System.out.println("Main menu \n");
		System.out.println("1. Create Account \n"+"2. Log in to excisting account \n"+"3. Exit program");
		System.out.println("#######################################");
	}
	
	@Override
	public void showAdminMenu(String username) {
		System.out.println("#######################################");
		System.out.println("Logged in as: "+username);
		System.out.println("#######################################");
		System.out.println("User options \n");
		System.out.println("1. Account management \n"+"2. Acces weight \n"+"3. Log out \n");
		System.out.println("Admin options \n");
		System.out.println("4. Show list of all users \n"+"5. Delete user"+"6. Make user admin");
		System.out.println("#######################################");
	}
	
	@Override
	public void showManageMenu(String username) {
		System.out.println("#######################################");
		System.out.println("Logged in as: "+username);
		System.out.println("#######################################");
		System.out.println("Account management \n");
		System.out.println("1. Change name \n"+"2. change password \n"+"3. back");
		System.out.println("#######################################");
	}
	
	@Override
	public void showUserMenu(String username) {
		System.out.println("#######################################");
		System.out.println("Logged in as: "+username);
		System.out.println("#######################################");
		System.out.println("Usermenu \n");
		System.out.println("1. Account management \n"+"2. Acces weight \n"+"3. Log out");
		System.out.println("#######################################");
	}
	
	public void showInputFailure() {
		System.out.println("Not a recognized input");
		System.out.println("Please try again:");
	}

	@Override
	public boolean tryAgain() throws UnknownInputException, IOException {
		String input = inFromUser.readLine();
		switch(input) {
		case "Y": return true;
		case "N": return false;
		default: throw new UnknownInputException("Not a valid Input");
		}
	}

}
