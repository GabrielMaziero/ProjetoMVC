package br.edu.unicid.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.unicid.bean.Usuario;
import br.edu.unicid.dao.UsuarioDAO;

import com.mysql.jdbc.StringUtils;
import java.awt.Window.Type;

public class NovoUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoUsuario frame = new NovoUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NovoUsuario() {
		setResizable(false);
		setTitle("Cadastro de Usu\u00E1rio");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 315, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel LabelUsuario = new JLabel("Usu\u00E1rio:");
		LabelUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		LabelUsuario.setBounds(10, 11, 94, 20);
		contentPane.add(LabelUsuario);

		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		textUsuario.setBounds(10, 42, 291, 29);
		contentPane.add(textUsuario);

		JLabel LabelSenha = new JLabel("Senha:");
		LabelSenha.setFont(new Font("Tahoma", Font.BOLD, 15));
		LabelSenha.setBounds(10, 82, 94, 20);
		contentPane.add(LabelSenha);

		textSenha = new JTextField();
		textSenha.setColumns(10);
		textSenha.setBounds(10, 113, 291, 29);
		contentPane.add(textSenha);

		JButton btnCriar = new JButton("Criar");
		btnCriar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCriar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (!StringUtils.isNullOrEmpty(textUsuario.getText())
							&& !StringUtils.isNullOrEmpty(textSenha.getText())) {
						UsuarioDAO dao = new UsuarioDAO();
						Usuario usuario = new Usuario(textUsuario.getText(),
								textSenha.getText());
						dao.salvar(usuario);
						JOptionPane.showMessageDialog(null,
								"Usuario Salvo com sucesso!");
						textUsuario.setText(null);
						textSenha.setText(null);
					} else {
						JOptionPane.showMessageDialog(null,
								"Preencha o campo 'Usuario' e 'Senha'!");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnCriar.setBounds(10, 153, 121, 46);
		contentPane.add(btnCriar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				dispose();
				TelaUsuario voltarUsuario = new TelaUsuario();
				voltarUsuario.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(180, 153, 121, 46);
		contentPane.add(btnVoltar);
	}

}
