package br.edu.unicid.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import com.mysql.jdbc.StringUtils;

import br.edu.unicid.bean.Produto;
import br.edu.unicid.dao.ProdutoDAO;

public class CadastroProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JFormattedTextField textPreco;
	private JTextField textCat;
	private JEditorPane editorDesc;
	private JRadioButton radioNao;
	private JRadioButton radioSim;
	private ButtonGroup bg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					CadastroProduto frame = new CadastroProduto();
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
	public CadastroProduto() throws ParseException {
		setResizable(false);
		setTitle("Cadastro de Produto");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 400, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel LabelNome = new JLabel("Nome:");
		LabelNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		LabelNome.setBounds(6, 9, 46, 14);
		contentPane.add(LabelNome);

		JLabel LabelPreco = new JLabel("Pre\u00E7o:");
		LabelPreco.setFont(new Font("Tahoma", Font.BOLD, 13));
		LabelPreco.setBounds(6, 34, 46, 14);
		contentPane.add(LabelPreco);

		JLabel LabelPromo = new JLabel("Promo\u00E7\u00E3o:");
		LabelPromo.setFont(new Font("Tahoma", Font.BOLD, 13));
		LabelPromo.setBounds(6, 59, 75, 14);
		contentPane.add(LabelPromo);

		JLabel LabelCat = new JLabel("Categoria:");
		LabelCat.setFont(new Font("Tahoma", Font.BOLD, 13));
		LabelCat.setBounds(6, 84, 75, 14);
		contentPane.add(LabelCat);

		JLabel LabelDesc = new JLabel("Descri\u00E7\u00E3o:");
		LabelDesc.setFont(new Font("Tahoma", Font.BOLD, 13));
		LabelDesc.setBounds(6, 109, 75, 14);
		contentPane.add(LabelDesc);

		textNome = new JTextField();
		textNome.setBounds(104, 6, 273, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		DecimalFormat decimal = new DecimalFormat("#,###,##0.00");
		NumberFormatter numFormatter = new NumberFormatter(decimal);
		numFormatter.setFormat(decimal);
		numFormatter.setAllowsInvalid(false);
		DefaultFormatterFactory dfFactory = new DefaultFormatterFactory(numFormatter);

		textPreco = new JFormattedTextField();
		textPreco.setBounds(104, 31, 86, 20);
		contentPane.add(textPreco);
		textPreco.setColumns(10);
		textPreco.setFormatterFactory(dfFactory);

		radioSim = new JRadioButton("Sim");
		radioSim.setBounds(104, 56, 55, 23);
		contentPane.add(radioSim);

		radioNao = new JRadioButton("N\u00E3o");
		radioNao.setBounds(153, 56, 62, 23);
		contentPane.add(radioNao);

		bg = new ButtonGroup();
		bg.add(radioSim);
		bg.add(radioNao);

		textCat = new JTextField();
		textCat.setBounds(104, 81, 86, 20);
		contentPane.add(textCat);
		textCat.setColumns(10);

		editorDesc = new JEditorPane();
		editorDesc.setBounds(104, 109, 273, 136);
		contentPane.add(editorDesc);

		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (!StringUtils.isNullOrEmpty(textCat.getText()) && !StringUtils.isNullOrEmpty(textNome.getText())
							&& !StringUtils.isNullOrEmpty(textPreco.getText())) {
						ProdutoDAO dao = new ProdutoDAO();
						Produto produto = new Produto();
						produto.setCategoria(textCat.getText());
						produto.setDescricao(editorDesc.getText());
						produto.setNome(textNome.getText());
						produto.setPreco(textPreco.getText());
						if (radioSim.isSelected()) {
							produto.setPromocao(true);
						} else {
							produto.setPromocao(false);
						}
						dao.salvar(produto);
						limparCampos();
						JOptionPane.showMessageDialog(null, "Produto Salvo com sucesso!");
					} else {
						JOptionPane.showMessageDialog(null, "Preencha todos os campos marcados com *!");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCriar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCriar.setBounds(91, 257, 88, 23);
		contentPane.add(btnCriar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
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
		btnVoltar.setBounds(289, 257, 88, 23);
		contentPane.add(btnVoltar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpar.setBounds(191, 257, 88, 23);
		contentPane.add(btnLimpar);
	}

	public void limparCampos() {
		textNome.setText(null);
		textPreco.setText(Double.toString(0));
		textCat.setText(null);
		editorDesc.setText(null);
		bg.clearSelection();
	}
}
