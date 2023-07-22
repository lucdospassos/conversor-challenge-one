package conversor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ConectaApiHttpValorMoedas {

	private String moeda;

	public String getMoeda() {
		return moeda;
	}

	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}

	public double conectaApiHttpValorMoedas() throws IOException {
		String urlAwesomeApi = "https://economia.awesomeapi.com.br/json/last/" + moeda;
		URL url = new URL(urlAwesomeApi);
		URLConnection connection = url.openConnection();
		InputStream is = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		StringBuilder jsonValorMoeda = new StringBuilder();

		String valor;
		while ((valor = br.readLine()) != null) {
			jsonValorMoeda.append(valor);
		}

		String valorCotacao = jsonValorMoeda.toString();

		valorCotacao = valorCotacao.split("\"ask\":")[1].split(",")[0];
		valorCotacao = valorCotacao.replaceAll("[^\\d.]", "");

		double valorDaCotacaoAtual = Double.parseDouble(valorCotacao);
		return valorDaCotacaoAtual;
	}
}
