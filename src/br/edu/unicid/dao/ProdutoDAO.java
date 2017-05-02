package br.edu.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.mysql.jdbc.StringUtils;

import br.edu.unicid.bean.FiltroProduto;
import br.edu.unicid.bean.Produto;
import br.edu.unicid.util.ConnectionFactory;

public class ProdutoDAO {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Produto produto;
	private FiltroProduto filtroProduto;

	public ProdutoDAO() throws Exception {
		try {
			conn = ConnectionFactory.getConnection();
		} catch (Exception e) {

			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	// método de salvar
	public void salvar(Produto produto) throws Exception {
		if (produto == null)
			throw new Exception("O valor passado não pode ser nulo");

		try {
			String SQL = "INSERT INTO tb_produto (nome, preco, promocao, categoria, descricao) values (?,?,?,?,?)";

			ps = conn.prepareStatement(SQL);
			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getPreco());
			ps.setBoolean(3, produto.isPromocao());
			ps.setString(4, produto.getCategoria());
			ps.setString(5, produto.getDescricao());
			ps.executeUpdate();

		} catch (SQLException sqle) {

		}

	}

	// método de editar
	public void editar(Produto produto) throws Exception {
		if (produto == null)
			throw new Exception("O valor passado não pode ser nulo");

		try {
			String SQL = "UPDATE tb_produto SET nome = ?, preco = ?, promocao = ?, categoria = ?, descricao = ? where id= ? ";

			ps = conn.prepareStatement(SQL);
			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getPreco());
			ps.setBoolean(3, produto.isPromocao());
			ps.setString(4, produto.getCategoria());
			ps.setString(5, produto.getDescricao());
			ps.setLong(6, produto.getId());
			ps.executeUpdate();

		} catch (SQLException sqle) {

		}

	}

	// método de Deletar
	public void excluir(int id) throws Exception {
		if (id == 0)
			throw new Exception("O valor passado não pode ser nulo");

		try {
			String SQL = "DELETE FROM tb_produto WHERE id=?";

			ps = conn.prepareStatement(SQL);
			ps.setLong(1, id);
			ps.executeUpdate();

		} catch (SQLException sqle) {

		}

	}

	// método procurar produto
	public List<Produto> procurarProdutoByFiltro(FiltroProduto filtro) throws Exception {
		if (filtro.equals(null)) {
			throw new Exception("O valor passado não pode ser nulo");
		}
		try {
			StringBuilder SQL = new StringBuilder();
			SQL.append("SELECT * FROM tb_produto where");

			if (!StringUtils.isNullOrEmpty(filtro.getNome())) {
				SQL.append(" nome like ? and");
			}

			if (filtro.isApenasPromocao() == true) {
				SQL.append(" promocao = 1 and");
			} else {
				SQL.append(" promocao = 0 and");
			}

			if (!(filtro.getPreco() == 0)) {
				SQL.append(" preco <=? and");
			}

			if (!StringUtils.isNullOrEmpty(filtro.getCategoria())
					&& (!Objects.equals("..::Todas::..", filtro.getCategoria()))) {
				SQL.append(" categoria=? and");
			}

			SQL.append(" id = id");

			List<Produto> lista = new ArrayList<Produto>();

			// TODO, incluir na consulta apenas os campos que serão utilizados e
			// Melhorar Apresentação na tela
			ps = conn.prepareStatement(SQL.toString());
			ps.setString(1, '%' + filtro.getNome() + '%');
			ps.setDouble(2, filtro.getPreco());
			ps.setString(3, filtro.getCategoria());
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String preco = rs.getString("preco");
				boolean promocao = rs.getBoolean("promocao");
				String categoria = rs.getString("categoria");
				String descricao = rs.getString("descricao");

				// objeto anonimo
				lista.add(new Produto(id, nome, preco, promocao, categoria, descricao));

				produto = new Produto(id, nome, preco, promocao, categoria, descricao);
			}
			return lista;

		} catch (SQLException sqle) {
			throw new Exception("Erro: \n" + sqle.getMessage());
		}

	}

	// método listar todos
	public List<Produto> listarProdutos() throws Exception {

		try {
			String SQL = "SELECT * FROM tb_produto";

			// lista vazia
			List<Produto> lista = new ArrayList<Produto>();

			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String preco = rs.getString("preco");
				boolean promocao = rs.getBoolean("promocao");
				String categoria = rs.getString("categoria");
				String descricao = rs.getString("descricao");

				// objeto anonimo
				lista.add(new Produto(id, nome, preco, promocao, categoria, descricao));

				produto = new Produto(id, nome, preco, promocao, categoria, descricao);
			}

			return lista;

		} catch (SQLException sqle) {
			throw new Exception("Erro: \n" + sqle.getMessage());
		} finally {
		}
	}

	public Produto procurarProdutoById(FiltroProduto filtro) throws Exception {
		if (filtro.equals(null)) {
			throw new Exception("O valor passado não pode ser nulo");
		}
		try {
			StringBuilder SQL = new StringBuilder();
			SQL.append("SELECT * FROM tb_produto where");
			SQL.append(" id = ?");

			ps = conn.prepareStatement(SQL.toString());
			ps.setLong(1, filtro.getId());
			rs = ps.executeQuery();
			if (rs.next()) {

				String nome = rs.getString("nome");
				int id = rs.getInt("id");
				String preco = rs.getString("preco");
				boolean promocao = rs.getBoolean("promocao");
				String categoria = rs.getString("categoria");
				String descricao = rs.getString("descricao");
				produto = new Produto(id, nome, preco, promocao, categoria, descricao);
			}
			return produto;

		} catch (SQLException sqle) {
			throw new Exception("Erro: \n" + sqle.getMessage());
		}

	}

	public List<String> listarCategorias() throws Exception {

		try {
			String SQL = "SELECT * FROM tb_produto";
			// lista vazia
			List<String> lista = new ArrayList<String>();

			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();

			while (rs.next()) {
				String categoria = rs.getString("categoria");
				lista.add(categoria);
			}
			return lista;

		} catch (SQLException sqle) {
			throw new Exception("Erro: \n" + sqle.getMessage());
		} finally {
		}
	}

}
