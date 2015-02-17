package funktionality;
import java.util.List;
import data.OperatorDTO;


public interface IDatalogic {
	public OperatorDTO getOperator(int oprId) throws DALException;
	public List<OperatorDTO> getOperators();
	public void addToList(OperatorDTO addInput);
	public boolean deleteFromList(int index);
	void updateOperator(OperatorDTO opr) throws DALException;
	String createOperator(OperatorDTO opr) throws DALException;
}
