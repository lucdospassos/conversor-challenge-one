package conversor;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.*;
import java.awt.datatransfer.*;
import javax.swing.ImageIcon;
import java.awt.event.WindowFocusListener;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.WindowEvent;
import javax.swing.JTextPane;
import java.awt.Cursor;
import java.io.IOException;

public class Conversor extends MainFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4479718487614818421L;
	private JPanel contentPane;
	private JTextField textFieldValorAConverter;
	private JTextField textFieldValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor frame = new Conversor();
					frame.setLocationRelativeTo(null);
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
	public Conversor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Conversor.class.getResource("/img/imgIcon.png")));
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				textFieldValorAConverter.requestFocus();
			}

			public void windowLostFocus(WindowEvent e) {

			}
		});

		setBackground(new Color(240, 240, 240));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 494);
		contentPane = new MeuFramePrincipal();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setUI(new CustomTabbedPaneUI(Color.cyan, Color.WHITE, Color.white, Color.BLACK));
		tabbedPane.setBounds(5, 5, 778, 439);
		contentPane.add(tabbedPane);

		Font tabFont = new Font("Arial", Font.BOLD, 13);
		tabbedPane.setFont(tabFont);

		MeuPanel panelConversorMoeda = new MeuPanel();
		tabbedPane.addTab("Conversor de Moedas", null, panelConversorMoeda, null);
		panelConversorMoeda.setLayout(null);

		JLabel labelValorCotacaoAtual = new JLabel("");
		labelValorCotacaoAtual.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		labelValorCotacaoAtual.setHorizontalAlignment(SwingConstants.CENTER);
		labelValorCotacaoAtual.setBounds(207, 79, 201, 25);
		panelConversorMoeda.add(labelValorCotacaoAtual);

		JLabel labelDigiteOValor = new JLabel("Digite o valor. Ex.: 1,90 | 150,00 | 1450,78 | 10950,90");
		labelDigiteOValor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelDigiteOValor.setBounds(85, 182, 321, 17);
		panelConversorMoeda.add(labelDigiteOValor);

		JLabel labelResultado = new JLabel("");
		labelResultado.addFocusListener(new FocusAdapter() {

		});
		labelResultado.setFont(new Font("Tahoma", Font.BOLD, 42));
		labelResultado.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultado.setBackground(new Color(237, 253, 208));
		labelResultado.setOpaque(true);
		labelResultado.setBounds(15, 317, 391, 85);
		panelConversorMoeda.add(labelResultado);

		JLabel labelCotacaoAtual = new JLabel("");
		labelCotacaoAtual.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		labelCotacaoAtual.setHorizontalAlignment(SwingConstants.CENTER);
		labelCotacaoAtual.setBounds(207, 52, 201, 25);
		panelConversorMoeda.add(labelCotacaoAtual);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Malgun Gothic", Font.BOLD, 22));
		lblNewLabel_3.setBounds(15, 275, 391, 40);
		panelConversorMoeda.add(lblNewLabel_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(424, 170, 339, 190);
		panelConversorMoeda.add(scrollPane);

		JTextPane listaDeResultado = new JTextPane();
		scrollPane.setViewportView(listaDeResultado);
		listaDeResultado.setBackground(new Color(253, 254, 205));
		listaDeResultado.setForeground(new Color(0, 0, 255));
		listaDeResultado.setFont(new Font("Tahoma", Font.BOLD, 13));
		listaDeResultado.setEditable(false);

		JLabel labelIconConversorMoedas = new JLabel("");
		labelIconConversorMoedas.setBounds(250, 46, 83, 74);
		panelConversorMoeda.add(labelIconConversorMoedas);
		ImageIcon icon = new ImageIcon(Conversor.class.getResource("/img/iconConversorMoedas.png"));
		Image image = icon.getImage().getScaledInstance(labelIconConversorMoedas.getWidth(),
				labelIconConversorMoedas.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(image);
		labelIconConversorMoedas.setIcon(scaledIcon);

		JComboBox<String> comboBoxMoedaDeConversao = new JComboBox<String>();
		comboBoxMoedaDeConversao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String moeda = (String) comboBoxMoedaDeConversao.getSelectedItem();
				CalculaValorMoeda contacaoAtual = new CalculaValorMoeda(moeda, 0);

				if (contacaoAtual != null && contacaoAtual.getNomeMoedaB() != null) {
					if (comboBoxMoedaDeConversao.getSelectedIndex() == 0) {
						labelCotacaoAtual.setText("");
						labelValorCotacaoAtual.setText("");
						labelIconConversorMoedas.setVisible(true);
					} else {
						labelCotacaoAtual.setText("1 " + contacaoAtual.getNomeMoedaB() + " é \n igual a: ");
						labelValorCotacaoAtual
								.setText(contacaoAtual.getResultado() + " " + contacaoAtual.getNomeMoedaA());
						labelIconConversorMoedas.setVisible(false);
						textFieldValorAConverter.requestFocus();
					}
				} else {
					if (comboBoxMoedaDeConversao.getSelectedIndex() != 0) {
						JOptionPane.showMessageDialog(null, "Falha na conexão!\nVerifique sua conexão com a internet.",
								"Falha", JOptionPane.ERROR_MESSAGE);
					}
					labelCotacaoAtual.setText("");
					labelValorCotacaoAtual.setText("");
					labelIconConversorMoedas.setVisible(true);
					comboBoxMoedaDeConversao.setSelectedIndex(0);
				}

			}
		});
		comboBoxMoedaDeConversao.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Escolha a Moeda:", "Dólar USD/Real BRL", "Euro/Real BRL", "Libra Esterlina/Real BRL",
						"Peso Argentino/Real BRL", "Peso Chileno/Real BRL", "Real BRL/Dólar USD", "Real BRL/Euro",
						"Real BRL/Libra Esterlina", "Real BRL/Peso Argentino", "Real BRL/Peso Chileno" }));
		comboBoxMoedaDeConversao.setToolTipText("Escolha a Moeda:");
		comboBoxMoedaDeConversao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxMoedaDeConversao.setBounds(13, 52, 187, 55);
		panelConversorMoeda.add(comboBoxMoedaDeConversao);

		JButton buttonConverter = new JButton("Converter");
		buttonConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String campoAConverter = textFieldValorAConverter.getText();
				String moedaDeConversao = (String) comboBoxMoedaDeConversao.getSelectedItem();
				double valorParaConverter = 0;

				ValidaCampoNumero validaTextFieldValorAConverter = new ValidaCampoNumero();
				validaTextFieldValorAConverter.validaCampoNumerico(campoAConverter, moedaDeConversao,
						valorParaConverter);

				if (validaTextFieldValorAConverter.getCampoValidadoComSucesso().equals("true")) {

					labelResultado.setText(validaTextFieldValorAConverter.getExibiResultado());

					lblNewLabel_3.setText(validaTextFieldValorAConverter.getExibiResultadoA() + " "
							+ validaTextFieldValorAConverter.getNomeMoedaB() + " é igual a: ");

					listaDeResultado.setText(listaDeResultado.getText() + lblNewLabel_3.getText() + " "
							+ labelResultado.getText() + " " + validaTextFieldValorAConverter.getNomeMoedaA() + "\n"
							+ "--------------------------------------------------" + "\n");

					labelIconConversorMoedas.setVisible(false);
				}
			}
		});
		buttonConverter.setForeground(new Color(255, 0, 0));
		buttonConverter.setFont(new Font("Malgun Gothic", Font.BOLD, 36));
		buttonConverter.setBounds(15, 210, 391, 58);
		panelConversorMoeda.add(buttonConverter);

		textFieldValorAConverter = new JTextField();
		textFieldValorAConverter.setToolTipText("Digite um valor para converter");
		textFieldValorAConverter.setForeground(new Color(0, 0, 255));
		textFieldValorAConverter.setBounds(85, 120, 321, 58);
		textFieldValorAConverter.setFont(new Font("Times New Roman", Font.BOLD, 32));
		panelConversorMoeda.add(textFieldValorAConverter);
		textFieldValorAConverter.setColumns(10);

		JLabel lblNewLabel = new JLabel("Valor:");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 24));
		lblNewLabel.setBounds(15, 125, 95, 40);
		panelConversorMoeda.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Conversor de Moedas");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("Malgun Gothic", Font.BOLD, 28));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(15, 4, 391, 37);
		panelConversorMoeda.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Conversor.class.getResource("/img/imgConversorMoeda.png")));
		lblNewLabel_2.setBounds(424, 8, 339, 110);
		panelConversorMoeda.add(lblNewLabel_2);
		ImageIcon iconLabel_2 = new ImageIcon(Conversor.class.getResource("/img/imgConversorMoeda.png"));
		Image imageLabel_2 = iconLabel_2.getImage().getScaledInstance(lblNewLabel_2.getWidth(),
				lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIconLabel_2 = new ImageIcon(imageLabel_2);
		lblNewLabel_2.setIcon(scaledIconLabel_2);

		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (listaDeResultado.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Não existe dados para apagar!", "Atenção",
							JOptionPane.WARNING_MESSAGE);
				} else {

					int resposta = JOptionPane.showOptionDialog(null, "Você deseja apagar todo o histórico?",
							"Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
							new Object[] { "Sim", "Não" }, "Não");

					if (resposta == JOptionPane.YES_OPTION) {
						listaDeResultado.setText("");
					}
				}

			}
		});
		btnNewButton.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		btnNewButton.setBounds(598, 370, 165, 29);
		panelConversorMoeda.add(btnNewButton);

		JButton botaoCopiar = new JButton("Copiar");
		botaoCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (listaDeResultado.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Não existe dados para copiar!", "Atenção",
							JOptionPane.WARNING_MESSAGE);
				} else {

					StringSelection stringSelection = new StringSelection(listaDeResultado.getText());
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					clipboard.setContents(stringSelection, null);
					JOptionPane.showMessageDialog(null, "Copiado para a área de transferência.");
				}
			}
		});
		botaoCopiar.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		botaoCopiar.setBounds(424, 370, 165, 29);
		panelConversorMoeda.add(botaoCopiar);

		JLabel lblNewLabel_4 = new JLabel("Histórico de Conversão");
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Malgun Gothic", Font.BOLD, 24));
		lblNewLabel_4.setBounds(424, 127, 339, 40);
		panelConversorMoeda.add(lblNewLabel_4);

		MeuPanel panelConversorMedidas = new MeuPanel();
		tabbedPane.addTab("Conversor de Medidas", null, panelConversorMedidas, null);
		panelConversorMedidas.setLayout(null);

		JLabel lblMedida = new JLabel("Medida");
		lblMedida.setForeground(Color.BLACK);
		lblMedida.setFont(new Font("Malgun Gothic", Font.BOLD, 24));
		lblMedida.setBounds(20, 59, 95, 40);
		panelConversorMedidas.add(lblMedida);

		textFieldValor = new JTextField();
		textFieldValor.setToolTipText("Digite um valor para converter");
		textFieldValor.setForeground(Color.BLUE);
		textFieldValor.setFont(new Font("Times New Roman", Font.BOLD, 32));
		textFieldValor.setColumns(10);
		textFieldValor.setBounds(20, 100, 202, 55);
		panelConversorMedidas.add(textFieldValor);

		JLabel lblNewLabel_1_1 = new JLabel("Conversor Unidades de Medida");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(20, 11, 743, 55);
		panelConversorMedidas.add(lblNewLabel_1_1);

		JComboBox<String> comboBoxDe = new JComboBox<String>();
		comboBoxDe.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Milímetro", "Centímetro", "Metro", "Km", "Polegada", "Pés" }));
		comboBoxDe.setToolTipText("Escolha a Unidade de Entrada");
		comboBoxDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxDe.setBounds(232, 100, 155, 55);
		panelConversorMedidas.add(comboBoxDe);

		JComboBox<String> comboBoxPara = new JComboBox<String>();
		comboBoxPara.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Centímetro", "Milímetro", "Metro", "Km", "Polegada", "Pés" }));
		comboBoxPara.setToolTipText("Escolha a Unidade de Saída");
		comboBoxPara.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxPara.setBounds(461, 100, 155, 55);
		panelConversorMedidas.add(comboBoxPara);

		JLabel labelResultado_1 = new JLabel("Resultado");
		labelResultado_1.setOpaque(true);
		labelResultado_1.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultado_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		labelResultado_1.setBackground(new Color(237, 253, 208));
		labelResultado_1.setBounds(20, 166, 743, 124);
		panelConversorMedidas.add(labelResultado_1);

		JLabel lblPara = new JLabel("Para");
		lblPara.setHorizontalAlignment(SwingConstants.CENTER);
		lblPara.setForeground(Color.BLACK);
		lblPara.setFont(new Font("Malgun Gothic", Font.BOLD, 24));
		lblPara.setBounds(388, 106, 67, 40);
		panelConversorMedidas.add(lblPara);

		JButton buttonConverterMedidas = new JButton("Converter");
		buttonConverterMedidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if ((!textFieldValor.getText().equals(".") && !textFieldValor.getText().equals(","))
						&& (textFieldValor.getText().matches("[0-9.,]+"))) {

					String textoPOA = textFieldValor.getText();
					String textoConvertidoPOA = textoPOA.replace(",", ".");
					textoConvertidoPOA = textoConvertidoPOA.replaceAll("[^\\d.]", "");
					textFieldValor.setText(textoConvertidoPOA);

					ContaCaracteres numerosDePontoEVirgulaA = new ContaCaracteres(textFieldValor.getText());

					int quantidadeVirgulaA = numerosDePontoEVirgulaA.getQuantidadeDeVirgula();
					int quantidadePontoA = numerosDePontoEVirgulaA.getQuantidadeDePonto();
					int somaPontoVirgulaA = quantidadeVirgulaA + quantidadePontoA;

					if (!textFieldValor.getText().isEmpty() && (somaPontoVirgulaA == 1 || somaPontoVirgulaA == 0)) {

						if (comboBoxDe.getSelectedItem().equals(comboBoxPara.getSelectedItem())) {
							JOptionPane.showMessageDialog(null, "Por favor, escolha diferentes unidades de medida",
									"Atenção", JOptionPane.WARNING_MESSAGE);
						} else if (textFieldValor.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Digite um valor para converter", "Atenção",
									JOptionPane.WARNING_MESSAGE);
							textFieldValor.requestFocus();
						}

						else {

							CalculaMedidas.converterMedidas(comboBoxDe, comboBoxPara, textFieldValor, labelResultado_1);

						}

					}
				} else {

					if (textFieldValor.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Digite um valor. Ex.: 1 | 1,50 | 10 | 100| 250", "Atenção",
								JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Digite um valor válido. Ex.: 1 | 1,50 | 10 | 100| 250",
								"Atenção", JOptionPane.WARNING_MESSAGE);
					}

					textFieldValor.requestFocus();
					textFieldValor.selectAll();

				}

			}
		});
		buttonConverterMedidas.setForeground(Color.RED);
		buttonConverterMedidas.setFont(new Font("Malgun Gothic", Font.BOLD, 22));
		buttonConverterMedidas.setBounds(626, 100, 137, 55);
		panelConversorMedidas.add(buttonConverterMedidas);

		JLabel labelImgMedidas = new JLabel("");
		labelImgMedidas.setBounds(20, 301, 743, 97);
		panelConversorMedidas.add(labelImgMedidas);
		ImageIcon iconLabelImgMedidas = new ImageIcon(Conversor.class.getResource("/img/imgConversorMedidas.png"));
		Image imageLabelImgMedidas = iconLabelImgMedidas.getImage().getScaledInstance(labelImgMedidas.getWidth(),
				labelImgMedidas.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledlabelImgMedidas = new ImageIcon(imageLabelImgMedidas);
		labelImgMedidas.setIcon(scaledlabelImgMedidas);

		MeuPanel panelSobre = new MeuPanel();
		tabbedPane.addTab("Sobre", null, panelSobre, null);
		panelSobre.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Programa Conversor de Moedas e Medidas");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_5.setBounds(25, 44, 393, 25);
		panelSobre.add(lblNewLabel_5);

		JLabel lblNewLabel_5_1 = new JLabel("Versão: 1.0");
		lblNewLabel_5_1.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		lblNewLabel_5_1.setBounds(25, 75, 144, 25);
		panelSobre.add(lblNewLabel_5_1);

		JLabel lblNewLabel_5_1_1 = new JLabel("Autor: Luciano Passos");
		lblNewLabel_5_1_1.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		lblNewLabel_5_1_1.setBounds(25, 105, 198, 25);
		panelSobre.add(lblNewLabel_5_1_1);

		JLabel lblNewLabelEmail = new JLabel("E-mail: lucdospassos@hotmail.com");
		lblNewLabelEmail.setForeground(new Color(0, 0, 255));
		lblNewLabelEmail.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		lblNewLabelEmail.setBounds(25, 134, 297, 25);

		Font emojiFont = new Font("Segoe UI Emoji", Font.PLAIN, 16);
		lblNewLabelEmail.setFont(emojiFont);

		lblNewLabelEmail.setText("✉️ " + lblNewLabelEmail.getText());

		lblNewLabelEmail.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabelEmail.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				try {
					Desktop.getDesktop().browse(new URI("mailto:lucdospassos@hotmail.com"));
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
			}
		});
		panelSobre.add(lblNewLabelEmail);

		String linkURL = "https://github.com/lucdospassos";
		JLabel labelLinkGitHub = new JLabel("");
		labelLinkGitHub.setToolTipText("https://github.com/lucdospassos");
		labelLinkGitHub.setIcon(new ImageIcon(Conversor.class.getResource("/img/imgGitHub.png")));
		labelLinkGitHub.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		labelLinkGitHub.setBounds(25, 170, 77, 77);

		ImageIcon iconlabelLinkGitHub = new ImageIcon(Conversor.class.getResource("/img/imgGitHub.png"));
		Image imagelabelLinkGitHub = iconlabelLinkGitHub.getImage().getScaledInstance(-1, labelLinkGitHub.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon scaledlabelLinkGitHub = new ImageIcon(imagelabelLinkGitHub);
		labelLinkGitHub.setIcon(scaledlabelLinkGitHub);

		labelLinkGitHub.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		labelLinkGitHub.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				try {
					java.awt.Desktop.getDesktop().browse(new java.net.URI(linkURL));
				} catch (java.net.URISyntaxException | java.io.IOException e) {
					e.printStackTrace();
				}
			}
		});
		panelSobre.add(labelLinkGitHub);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Conversor.class.getResource("/img/imgSobre.png")));
		lblNewLabel_6.setBounds(422, 11, 341, 387);
		panelSobre.add(lblNewLabel_6);

		ImageIcon iconlblNewLabel_6 = new ImageIcon(Conversor.class.getResource("/img/imgSobre.png"));
		Image imagelblNewLabel_6 = iconlblNewLabel_6.getImage().getScaledInstance(-1, lblNewLabel_6.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon scaledlblNewLabel_6 = new ImageIcon(imagelblNewLabel_6);
		lblNewLabel_6.setIcon(scaledlblNewLabel_6);

		JLabel labelOpenSource = new JLabel("");
		labelOpenSource.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		labelOpenSource.setBounds(125, 344, 181, 54);
		panelSobre.add(labelOpenSource);

		ImageIcon iconlabelOpenSource = new ImageIcon(Conversor.class.getResource("/img/imgOpenSource.png"));
		Image imagelabelOpenSource = iconlabelOpenSource.getImage().getScaledInstance(-1, labelOpenSource.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon scaledlabelOpenSource = new ImageIcon(imagelabelOpenSource);
		labelOpenSource.setIcon(scaledlabelOpenSource);

	}
}
