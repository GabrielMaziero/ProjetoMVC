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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.unicid.bean.FiltroProduto;
import br.edu.unicid.bean.Produto;
import br.edu.unicid.dao.ProdutoDAO;

public class EditarProduto extends JFrame {

	private JPanel LabelCat;
	private JTextField textID;
	private JTextField textNome;
	private JTextField textPreco;
	private JTextField textCat;
	private JLabel LabelPromo;

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

		JRadioButton radioSim = new JRadioButton("Sim");
		radioSim.setBounds(108, 86, 57, 23);
		LabelCat.add(radioSim);

		textCat = new JTextField();
		textCat.setColumns(10);
		textCat.setBounds(108, 111, 86, 20);
		LabelCat.add(textCat);

		JRadioButton radioNao = new JRadioButton("N\u00E3o");
		radioNao.setBounds(156, 86, 57, 23);
		LabelCat.add(radioNao);

		ButtonGroup bg = new ButtonGroup();
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

		JEditorPane editorDesc = new JEditorPane();
		editorDesc.setBounds(108, 139, 282, 136);
		LabelCat.add(editorDesc);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setBounds(10, 286, 88, 23);
		LabelCat.add(btnSalvar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				textID.setText(null);
				textNome.setText(null);
				textPreco.setText(null);
				textCat.setText(null);
				editorDesc.setText(null);

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
				TelaPrincipal voltarPrincipal = new TelaPrincipal();
				voltarPrincipal.setVisible(true);
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
					Produto produto = new Produto();
					FiltroProduto filtro = new FiltroProduto();
					filtro.setId(Integer.parseInt(textID.getText()));
					produto = dao.procurarProdutoById(filtro);
					textCat.setText(produto.getCategoria());
					textNome.setText(produto.getNome());
					textPreco.setText(produto.getPreco());
					if (produto.isPromocao()) {
						radioSim.setSelected(true);
						radioNao.setSelected(false);
					} else {
						radioSim.setSelected(false);
						radioNao.setSelected(true);
					}
					editorDesc.setText(produto.getDescricao());

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnBuscar.setBounds(204, 10, 86, 23);
		LabelCat.add(btnBuscar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExcluir.setBounds(108, 286, 88, 23);
		LabelCat.add(btnExcluir);
	}
}
