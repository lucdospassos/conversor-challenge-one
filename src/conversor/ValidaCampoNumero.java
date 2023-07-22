package conversor;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import java.util.regex.Matcher;

public class ValidaCampoNumero {

	private String input;
	private boolean validaNumero;
	private String campoValidadoComSucesso;
	private String exibiResultado;
	private String exibiResultadoA;
	private String nomeMoedaA;
	private String nomeMoedaB;

	public String getNomeMoedaA() {
		return nomeMoedaA;
	}

	public void setNomeMoedaA(String nomeMoedaA) {
		this.nomeMoedaA = nomeMoedaA;
	}

	public String getNomeMoedaB() {
		return nomeMoedaB;
	}

	public void setNomeMoedaB(String nomeMoeda) {
		this.nomeMoedaB = nomeMoeda;
	}

	public String getExibiResultadoA() {
		return exibiResultadoA;
	}

	public void setExibiResultadoA(String exibiResultadoA) {
		this.exibiResultadoA = exibiResultadoA;
	}

	public String getExibiResultado() {
		return exibiResultado;
	}

	public void setExibiResultado(String exibiResultado) {
		this.exibiResultado = exibiResultado;
	}

	public String getCampoValidadoComSucesso() {
		return campoValidadoComSucesso;
	}

	public void setCampoValidadoComSucesso(String campoValidadoComSucesso) {
		this.campoValidadoComSucesso = campoValidadoComSucesso;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public boolean isValidaNumero() {
		return validaNumero;
	}

	public void setValidaNumero(boolean validaNumero) {
		this.validaNumero = validaNumero;
	}

	public static boolean validateInput(String validaNumero) {
		String pattern = "^[0-9.,]+$";
		Pattern regex = Pattern.compile(pattern);
		Matcher matcher = regex.matcher(validaNumero);
		return matcher.matches();
	}

	public void validaCampoNumerico(String campoAConverter, String moedaDeConversao, double valorParaConverter) {

		setCampoValidadoComSucesso("false");
		CalculaValorMoeda testaConexao = new CalculaValorMoeda(moedaDeConversao, valorParaConverter);

		if (testaConexao != null && testaConexao.getNomeMoedaB() != null) {

			String textoValorAConverterNumeroEPonto;

			if ((!campoAConverter.equals(".") && !campoAConverter.equals(","))
					&& (campoAConverter.matches("[0-9.,]+"))) {

				String texto = campoAConverter;
				String textoConvertido = texto.replace(",", ".");
				textoConvertido = textoConvertido.replaceAll("[^\\d.]", "");
				campoAConverter = textoConvertido;
				textoValorAConverterNumeroEPonto = campoAConverter;

				ContaCaracteres numerosDePontoEVirgulas = new ContaCaracteres(campoAConverter);

				int quantidadeVirgula = numerosDePontoEVirgulas.getQuantidadeDeVirgula();
				int quantidadePonto = numerosDePontoEVirgulas.getQuantidadeDePonto();
				int somaPontoVirgula = quantidadeVirgula + quantidadePonto;

				if (!textoValorAConverterNumeroEPonto.isEmpty() && (somaPontoVirgula == 1 || somaPontoVirgula == 0)) {

					String textoa = moedaDeConversao.toString();
					if (textoa.equals("Escolha a Moeda:")) {
						JOptionPane.showMessageDialog(null, "Escolha uma Moeda para converter", "Atenção",
								JOptionPane.WARNING_MESSAGE);
					} else {

						double valorAConverter = Double.parseDouble(campoAConverter);
						CalculaValorMoeda contacaoAtual = new CalculaValorMoeda(moedaDeConversao, valorAConverter);
						setExibiResultado(contacaoAtual.getExibiResultado());
						campoAConverter.equals(contacaoAtual.getExibiResultadoInvertido());

						setExibiResultadoA(contacaoAtual.getExibiResultadoInvertido());
						setNomeMoedaA(contacaoAtual.getNomeMoedaA());
						setNomeMoedaB(contacaoAtual.getNomeMoedaB());

						setCampoValidadoComSucesso("true");
					}

				} else {
					JOptionPane.showMessageDialog(null,
							"Digite um valor válido. Ex.: 1,90 | 150,00 | 1450,78 | 10567,90", "Atenção",
							JOptionPane.WARNING_MESSAGE);
				}

			} else {

				if (campoAConverter.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Digite um valor. Ex.: 1,90 | 150,00 | 1450,78 | 10567,90",
							"Atenção", JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,
							"Digite um valor válido. Ex.: 1,90 | 150,00 | 1450,78 | 10567,90", "Atenção",
							JOptionPane.WARNING_MESSAGE);
				}

				textoValorAConverterNumeroEPonto = "";
			}

		} else {

			if (moedaDeConversao.equals("Escolha a Moeda:")) {
				JOptionPane.showMessageDialog(null, "Escolha uma Moeda para converter", "Atenção",
						JOptionPane.WARNING_MESSAGE);
			} else {

				JOptionPane.showMessageDialog(null, "Falha na conexão!\nVerifique sua conexão com a internet.", "Falha",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
