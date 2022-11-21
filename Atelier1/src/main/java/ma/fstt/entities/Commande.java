package ma.fstt.entities;

import java.io.Serializable;
import java.util.Date;

public class Commande implements Serializable{
	private int id;
	private String codeCmd;
	private String dateCmd;
	private int clientId;
	public Commande() {
		// TODO Auto-generated constructor stub
	}
	public Commande(String codeCmd,String dateCmd,int clientId) {
		// TODO Auto-generated constructor stub
		this.codeCmd=codeCmd;
		this.dateCmd=dateCmd;
		this.clientId=clientId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodeCmd() {
		return codeCmd;
	}
	public void setCodeCmd(String codeCmd) {
		this.codeCmd = codeCmd;
	}
	public String getDateCmd() {
		return dateCmd;
	}
	public void setDateCmd(String dateCmd) {
		this.dateCmd = dateCmd;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

}
