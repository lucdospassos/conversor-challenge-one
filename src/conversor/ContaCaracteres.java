package conversor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContaCaracteres {

	private int quantidadeDeVirgula;
	private int quantidadeDePonto;
	private String textoDoCampo;

	public ContaCaracteres(String textoDoCampo) {

		String virgula = textoDoCampo;
		Pattern padraoVirgula = Pattern.compile("\\,");
		Matcher resultadoVirgula = padraoVirgula.matcher(virgula);

		while (resultadoVirgula.find()) {
			quantidadeDeVirgula++;
		}

		String ponto = textoDoCampo;
		Pattern padraoPonto = Pattern.compile("\\.");
		Matcher resultadoPonto = padraoPonto.matcher(ponto);

		while (resultadoPonto.find()) {
			quantidadeDePonto++;
		}

	}

	public int getQuantidadeDeVirgula() {
		return quantidadeDeVirgula;
	}

	public void setQuantidadeDeVirgula(int quantidadeDeCaracteres) {
		this.quantidadeDeVirgula = quantidadeDeCaracteres;
	}

	public String getTextoDoCampo() {
		return textoDoCampo;
	}

	public void setTextoDoCampo(String textoDoCampo) {
		this.textoDoCampo = textoDoCampo;
	}

	public int getQuantidadeDePonto() {
		return quantidadeDePonto;
	}

	public void setQuantidadeDePonto(int quantidadeDePonto) {
		this.quantidadeDePonto = quantidadeDePonto;
	}

}
