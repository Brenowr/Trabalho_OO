package br.edu.cafeteria.modelo;

public class Comida extends Produto {
	
	private double tempoPreparo;
	private boolean vegano;
	private boolean gluten;
	private boolean confeitaria;
	
	public Comida(String nomeProduto, double precoBase, int quantidadeEstoque, int tempoPreparo, boolean vegano, boolean gluten, boolean confeitaria) {
		super(nomeProduto, precoBase, quantidadeEstoque);
		this.tempoPreparo = tempoPreparo;
		this.vegano = vegano;
		this.gluten = gluten;
		this.confeitaria = confeitaria;
	}
	
	public void setTempoPreparo(double tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}
	public void setVegano(boolean vegano) {
		this.vegano = vegano;
	}
	public void setGluten(boolean gluten) {
		this.gluten = gluten;
	}
	public void setConfeitaria(boolean confeitaria) {
		this.confeitaria = confeitaria;
	}
	
	public double getTempoPreparo() {
		return tempoPreparo;
	}
	public String getVegano() {
		if(this.vegano) {
			return "sim";
			
		}
		
		return "Não";
	}
	public String getGluten() {
		if(this.gluten) {
			return "sim";
			
		}
		
		return "Não";
	}
	
	public String getConfeitaria() {
		if(this.confeitaria) {
			return "sim";
			
		}
		
		return "Não";
	}
	
	
}
