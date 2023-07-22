package conversor;

import java.io.IOException;

public class CalculaValorMoeda {

	private String resultado;
	private String exibiResultado;
	private String nomeMoedaA;
	private String nomeMoedaB;
	private String exibiResultadoInvertido;

	public String getExibiResultadoInvertido() {
		return exibiResultadoInvertido;
	}

	public void setExibiResultadoInvertido(String exibiResultadoInvertido) {
		this.exibiResultadoInvertido = exibiResultadoInvertido;
	}

	public String getExibiResultado() {
		return exibiResultado;
	}

	public void setExibiResultado(String exibiResultado) {
		this.exibiResultado = exibiResultado;
	}

	CalculaValorMoeda(String moeda, double valorAConverter) {

		if (moeda.equals("Dólar USD/Real BRL")) {

			ConectaApiHttpValorMoedas converterRealDola = new ConectaApiHttpValorMoedas();
			converterRealDola.setMoeda("USD-BRL");

			double valor;
			try {
				valor = converterRealDola.conectaApiHttpValorMoedas();

				String pais = "pt";
				String simboloMoeda = "BR";
				String moedaDoPais = "BRL";
				int digito = 2;

				MascaraMoeda mascara = new MascaraMoeda();
				mascara.mascaraDinheiro(valor, pais, simboloMoeda, moedaDoPais, digito);
				setResultado(mascara.getRetornoMascaraDinheiro());

				double exibiResultado = valor * valorAConverter;
				MascaraMoeda resultadoABC = new MascaraMoeda();
				resultadoABC.mascaraDinheiro(exibiResultado, pais, simboloMoeda, moedaDoPais, digito);
				setExibiResultado(resultadoABC.getRetornoMascaraDinheiro());

				String paisInvertido = "en";
				String simboloMoedaInvertido = "US";
				String moedaDoPaisInvertido = "USD";
				int digitoInvertido = 2;

				double exibiResultadoInvertido = valorAConverter;
				MascaraMoeda resultadoInvertido = new MascaraMoeda();
				resultadoInvertido.mascaraDinheiro(exibiResultadoInvertido, paisInvertido, simboloMoedaInvertido,
						moedaDoPaisInvertido, digitoInvertido);
				setExibiResultadoInvertido(resultadoInvertido.getRetornoMascaraDinheiro());
				setNomeMoedaB("Dólar USD");
				setNomeMoedaA("Real BRL");

			} catch (IOException e1) {
			}

		} else if (moeda.equals("Euro/Real BRL")) {

			ConectaApiHttpValorMoedas converterRealDola = new ConectaApiHttpValorMoedas();
			converterRealDola.setMoeda("EUR-BRL");

			double valor;
			try {
				valor = converterRealDola.conectaApiHttpValorMoedas();

				String pais = "pt";
				String simboloMoeda = "BR";
				String moedaDoPais = "BRL";
				int digito = 2;

				MascaraMoeda mascara = new MascaraMoeda();
				mascara.mascaraDinheiro(valor, pais, simboloMoeda, moedaDoPais, digito);
				setResultado(mascara.getRetornoMascaraDinheiro());

				double exibiResultado = valor * valorAConverter;
				MascaraMoeda resultadoABC = new MascaraMoeda();
				resultadoABC.mascaraDinheiro(exibiResultado, pais, simboloMoeda, moedaDoPais, digito);
				setExibiResultado(resultadoABC.getRetornoMascaraDinheiro());

				String paisInvertido = "eu";
				String simboloMoedaInvertido = "EU";
				String moedaDoPaisInvertido = "EUR";
				int digitoInvertido = 2;

				double exibiResultadoInvertido = valorAConverter;
				MascaraMoeda resultadoInvertido = new MascaraMoeda();
				resultadoInvertido.mascaraDinheiro(exibiResultadoInvertido, paisInvertido, simboloMoedaInvertido,
						moedaDoPaisInvertido, digitoInvertido);
				setExibiResultadoInvertido(resultadoInvertido.getRetornoMascaraDinheiro());
				setNomeMoedaB("Euro");
				setNomeMoedaA("Real BRL");

			} catch (IOException e1) {
			}

		} else if (moeda.equals("Libra Esterlina/Real BRL")) {

			ConectaApiHttpValorMoedas converterRealDola = new ConectaApiHttpValorMoedas();
			converterRealDola.setMoeda("GBP-BRL");

			double valor;
			try {
				valor = converterRealDola.conectaApiHttpValorMoedas();

				String pais = "pt";
				String simboloMoeda = "BR";
				String moedaDoPais = "BRL";
				int digito = 2;

				MascaraMoeda mascara = new MascaraMoeda();
				mascara.mascaraDinheiro(valor, pais, simboloMoeda, moedaDoPais, digito);
				setResultado(mascara.getRetornoMascaraDinheiro());

				double exibiResultado = valor * valorAConverter;
				MascaraMoeda resultadoABC = new MascaraMoeda();
				resultadoABC.mascaraDinheiro(exibiResultado, pais, simboloMoeda, moedaDoPais, digito);
				setExibiResultado(resultadoABC.getRetornoMascaraDinheiro());

				String paisInvertido = "en";
				String simboloMoedaInvertido = "GB";
				String moedaDoPaisInvertido = "GBP";
				int digitoInvertido = 2;

				double exibiResultadoInvertido = valorAConverter;
				MascaraMoeda resultadoInvertido = new MascaraMoeda();
				resultadoInvertido.mascaraDinheiro(exibiResultadoInvertido, paisInvertido, simboloMoedaInvertido,
						moedaDoPaisInvertido, digitoInvertido);
				setExibiResultadoInvertido(resultadoInvertido.getRetornoMascaraDinheiro());
				setNomeMoedaB("Libra Esterlina");
				setNomeMoedaA("Real BRL");

			} catch (IOException e1) {
			}

		} else if (moeda.equals("Peso Argentino/Real BRL")) {

			ConectaApiHttpValorMoedas converterRealDola = new ConectaApiHttpValorMoedas();
			converterRealDola.setMoeda("ARS-BRL");

			double valor;
			try {
				valor = converterRealDola.conectaApiHttpValorMoedas();

				String pais = "pt";
				String simboloMoeda = "BR";
				String moedaDoPais = "BRL";
				int digito = 3;

				MascaraMoeda mascara = new MascaraMoeda();
				mascara.mascaraDinheiro(valor, pais, simboloMoeda, moedaDoPais, digito);
				setResultado(mascara.getRetornoMascaraDinheiro());

				double exibiResultado = valor * valorAConverter;
				MascaraMoeda resultadoABC = new MascaraMoeda();
				resultadoABC.mascaraDinheiro(exibiResultado, pais, simboloMoeda, moedaDoPais, digito);
				setExibiResultado(resultadoABC.getRetornoMascaraDinheiro());

				String paisInvertido = "es";
				String simboloMoedaInvertido = "AR";
				String moedaDoPaisInvertido = "ARS";
				int digitoInvertido = 3;

				double exibiResultadoInvertido = valorAConverter;
				MascaraMoeda resultadoInvertido = new MascaraMoeda();
				resultadoInvertido.mascaraDinheiro(exibiResultadoInvertido, paisInvertido, simboloMoedaInvertido,
						moedaDoPaisInvertido, digitoInvertido);
				setExibiResultadoInvertido(resultadoInvertido.getRetornoMascaraDinheiro());
				setNomeMoedaB("Peso Argentino");
				setNomeMoedaA("Real BRL");

			} catch (IOException e1) {
			}

		} else if (moeda.equals("Peso Chileno/Real BRL")) {

			ConectaApiHttpValorMoedas converterRealDola = new ConectaApiHttpValorMoedas();
			converterRealDola.setMoeda("CLP-BRL");

			double valor;
			try {
				valor = converterRealDola.conectaApiHttpValorMoedas();

				String pais = "pt";
				String simboloMoeda = "BR";
				String moedaDoPais = "BRL";
				int digito = 4;

				MascaraMoeda mascara = new MascaraMoeda();
				mascara.mascaraDinheiro(valor, pais, simboloMoeda, moedaDoPais, digito);
				setResultado(mascara.getRetornoMascaraDinheiro());

				double exibiResultado = valor * valorAConverter;
				MascaraMoeda resultadoABC = new MascaraMoeda();
				resultadoABC.mascaraDinheiro(exibiResultado, pais, simboloMoeda, moedaDoPais, digito);
				setExibiResultado(resultadoABC.getRetornoMascaraDinheiro());

				String paisInvertido = "es";
				String simboloMoedaInvertido = "CL";
				String moedaDoPaisInvertido = "CLP";
				int digitoInvertido = 4;

				double exibiResultadoInvertido = valorAConverter;
				MascaraMoeda resultadoInvertido = new MascaraMoeda();
				resultadoInvertido.mascaraDinheiro(exibiResultadoInvertido, paisInvertido, simboloMoedaInvertido,
						moedaDoPaisInvertido, digitoInvertido);
				setExibiResultadoInvertido(resultadoInvertido.getRetornoMascaraDinheiro());
				setNomeMoedaB("Peso Chileno");
				setNomeMoedaA("Real BRL");

			} catch (IOException e1) {
			}
		}

		else if (moeda.equals("Real BRL/Dólar USD")) {

			ConectaApiHttpValorMoedas converterRealDola = new ConectaApiHttpValorMoedas();
			converterRealDola.setMoeda("BRL-USD");

			double valor;
			try {
				valor = converterRealDola.conectaApiHttpValorMoedas();

				String pais = "en";
				String simboloMoeda = "US";
				String moedaDoPais = "USD";
				int digito = 2;

				MascaraMoeda mascara = new MascaraMoeda();
				mascara.mascaraDinheiro(valor, pais, simboloMoeda, moedaDoPais, digito);
				setResultado(mascara.getRetornoMascaraDinheiro());

				double exibiResultado = valor * valorAConverter;
				MascaraMoeda resultadoABC = new MascaraMoeda();
				resultadoABC.mascaraDinheiro(exibiResultado, pais, simboloMoeda, moedaDoPais, digito);
				setExibiResultado(resultadoABC.getRetornoMascaraDinheiro());

				String paisInvertido = "pt";
				String simboloMoedaInvertido = "BR";
				String moedaDoPaisInvertido = "BRL";
				int digitoInvertido = 2;

				double exibiResultadoInvertido = valorAConverter;
				MascaraMoeda resultadoInvertido = new MascaraMoeda();
				resultadoInvertido.mascaraDinheiro(exibiResultadoInvertido, paisInvertido, simboloMoedaInvertido,
						moedaDoPaisInvertido, digitoInvertido);
				setExibiResultadoInvertido(resultadoInvertido.getRetornoMascaraDinheiro());
				setNomeMoedaA("Dólar USD");
				setNomeMoedaB("Real BRL");

			} catch (IOException e1) {
			}

		} else if (moeda.equals("Real BRL/Euro")) {

			ConectaApiHttpValorMoedas converterRealDola = new ConectaApiHttpValorMoedas();
			converterRealDola.setMoeda("BRL-EUR");

			double valor;
			try {
				valor = converterRealDola.conectaApiHttpValorMoedas();

				String pais = "eu";
				String simboloMoeda = "EU";
				String moedaDoPais = "EUR";
				int digito = 2;

				MascaraMoeda mascara = new MascaraMoeda();
				mascara.mascaraDinheiro(valor, pais, simboloMoeda, moedaDoPais, digito);
				setResultado(mascara.getRetornoMascaraDinheiro());

				double exibiResultado = valor * valorAConverter;
				MascaraMoeda resultadoABC = new MascaraMoeda();
				resultadoABC.mascaraDinheiro(exibiResultado, pais, simboloMoeda, moedaDoPais, digito);
				setExibiResultado(resultadoABC.getRetornoMascaraDinheiro());

				String paisInvertido = "pt";
				String simboloMoedaInvertido = "BR";
				String moedaDoPaisInvertido = "BRL";
				int digitoInvertido = 2;

				double exibiResultadoInvertido = valorAConverter;
				MascaraMoeda resultadoInvertido = new MascaraMoeda();
				resultadoInvertido.mascaraDinheiro(exibiResultadoInvertido, paisInvertido, simboloMoedaInvertido,
						moedaDoPaisInvertido, digitoInvertido);
				setExibiResultadoInvertido(resultadoInvertido.getRetornoMascaraDinheiro());
				setNomeMoedaA("Euro");
				setNomeMoedaB("Real BRL");

			} catch (IOException e1) {
			}

		} else if (moeda.equals("Real BRL/Libra Esterlina")) {

			ConectaApiHttpValorMoedas converterRealDola = new ConectaApiHttpValorMoedas();
			converterRealDola.setMoeda("BRL-GBP");

			double valor;
			try {
				valor = converterRealDola.conectaApiHttpValorMoedas();

				String pais = "en";
				String simboloMoeda = "GB";
				String moedaDoPais = "GBP";
				int digito = 2;

				MascaraMoeda mascara = new MascaraMoeda();
				mascara.mascaraDinheiro(valor, pais, simboloMoeda, moedaDoPais, digito);
				setResultado(mascara.getRetornoMascaraDinheiro());

				double exibiResultado = valor * valorAConverter;
				MascaraMoeda resultadoABC = new MascaraMoeda();
				resultadoABC.mascaraDinheiro(exibiResultado, pais, simboloMoeda, moedaDoPais, digito);
				setExibiResultado(resultadoABC.getRetornoMascaraDinheiro());

				String paisInvertido = "pt";
				String simboloMoedaInvertido = "BR";
				String moedaDoPaisInvertido = "BRL";
				int digitoInvertido = 2;

				double exibiResultadoInvertido = valorAConverter;
				MascaraMoeda resultadoInvertido = new MascaraMoeda();
				resultadoInvertido.mascaraDinheiro(exibiResultadoInvertido, paisInvertido, simboloMoedaInvertido,
						moedaDoPaisInvertido, digitoInvertido);
				setExibiResultadoInvertido(resultadoInvertido.getRetornoMascaraDinheiro());
				setNomeMoedaA("Libra Esterlina");
				setNomeMoedaB("Real BRL");

			} catch (IOException e1) {
			}
		} else if (moeda.equals("Real BRL/Peso Argentino")) {

			ConectaApiHttpValorMoedas converterRealDola = new ConectaApiHttpValorMoedas();
			converterRealDola.setMoeda("BRL-ARS");

			double valor;
			try {
				valor = converterRealDola.conectaApiHttpValorMoedas();

				String pais = "es";
				String simboloMoeda = "AR";
				String moedaDoPais = "ARS";
				int digito = 3;

				MascaraMoeda mascara = new MascaraMoeda();
				mascara.mascaraDinheiro(valor, pais, simboloMoeda, moedaDoPais, digito);
				setResultado(mascara.getRetornoMascaraDinheiro());

				double exibiResultado = valor * valorAConverter;
				MascaraMoeda resultadoABC = new MascaraMoeda();
				resultadoABC.mascaraDinheiro(exibiResultado, pais, simboloMoeda, moedaDoPais, digito);
				setExibiResultado(resultadoABC.getRetornoMascaraDinheiro());

				String paisInvertido = "pt";
				String simboloMoedaInvertido = "BR";
				String moedaDoPaisInvertido = "BRL";
				int digitoInvertido = 3;

				double exibiResultadoInvertido = valorAConverter;
				MascaraMoeda resultadoInvertido = new MascaraMoeda();
				resultadoInvertido.mascaraDinheiro(exibiResultadoInvertido, paisInvertido, simboloMoedaInvertido,
						moedaDoPaisInvertido, digitoInvertido);
				setExibiResultadoInvertido(resultadoInvertido.getRetornoMascaraDinheiro());
				setNomeMoedaA("Peso Argentino");
				setNomeMoedaB("Real BRL");

			} catch (IOException e1) {
			}
		} else if (moeda.equals("Real BRL/Peso Chileno")) {

			ConectaApiHttpValorMoedas converterRealDola = new ConectaApiHttpValorMoedas();
			converterRealDola.setMoeda("BRL-CLP");

			double valor;
			try {
				valor = converterRealDola.conectaApiHttpValorMoedas();

				String pais = "es";
				String simboloMoeda = "CL";
				String moedaDoPais = "CLP";
				int digito = 4;

				MascaraMoeda mascara = new MascaraMoeda();
				mascara.mascaraDinheiro(valor, pais, simboloMoeda, moedaDoPais, digito);
				setResultado(mascara.getRetornoMascaraDinheiro());

				double multiplicacaoDeValorEValorAConverter = valor * valorAConverter;
				MascaraMoeda exibiResultadoComMascaraDeMoeda = new MascaraMoeda();
				exibiResultadoComMascaraDeMoeda.mascaraDinheiro(multiplicacaoDeValorEValorAConverter, pais, simboloMoeda, moedaDoPais, digito);
				setExibiResultado(exibiResultadoComMascaraDeMoeda.getRetornoMascaraDinheiro());

				String paisInvertido = "pt";
				String simboloMoedaInvertido = "BR";
				String moedaDoPaisInvertido = "BRL";
				int digitoInvertido = 4;

				double exibiResultadoInvertido = valorAConverter;
				MascaraMoeda resultadoInvertido = new MascaraMoeda();
				resultadoInvertido.mascaraDinheiro(exibiResultadoInvertido, paisInvertido, simboloMoedaInvertido,
						moedaDoPaisInvertido, digitoInvertido);
				setExibiResultadoInvertido(resultadoInvertido.getRetornoMascaraDinheiro());
				setNomeMoedaA("Peso Chileno");
				setNomeMoedaB("Real BRL");

			} catch (IOException e1) {
			}
		} else {
			setResultado("");
		}

	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getNomeMoedaB() {
		return nomeMoedaB;
	}

	public void setNomeMoedaB(String nomeMoeda) {
		this.nomeMoedaB = nomeMoeda;
	}

	public String getNomeMoedaA() {
		return nomeMoedaA;
	}

	public void setNomeMoedaA(String nomeMoedaEstrangeira) {
		this.nomeMoedaA = nomeMoedaEstrangeira;
	}

}
