package br.edu.unicid.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.unicid.bean.FiltroProduto;
import br.edu.unicid.bean.Produto;
import br.edu.unicid.dao.ProdutoDAO;

public class EditarProduto extends JFrame {

	private JPanel LabelCat;
	private JEditorPane editorDesc;
	private JTextField textID;
	private JTextField textNome;
	private JTextField textPreco;
	private JTextField textCat;
	private JLabel LabelPromo;
	private Produto produto;
	private JRadioButton radioSim;
	private JRadioButton radioNao;
	private ButtonGroup bg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					EditarProduto frame = new EditarProduto();
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
	public EditarProduto() {
		setResizable(false);
		setTitle("Editar Produto");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 406, 360);
		LabelCat = new JPanel();
		LabelCat.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(LabelCat);
		LabelCat.setLayout(null);

		JLabel LabelID = new JLabel("ID:");
		LabelID.setFont(new Font("Tahoma", Font.BOLD, 13));
		LabelID.setBounds(10, 14, 46, 14);
		LabelCat.add(LabelID);

		textID = new JTextField();
		textID.setColumns(10);
		textID.setBounds(108, 11, 86, 20);
		LabelCat.add(textID);

		JLabel LabelNome = new JLabel("Nome:");
		LabelNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		LabelNome.setBounds(10, 39, 46, 14);
		LabelCat.add(LabelNome);

		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(108, 36, 282, 20);
		LabelCat.add(textNome);

		JLabel LabelPreco = new JLabel("Pre\u00E7o:");
		LabelPreco.setFont(new Font("Tahoma", Font.BOLD, 13));
		LabelPreco.setBounds(10, 64, 46, 14);
		LabelCat.add(LabelPreco);

		textPreco = new JTextField();
		textPreco.setColumns(10);
		textPreco.setBounds(108, 61, 86, 20);
		LabelCat.add(textPreco);

		LabelPromo = new JLabel("Promo\u00E7\u00E3o:");
		LabelPromo.setFont(new Font("Tahoma", Font.BOLD, 13));
		LabelPromo.setBounds(10, 89, 75, 14);
		LabelCat.add(LabelPromo);

		radioSim = new JRadioButton("Sim");
		radioSim.setBounds(108, 86, 57, 23);
		LabelCat.add(radioSim);

		textCat = new JTextField();
		textCat.setColumns(10);
		textCat.setBounds(108, 111, 86, 20);
		LabelCat.add(textCat);

		radioNao = new JRadioButton("N\u00E3o");
		radioNao.setBounds(156, 86, 57, 23);
		LabelCat.add(radioNao);

		bg = new ButtonGroup();
		bg.add(radioSim);
		bg.add(radioNao);

		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCategoria.setBounds(10, 114, 75, 14);
		LabelCat.add(lblCategoria);

		JLabel LabelDesc = new JLabel("Descri\u00E7\u00E3o:");
		LabelDesc.setFont(new Font("Tahoma", Font.BOLD, 13));
		LabelDesc.setBounds(10, 139, 75, 14);
		LabelCat.add(LabelDesc);

		editorDesc = new JEditorPane();
		editorDesc.setBounds(108, 139, 282, 136);
		LabelCat.add(editorDesc);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (produto.getId() == Integer.parseInt(textID.getText())) {
					try {
						ProdutoDAO dao = new ProdutoDAO();
						if (produto != null) {

							produto.setCategoria(textCat.getText());
							produto.setNome(textNome.getText());
							produto.setPreco(textPreco.getText());
							produto.setDescricao(editorDesc.getText());
							produto.setId(Integer.parseInt(textID.getText()));
							if (radioSim.isSelected()) {
								produto.setPromocao(true);
							} else {
								produto.setPromocao(false);
							}
							dao.editar(produto);
							limparCampos();
							JOptionPane.showMessageDialog(null, "Produto Atualizado");
						}
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Falha na atualização deste produto. O produto não existe");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Faça a busca do produto antes salvar o mesmo !");
				}

			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setBounds(10, 286, 88, 23);
		LabelCat.add(btnSalvar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpar.setBounds(204, 286, 88, 23);
		LabelCat.add(btnLimpar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal voltarPrincipal;
				try {
					voltarPrincipal = new TelaPrincipal();
					voltarPrincipal.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(302, 286, 88, 23);
		LabelCat.add(btnVoltar);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					ProdutoDAO dao = new ProdutoDAO();
					produto = new Produto();
					FiltroProduto filtro = new FiltroProduto();
					filtro.setId(Integer.parseInt(textID.getText()));
					produto = dao.procurarProdutoById(filtro);
					textCat.setText(produto.getCategoria());
					textNome.setText(produto.getNome());
					textPreco.setText(produto.getPreco());
					textID.setText(Integer.toString(produto.getId()));
					if (produto.isPromocao()) {
						radioSim.setSelected(true);
						radioNao.setSelected(false);
					} else {
						radioSim.setSelected(false);
						radioNao.setSelected(true);
					}
					editorDesc.setText(produto.getDescricao());

				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Produto não existe");
				}
			}
		});
		btnBuscar.setBounds(204, 10, 86, 23);
		LabelCat.add(btnBuscar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (produto.getId() == Integer.parseInt(textID.getText())) {
					try {
						ProdutoDAO dao = new ProdutoDAO();
						dao.excluir(Integer.parseInt(textID.getText()));
						limparCampos();
						JOptionPane.showMessageDialog(null, "Produto Excluido");
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(null, "Faça a busca do produto antes excluir o mesmo !");
				}
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExcluir.setBounds(108, 286, 88, 23);
		LabelCat.add(btnExcluir);

	}

	public void limparCampos() {

		textID.setText(null);
		textNome.setText(null);
		textPreco.setText(null);
		textCat.setText(null);
		editorDesc.setText(null);
		bg.clearSelection();

	}
}
