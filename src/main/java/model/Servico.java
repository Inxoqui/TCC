package model;

public class Servico {
	private int idServico;
	private String nome;
	private double valor;

	// CRIANDO O CONSTRUTOR
	public Servico() {
		super();
	}

	// CRIANDO O CONSTRUTOR USANDO OS ATRIBUTOS
	public Servico(int idServico, String nome, double valor) {
		super();
		this.idServico = idServico;
		this.nome = nome;
		this.valor = valor;
	}

	// GETTERS E SETTERS
	public int getidServico() {
		return idServico;
	}

	public void setidServico(int idServico) {
		this.idServico = idServico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
