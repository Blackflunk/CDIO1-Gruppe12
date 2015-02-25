package data;

import java.util.ArrayList;

import exceptions.DALException;
import exceptions.InvalidPasswordException;

public interface IOperatorDTO {
	OperatorDTO getOperator(String CPR) throws DALException;	
	void addToList(OperatorDTO addInput) throws DALException;
	boolean deleteFromList(int index);
	String createOperator(String Navn, String CPR, boolean admin) throws DALException;
	void updateOperator(String CPR, int Cnum, String Change) throws DALException;
	int generateOprID() throws DALException;
	void validateChangePassword(String password) throws InvalidPasswordException;
	String generatePassword();
	String getIni(String name);
	String getOprName(String CPR);
	boolean validateUser(String username, String password);
	void sortUserList();
	ArrayList<OperatorDTO> getOperatorList() throws DALException;
	boolean isUserAdmin(String CPR);
	OperatorDTO getOperatorFromIndex(int index) throws DALException;

}


