package br.edu.unicid.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class ExcluirProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcluirProduto frame = new ExcluirProduto();
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
	public ExcluirProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelID = new JLabel("ID:");
		LabelID.setFont(new Font("Tahoma", Font.BOLD, 14));
		LabelID.setBounds(43, 31, 25, 14);
		contentPane.add(LabelID);
		
		textID = new JTextField();
		textID.setColumns(10);
		textID.setBounds(108, 30, 86, 20);
		contentPane.add(textID);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.setBounds(260, 15, 108, 46);
		contentPane.add(btnBuscar);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(108, 99, 260, 20);
		contentPane.add(textNome);
		
		JLabel LabelNome = new JLabel("Nome:");
		LabelNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		LabelNome.setBounds(22, 100, 46, 14);
		contentPane.add(LabelNome);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExcluir.setBounds(75, 152, 108, 52);
		contentPane.add(btnExcluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(213, 152, 108, 52);
		contentPane.add(btnVoltar);
	}

}
