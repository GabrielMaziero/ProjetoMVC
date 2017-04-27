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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.unicid.bean.Usuario;
import br.edu.unicid.dao.UsuarioDAO;

public class TelaUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaUsuario frame = new TelaUsuario();
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
	
	
	public TelaUsuario() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Acesso ao sistema");
		setBounds(100, 100, 315, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuario.setBounds(10, 11, 94, 20);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(10, 42, 291, 29);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel senha = new JLabel("Senha:");
		senha.setFont(new Font("Tahoma", Font.BOLD, 15));
		senha.setBounds(10, 82, 94, 20);
		contentPane.add(senha);
		
		txtSenha = new JPasswordField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(10, 113, 291, 29);
		contentPane.add(txtSenha);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.addActionListener(new ActionListener() {			
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						try {
							UsuarioDAO dao = new UsuarioDAO();
							Usuario usuario = new Usuario(txtUsuario.getText(), txtSenha.getText());
							if (dao.login(usuario)) {								
								TelaPrincipal TelaPrincipal = new TelaPrincipal();
								TelaPrincipal.setVisible(true);
								dispose();
							} else {
								JOptionPane.showMessageDialog(null, "Login invalido");
							}

						} catch (Exception e) {
							e.printStackTrace();
						}
						
						
					}
				
			
		});
		btnAcessar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAcessar.setBounds(10, 153, 121, 46);
		contentPane.add(btnAcessar);
		getRootPane().setDefaultButton(btnAcessar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				NovoUsuario telaDeCadastroDeUsuario = new NovoUsuario();
				telaDeCadastroDeUsuario.setVisible(true);
			}
		});
		btnCadastrar.setBounds(177, 153, 121, 46);
		contentPane.add(btnCadastrar);
	}
}
