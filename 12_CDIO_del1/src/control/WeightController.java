package control;

import funktionality.IWeightLogic;
import funktionality.WeightLogic;
public class WeightController implements IWeightLogic {
	private IOController IO;
	private WeightLogic WL = new WeightLogic();
	
	public WeightController(IOController IO){
		this.IO = IO;
	}
	
	public void runWeight(String username) {
		boolean run=true;
		IO.printMessage("Welcome to the IO Interactive weight software, " + username + " \n Hope you enjoy.");
		while(run){
		IO.printMessage("Enter your weight: ");
		int weight=IO.getIntInput();
		IO.printMessage("Enter your tara-value: ");
		int tara=IO.getIntInput();
		int result = WL.useWeight(weight, tara);
		IO.printMessage("The weight shows: "+result);
		if (IO.getUserSelection()==false)
			run=false;
		}
	}

}
