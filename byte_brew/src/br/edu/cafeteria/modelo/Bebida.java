package br.edu.cafeteria.modelo;

public class Bebida extends Produto{
	
	private String tamanho;
	private double cafeina;
	private boolean quente;
	
	public Bebida(String nomeProduto, double precoBase, int quantidadeEstoque, int codigo, String tamanho, double cafeina, boolean quente) {
		super(nomeProduto, precoBase, quantidadeEstoque, codigo);
		this.tamanho = tamanho;
		this.cafeina = cafeina;
		this.quente = quente;
	}
	
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public void setCafeina(double cafeina){
		this.cafeina = cafeina;
	}
	public void setQuente(boolean quente) {
		this.quente = quente;
	}
	
	public String getTamanho() {
		return tamanho;
	}
	public double getCafeina() {
		return cafeina;
	}
	public boolean getQuente() {
		return quente;
	}
}
