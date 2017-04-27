package br.edu.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unicid.bean.Usuario;
import br.edu.unicid.util.ConnectionFactory;

public class UsuarioDAO {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Usuario usuario;

	public UsuarioDAO() throws Exception {
		try {
			conn = ConnectionFactory.getConnection();
		} catch (Exception e) {

			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	// método de salvar
	public void salvar(Usuario usuario) throws Exception {
		if (usuario == null)
			throw new Exception("O valor passado não pode ser nulo");

		try {
			String SQL = "INSERT INTO tb_usuario (user, password) values (?,?)";

			ps = conn.prepareStatement(SQL);
			ps.setString(1, usuario.getUser());
			ps.setString(2, usuario.getPassword());
			ps.executeUpdate();

		} catch (SQLException sqle) {

		}

	}

	// método de alterar senha
	public void alterarSenha(Usuario usuario) throws Exception {
		if (usuario == null)
			throw new Exception("O valor passado não pode ser nulo");

		try {
			String SQL = "UPDATE tb_usuario SET password=? where user=?";

			ps = conn.prepareStatement(SQL);
			ps.setString(1, usuario.getUser());
			ps.setString(2, usuario.getPassword());
			ps.executeUpdate();

		} catch (SQLException sqle) {

		}

	}

	// método de Deletar
	public void excluir(Usuario usuario) throws Exception {
		if (usuario == null)
			throw new Exception("O valor passado não pode ser nulo");

		try {
			String SQL = "DELETE FROM tb_usuario WHERE user=?";

			ps = conn.prepareStatement(SQL);
			ps.setString(1, usuario.getUser());
			ps.executeUpdate();

		} catch (SQLException sqle) {

		}

	}

	// método procurar usuario
	public Usuario procurarUsuario(String userDigitado) throws Exception {
		if (userDigitado.equals(null)) {
			throw new Exception("O valor passado não pode ser nulo");
		}
		try {
			String SQL = "SELECT * FROM tb_usuario WHERE user=?";

			ps = conn.prepareStatement(SQL);
			ps.setString(1, userDigitado);
			rs = ps.executeQuery();
			if (rs.next()) {
				String user = rs.getString("user");
				String password = rs.getString("password");
				usuario = new Usuario(user, password);
			}

		} catch (SQLException sqle) {
			throw new Exception("Erro: \n" + sqle.getMessage());
		}
		return usuario;
	}

	// método listar todos
	public List<Usuario> listarUsuarios() throws Exception {

		try {
			String SQL = "SELECT * FROM tb_usuario";

			// lista vazia
			List<Usuario> lista = new ArrayList<Usuario>();

			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				String user = rs.getString("user");
				String password = rs.getString("password");

				// objeto anonimo
				lista.add(new Usuario(user, password));

				usuario = new Usuario(user, password);
			}

			return lista;

		} catch (SQLException sqle) {
			throw new Exception("Erro: \n" + sqle.getMessage());
		} finally {
		}
	}

	// método Login
	public Boolean login(Usuario usuario ) throws Exception {
		if (usuario.getUser().equals(null)) {
			throw new Exception("O valor passado não pode ser nulo");
		}
		try {
			String SQL = "SELECT * FROM tb_usuario WHERE user=? and password=?";

			ps = conn.prepareStatement(SQL);
			ps.setString(1, usuario.getUser());
			ps.setString(2, usuario.getPassword());
			rs = ps.executeQuery();
			if (!rs.next()) {
				return false;
			} else {
				return true;
			}

		} catch (SQLException sqle) {
			throw new Exception("Erro: \n" + sqle.getMessage());
		}

	}
}
