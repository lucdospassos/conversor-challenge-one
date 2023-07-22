package conversor;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class MascaraMoeda {

	private double valor;
	private String valorComMascara;
	private String retornoMascaraDinheiro;

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getMascaraDinheiro() {
		return valorComMascara;
	}

	public void setMascaraDinheiro(String mascaraDinheiro) {
		this.valorComMascara = mascaraDinheiro;
	}

	public void formatarValorDinheiro(String pais, String simboloMoeda) {
		NumberFormat formatoMoeda = DecimalFormat.getCurrencyInstance(new Locale(pais, simboloMoeda));
		valorComMascara = formatoMoeda.format(valor);
	}
	
	public void mascaraDinheiro(double valor, String pais, String simboloMoeda, String moeda, int digito) {

		Locale locale = new Locale(pais, simboloMoeda);
		Currency currency = Currency.getInstance(moeda);
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		currencyFormatter.setCurrency(currency);
		currencyFormatter.setMaximumFractionDigits(digito);
		String valorFormatado = currencyFormatter.format(valor);
		setRetornoMascaraDinheiro(valorFormatado);		
	}

	public String getRetornoMascaraDinheiro() {
		return retornoMascaraDinheiro;
	}

	public void setRetornoMascaraDinheiro(String retornoMascaraDinheiro) {
		this.retornoMascaraDinheiro = retornoMascaraDinheiro;
	}

}
