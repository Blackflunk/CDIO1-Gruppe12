package data;

public class OperatorDTO {

	private int oprId;
	private String oprNavn;
	private String ini;
	private String cpr;
	private boolean admin;
	private String Password;
	
	public OperatorDTO(int oprId, String oprNavn, String ini, String cpr, boolean admin, String Password){
		this.admin = admin;
		this.cpr = cpr;
		this.ini = ini;
		this.oprNavn = oprNavn;
		this.oprId = oprId;
		this.Password = Password;
	}
	
	public int getOprId() {
		return oprId;
	}
	public void setOprId(int oprId) {
		this.oprId = oprId;
	}
	public String getOprNavn() {
		return oprNavn;
	}
	public void setOprNavn(String oprNavn) {
		this.oprNavn = oprNavn;
	}
	public String getIni() {
		return ini;
	}
	public void setIni(String ini) {
		this.ini = ini;
	}
	public String getCpr() {
		return cpr;
	}
	public void setCpr(String cpr) {
		this.cpr = cpr;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	public boolean getAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
