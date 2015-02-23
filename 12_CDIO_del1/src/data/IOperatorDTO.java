package data;

import java.util.ArrayList;

import exceptions.DALException;

public interface IOperatorDTO {
	OperatorDTO getOperator(int oprId) throws DALException;
	OperatorDTO getOperatorFromIndex(int index) throws DALException;
	ArrayList<OperatorDTO> getOperatorList() throws DALException;
	String createOperator(String Navn, String CPR, boolean admin) throws DALException;
	void updateOperator(OperatorDTO opr) throws DALException;	
	

}


