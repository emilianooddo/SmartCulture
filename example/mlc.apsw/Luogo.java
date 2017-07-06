
public class Luogo {

	private String citta;
	private String x;
	private String y;
	private String tipo;
	private String nome;
	
	public Luogo(String citta, String x,String y,String tipo,String nome){
		
		this.citta = new String(citta);
		this.x=new String (x);
		this.y=new String(y);
		this.tipo = new String(tipo);
		this.nome = nome;
		}
	public Luogo(){}
		
	public String getCitta(){
		return this.citta;
	}
	public String getX(){
		return this.x;
	}
	public String getY(){
		return this.y;
	}
	public String getTipo(){
		return this.tipo;
	}
	public String getNome(){
		return this.nome;
	}
	
	
	
		
		
	public void setCitta(String citta){
		this.citta = citta;
	}
	public void setX(String x){
		this.x = x;
	}
	public void setY(String y){
		this.y = y;
	}
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	public void setNome(String nome){
		this.tipo = nome;
	}
	

	public String toString(){
		return "Luogo di interesse: \n"+ " Citta: " + getCitta() +"\n" + " Nome: " + getNome() +"\n" + " x: " + getX() +"\n" + " y: " + getY() +"\n" + " Tipo: " + getTipo() +"\n"; 
	}
}
