
public class Luogo {

	private String nome;
	private String citta;
	private String tipo;
	private String x;
	private String y;

	
	public Luogo(String nome, String citta, String tipo, String x,String y){
		
		this.nome = nome;
		this.citta = new String(citta);
		this.tipo = new String(tipo);
		this.x=new String (x);
		this.y=new String(y);
		
		}
	public Luogo(){}
		
	public String getNome(){
		return this.nome;
	}
	public String getCitta(){
		return this.citta;
	}
	public String getTipo(){
		return this.tipo;
	}
	public String getX(){
		return this.x;
	}
	public String getY(){
		return this.y;
	}
	
	
	public void setNome(String nome){
		this.nome = nome;
	}	
	public void setCitta(String citta){
		this.citta = citta;
	}
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	public void setX(String x){
		this.x = x;
	}
	public void setY(String y){
		this.y = y;
	}
	
	

	public String toString(){
		return "Luogo di interesse: \n"+ " Citta: " + getCitta() +"\n" + " Nome: " + getNome() +"\n" + " x: " + getX() +"\n" + " y: " + getY() +"\n" + " Tipo: " + getTipo() +"\n"; 
	}
	
}