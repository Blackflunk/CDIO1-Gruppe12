package control;
import java.io.IOException;

import exceptions.UnknownInputException;
import funktionality.IWeightLogic;
import funktionality.WeightLogic;
import boundary.TUI;
public class WeightController implements IWeightLogic {
	private TUI TUI;
	private WeightLogic WL = new WeightLogic();
	
	public WeightController(TUI TUI){
		TUI = new TUI();
	}
	
	public void runWeight(String username) {
		boolean run=true;
		while(run){
		TUI.showWeightMessage(username);
		int weight=getWeight();
		int tara=getTara();
		int result = WL.useWeight(weight, tara);
		TUI.showResult(result);
		if (!runAgain())
			run=false;
		}
	}
	
	public int getWeight() {
		int option = 0;
		try{
			option = TUI.insertWeight();
		} catch (IOException e) {
			TUI.showNoInput();
			getWeight();
		}
		return option;
	}
	public int getTara() {
		int option = 0;
		try{
			option = TUI.insertTara();
		} catch (IOException e) {
			TUI.showNoInput();
			getTara();
		}
		return option;
	}
	
	boolean runAgain() {
		boolean goagain=false;
		try {
			goagain=TUI.tryAgain();
		}catch(UnknownInputException e) {
			TUI.showInputFailure();
			runAgain();
		} catch (IOException e) {
			TUI.showNoInput();
			runAgain();
		}
		return goagain;
	}

}
