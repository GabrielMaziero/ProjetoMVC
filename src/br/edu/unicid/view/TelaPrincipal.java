package br.edu.unicid.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.unicid.bean.FiltroProduto;
import br.edu.unicid.bean.Produto;
import br.edu.unicid.dao.ProdutoDAO;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private static JComboBox comboCat;
	private JCheckBox chckbxAtReais;
	private JLabel lblCategorias;
	private JLabel lblPreco;
	private JRadioButton radioSim;
	private JRadioButton radioNao;
	private JTextField textNome;
	private JLabel lblPromo;
	private JLabel lblNome;
	private JTextArea textDesc;
	private JButton btnBuscar;
	private JButton btnLimpar;
	private JButton btnVoltar;
	private JLabel lblDescrio;
	private ButtonGroup bg;
	private static List<String> listaCategorias = new ArrayList<>();
	private JScrollPane scroll;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 *
	 * @throws Exception
	 */
	public TelaPrincipal() throws Exception {
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
		comboCat.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
			}
		});
		comboCat.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				ProdutoDAO dao;
				try {
					dao = new ProdutoDAO();
					listaCategorias = dao.listarCategorias();
					comboCat.addItem("..::Todas::..");
					for (String categoria : listaCategorias) {
						comboCat.addItem(categoria);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		comboCat.setBounds(62, 134, 138, 20);
		contentPane.add(comboCat);

		chckbxAtReais = new JCheckBox("200");
		chckbxAtReais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxAtReais.setBounds(253, 133, 129, 23);
		contentPane.add(chckbxAtReais);

		lblCategorias = new JLabel("Categorias");
		lblCategorias.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCategorias.setBounds(72, 106, 80, 16);
		contentPane.add(lblCategorias);

		lblPreco = new JLabel("Preços até R$:");
		lblPreco.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPreco.setBounds(263, 106, 138, 16);
		contentPane.add(lblPreco);

		radioSim = new JRadioButton("Sim");
		radioSim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		radioSim.setBounds(62, 186, 52, 23);
		contentPane.add(radioSim);

		radioNao = new JRadioButton("N\u00E3o");
		radioNao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		radioNao.setBounds(109, 186, 63, 23);
		contentPane.add(radioNao);

		bg = new ButtonGroup();
		bg.add(radioSim);
		bg.add(radioNao);

		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(109, 219, 273, 20);
		contentPane.add(textNome);

		lblPromo = new JLabel("Apenas Promoção");
		lblPromo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPromo.setBounds(62, 164, 160, 16);
		contentPane.add(lblPromo);

		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(62, 221, 44, 16);
		contentPane.add(lblNome);

		textDesc = new JTextArea();
		textDesc.setLineWrap(true);
		textDesc.setEditable(false);
		textDesc.setBounds(114, 252, 268, 186);
		contentPane.add(textDesc);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ProdutoDAO dao = new ProdutoDAO();
					FiltroProduto filtro = new FiltroProduto();

					filtro.setCategoria((String) comboCat.getSelectedItem());
					filtro.setNome(textNome.getText());
					if (radioSim.isSelected()) {
						filtro.setApenasPromocao(true);
					} else {
						filtro.setApenasPromocao(false);
					}
					if (chckbxAtReais.isSelected()) {
						filtro.setPreco(Double.parseDouble(chckbxAtReais.getText()));
					}
					List<Produto> listaDeProdutos = dao.procurarProdutoByFiltro(filtro);
					textDesc.setText(listaDeProdutos.toString());

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.setBounds(23, 450, 117, 29);
		contentPane.add(btnBuscar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				limparCampos();
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

		scroll = new JScrollPane(textDesc);
		scroll.setBounds(111, 251, 271, 186);
		getContentPane().add(scroll);
		contentPane.add(scroll);

	}

	public void limparCampos() {
		textNome.setText(null);
		comboCat.setSelectedIndex(1);
		chckbxAtReais.setSelected(false);
		textDesc.setText(null);
		bg.clearSelection();
	}
}
