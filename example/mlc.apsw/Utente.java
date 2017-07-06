
public class Utente {

	private String nome;
	private String cognome;
	private String email;
	private String password;
	private String data;
	
	public Utente(String nome, String cognome,String email,String password,String data){
		
		this.nome = new String(nome);
		this.cognome=new String (cognome);
		this.email=new String(email);
		this.password = new String(password);
		this.data = data;
		}
	public Utente(){}
		
	public String getNome(){
		return this.nome;
	}
	public String getCognome(){
		return this.cognome;
	}
	public String getData(){
		return this.data;
	}
	public String getEmail(){
		return this.email;
	}
	
	
	public void setNome(String nome){
		this.nome = nome;
	}
	public void setCognome(String cognome){
		this.cognome = cognome;
	}
	public void setData(String data){
		this.data = data;
	}
	public void setTipo(String email){
		this.email = email;
	}
	public void setPassword(String password){
		this.password = password;
	}
	

	public String toString(){
		return "Info: \n"+ " Nome: " + getNome() +"\n" + " Cognome: " + getCognome() +"\n" + " Data di nascita: " + getData() +"\n"; 
	}
}

