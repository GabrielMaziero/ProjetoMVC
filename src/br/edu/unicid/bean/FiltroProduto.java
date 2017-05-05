package br.edu.unicid.bean;

public class FiltroProduto {

	// atributos
	private int id;
	private String nome;
	private double preco;
	private boolean apenasPromocao;
	private String categoria;
	private String descricao;

	// construtor vazio
	public FiltroProduto() {

	}

	// contrutor com campos
	public FiltroProduto(int id, String nome, double preco, boolean apenasPromocao, String categoria,
			String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.apenasPromocao = apenasPromocao;
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isApenasPromocao() {
		return apenasPromocao;
	}

	public void setApenasPromocao(boolean apenasPromocao) {
		this.apenasPromocao = apenasPromocao;
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