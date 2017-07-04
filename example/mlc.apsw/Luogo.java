
public class Luogo {

	private String citta;
	private float x;
	private float y;
	private String tipo;
	private String nome;
	
	public Luogo(String citta, float x,float y,String tipo,String nome){
		
		this.citta = new String(citta);
		this.x=x;
		this.y=y;
		this.tipo = new String(tipo);
		this.nome = nome;
		}
	public Luogo(){}
		
	public String getCitta(){
		return this.citta;
	}
	public float getX(){
		return this.x;
	}
	public float getY(){
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
	public void setX(float x){
		this.x = x;
	}
	public void setY(float y){
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
