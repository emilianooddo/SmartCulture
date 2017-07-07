
public class Utente {

	private String nome;
	private String cognome;
	private String email;
	private String password;
	private String data;
	private String foto;
	
	public Utente(String nome, String cognome,String email,String password,String data,String foto){
		
		this.nome = new String(nome);
		this.cognome=new String (cognome);
		this.email=new String(email);
		this.password = new String(password);
		this.data = data;
		this.foto = foto;
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
	public String getFoto(){
		return this.foto;
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
	public void setFoto(String foto){
		this.foto = foto;
	}

	public String toString(){
		return "Info: \n"+ " Nome: " + getNome() +"\n" + " Cognome: " + getCognome() +"\n" + " Data di nascita: " + getData() +"\n"; 
	}
}

