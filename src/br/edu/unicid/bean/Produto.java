package br.edu.unicid.bean;

public class Produto {

	// atributos
	private int id;
	private String nome;
	private String preco;
	private boolean promocao;
	private String categoria;
	private String descricao;

	// construtor vazio
	public Produto() {

	}

	// contrutor com campos
	public Produto(int id, String nome, String preco, boolean promocao, String categoria, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.promocao = promocao;
		this.categoria = categoria;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public boolean isPromocao() {
		return promocao;
	}

	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}