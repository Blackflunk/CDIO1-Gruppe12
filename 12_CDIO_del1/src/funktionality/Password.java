package funktionality;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Password {

	public static void main(String[]args){
		password();
	}

	public static void password(){
		
		//initialiserer variable
		String SmaaBogstaver = "abcdefghijklmnopqrstuvwxyz";
		String StoreBogstaver = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String TilladteTegn = ".-_+!?=";
		String Tal = "0123456789";
		ArrayList<char[]> PwD = new ArrayList<char[]>();
		char[] PwDchar = null;
		String password = "";
		Random StringRNG = new Random();
		int counter[] = {0,0,0,0,0}, pwdcount = 0;
		int randomtal = 0, case0 = 0, case1 = 0, case2 = 0, case3 = 0;
		
		//løkken sørger for der er 6 characters i password
		while(pwdcount < 6){
			
			//Finder et tilfældigt tal mellem 0 og 3 til switch-casen
			randomtal = StringRNG.nextInt(4);
			/* 
			 * Her sørger Switch-casen for der er mindst 1 af hver af de krævede
			 * tegn, herudover er det tilfældigt hvor mange af hver der kommer, men
			 * stadig ikke mere end 6 i alt.
			 */
			
			switch(randomtal){
			case 0: counter[0]++;
			if (counter[0] < 2) {
				pwdcount++;
				case0++;
				PwD.add(new char[] {SmaaBogstaver.charAt(StringRNG.nextInt(SmaaBogstaver.length()))});
			}
			else if (case1 > 0 && case2 > 0 && case3 > 0){
				case0++;
				pwdcount++;
				PwD.add(new char[] {SmaaBogstaver.charAt(StringRNG.nextInt(SmaaBogstaver.length()))});
			}
			else {
				break;
			}
				break;

			case 1:  counter[1]++;
			if (counter[1] < 2) {
				case1++;
				pwdcount++;
				PwD.add(new char[] {StoreBogstaver.charAt(StringRNG.nextInt(StoreBogstaver.length()))});
			}
			else if (case0 > 0 && case2 > 0 && case3 > 0){
				case1++;
				pwdcount++;
				PwD.add(new char[] {StoreBogstaver.charAt(StringRNG.nextInt(StoreBogstaver.length()))});
			}
			else {
				break;
			}
				break;

			case 2: counter[2]++;
			if (counter[2] <= 2) {
				case2++;
				pwdcount++;
				PwD.add(new char[] {TilladteTegn.charAt(StringRNG.nextInt(TilladteTegn.length()))});
			}
			else if (case0 > 0 && case1 > 0 && case3 > 0){
				case2++;
				pwdcount++;
				PwD.add(new char[] {TilladteTegn.charAt(StringRNG.nextInt(TilladteTegn.length()))});
			}
			else {
				break;
			}
				break;

			case 3: counter[3]++;
			if (counter[3] <= 2) {
				case3++;
				pwdcount++;
				PwD.add(new char[] {Tal.charAt(StringRNG.nextInt(Tal.length()))});
			}
			else if (case0 > 0 && case1 > 0 && case2 > 0){
				case3++;
				pwdcount++;
				PwD.add(new char[] {Tal.charAt(StringRNG.nextInt(Tal.length()))});
			}
			else{
				break;
			}
				break;
			default: break;
			}
		}

		//Indsætter de chars der udgør kodeordet til String-variablen password
		for (int i = 0;i < PwD.size();i++){
			PwDchar = PwD.get(i);
			password += String.copyValueOf(PwDchar);
		}
		
		//Her skal der returnes password til databasen når den er færdiglavet
		System.out.println(password);
	}
}
