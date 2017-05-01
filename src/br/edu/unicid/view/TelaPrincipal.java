package br.edu.unicid.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JComboBox comboCat;
	private JCheckBox checkBox;
	private JCheckBox checkBox_1;
	private JCheckBox checkBox_2;
	private JLabel lblCategorias;
	private JLabel lblPreco;
	private JRadioButton radioSim;
	private JRadioButton radioNao;
	private JTextField textNome;
	private JLabel lblPromo;
	private JLabel lblNome;
	private JTextPane textDesc;
	private JButton btnBuscar;
	private JButton btnLimpar;
	private JButton btnVoltar;
	private JLabel lblDescrio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();

					// TODO Chamar consulta de categorias

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
	public TelaPrincipal() {
		setTitle("Produtos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 444, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					dispose();
					CadastroProduto CadastroProduto = new CadastroProduto();
					CadastroProduto.setVisible(true);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCadastrar.setBounds(62, 48, 129, 46);
		contentPane.add(btnCadastrar);

		JButton btnEditar = new JButton("Editar/Excluir");
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				EditarProduto EditarProduto = new EditarProduto();
				EditarProduto.setVisible(true);
			}

		});
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditar.setBounds(253, 48, 129, 46);
		contentPane.add(btnEditar);

		JLabel lblGenenciamentoDeProduto = new JLabel("Genenciamento de Produto");
		lblGenenciamentoDeProduto.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGenenciamentoDeProduto.setBounds(109, 10, 225, 32);
		contentPane.add(lblGenenciamentoDeProduto);

		comboCat = new JComboBox();
		comboCat.setBounds(62, 134, 138, 20);
		contentPane.add(comboCat);

		checkBox = new JCheckBox("0 - 100");
		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkBox.setBounds(253, 134, 80, 23);
		contentPane.add(checkBox);

		checkBox_1 = new JCheckBox("101 - 200");
		checkBox_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkBox_1.setBounds(253, 160, 95, 23);
		contentPane.add(checkBox_1);

		checkBox_2 = new JCheckBox("Maior que 200");
		checkBox_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkBox_2.setBounds(253, 186, 129, 23);
		contentPane.add(checkBox_2);

		lblCategorias = new JLabel("Categorias");
		lblCategorias.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCategorias.setBounds(72, 106, 80, 16);
		contentPane.add(lblCategorias);

		lblPreco = new JLabel("Pre\u00E7os");
		lblPreco.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPreco.setBounds(263, 106, 61, 16);
		contentPane.add(lblPreco);

		radioSim = new JRadioButton("Sim");
		radioSim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		radioSim.setBounds(62, 186, 52, 23);
		contentPane.add(radioSim);

		radioNao = new JRadioButton("N\u00E3o");
		radioNao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		radioNao.setBounds(109, 186, 63, 23);
		contentPane.add(radioNao);

		ButtonGroup bg = new ButtonGroup();
		bg.add(radioSim);
		bg.add(radioNao);

		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(109, 219, 273, 20);
		contentPane.add(textNome);

		lblPromo = new JLabel("Promo\u00E7\u00E3o");
		lblPromo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPromo.setBounds(62, 164, 83, 16);
		contentPane.add(lblPromo);

		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(62, 221, 44, 16);
		contentPane.add(lblNome);

		textDesc = new JTextPane();
		textDesc.setEditable(false);
		textDesc.setBounds(114, 252, 268, 186);
		contentPane.add(textDesc);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.setBounds(23, 450, 117, 29);
		contentPane.add(btnBuscar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textNome.setText(null);
				textDesc.setText(null);
				checkBox.setSelected(false);
				checkBox_1.setSelected(false);
				checkBox_2.setSelected(false);
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpar.setBounds(163, 450, 117, 29);
		contentPane.add(btnLimpar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaUsuario voltarUsuario = new TelaUsuario();
				voltarUsuario.setVisible(true);
			}
		});
		btnVoltar.setBounds(303, 450, 117, 29);
		contentPane.add(btnVoltar);

		lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescrio.setBounds(31, 250, 75, 14);
		contentPane.add(lblDescrio);
	}
}
