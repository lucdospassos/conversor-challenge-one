package conversor;

import javax.swing.*;

public class CalculaMedidas {

	public static double milimetroParaCentimetro(double milimetro) {
		return milimetro / 10.0;
	}

	public static double milimetroParaMetro(double milimetro) {
		return milimetro / 1000.0;
	}

	public static double milimetroParaKm(double milimetro) {
		return milimetro / 1000000.0;
	}

	public static double milimetroParaPolegada(double milimetro) {
		return milimetro * 0.0393701;
	}

	public static double milimetroParaPes(double milimetro) {
		return milimetro * 0.00328084;
	}

	public static double centimetroParaMilimetro(double centimetro) {
		return centimetro * 10.0;
	}

	public static double centimetroParaMetro(double centimetro) {
		return centimetro / 100.0;
	}

	public static double centimetroParaKm(double centimetro) {
		return centimetro / 100000.0;
	}

	public static double centimetroParaPolegada(double centimetro) {
		return centimetro * 0.393701;
	}

	public static double centimetroParaPes(double centimetro) {
		return centimetro * 0.0328084;
	}

	public static double metroParaMilimetro(double metro) {
		return metro * 1000.0;
	}

	public static double metroParaCentimetro(double metro) {
		return metro * 100.0;
	}

	public static double metroParaKm(double metro) {
		return metro / 1000.0;
	}

	public static double metroParaPolegada(double metro) {
		return metro * 39.3701;
	}

	public static double metroParaPes(double metro) {
		return metro * 3.28084;
	}

	public static double kmParaMilimetro(double km) {
		return km * 1000000.0;
	}

	public static double kmParaCentimetro(double km) {
		return km * 100000.0;
	}

	public static double kmParaMetro(double km) {
		return km * 1000.0;
	}

	public static double kmParaPolegada(double km) {
		return km * 39370.1;
	}

	public static double kmParaPes(double km) {
		return km * 3280.84;
	}

	public static double polegadaParaMilimetro(double polegada) {
		return polegada * 25.4;
	}

	public static double polegadaParaCentimetro(double polegada) {
		return polegada * 2.54;
	}

	public static double polegadaParaMetro(double polegada) {
		return polegada * 0.0254;
	}

	public static double polegadaParaKm(double polegada) {
		return polegada * 2.54e-5;
	}

	public static double polegadaParaPes(double polegada) {
		return polegada * 0.0833333;
	}

	public static double pesParaMilimetro(double pes) {
		return pes * 304.8;
	}

	public static double pesParaCentimetro(double pes) {
		return pes * 30.48;
	}

	public static double pesParaMetro(double pes) {
		return pes * 0.3048;
	}

	public static double pesParaKm(double pes) {
		return pes * 3.048e-4;
	}

	public static double pesParaPolegada(double pes) {
		return pes * 12.0;
	}

	public static void converterMedidas(JComboBox<String> comboBoxDe, JComboBox<String> comboBoxPara,
			JTextField textFieldValor, JLabel labelResultado) {
		String de = (String) comboBoxDe.getSelectedItem();
		String para = (String) comboBoxPara.getSelectedItem();
		double valor = Double.parseDouble(textFieldValor.getText());
		int digito = 2;

		double resultado = 0.0;

		if (de.equals("Milímetro")) {
			if (para.equals("Centímetro")) {
				resultado = milimetroParaCentimetro(valor);
			} else if (para.equals("Metro")) {
				digito = 3;
				resultado = milimetroParaMetro(valor);
			} else if (para.equals("Km")) {
				digito = 7;
				resultado = milimetroParaKm(valor);
			} else if (para.equals("Polegada")) {
				digito = 3;
				resultado = milimetroParaPolegada(valor);
			} else if (para.equals("Pés")) {
				digito = 4;
				resultado = milimetroParaPes(valor);
			}
		} else if (de.equals("Centímetro")) {
			if (para.equals("Milímetro")) {
				resultado = centimetroParaMilimetro(valor);
			} else if (para.equals("Metro")) {
				resultado = centimetroParaMetro(valor);
			} else if (para.equals("Km")) {
				digito = 6;
				resultado = centimetroParaKm(valor);
			} else if (para.equals("Polegada")) {
				resultado = centimetroParaPolegada(valor);
			} else if (para.equals("Pés")) {
				digito = 3;
				resultado = centimetroParaPes(valor);
			}
		} else if (de.equals("Metro")) {
			if (para.equals("Milímetro")) {
				resultado = metroParaMilimetro(valor);
			} else if (para.equals("Centímetro")) {
				resultado = metroParaCentimetro(valor);
			} else if (para.equals("Km")) {
				digito = 4;
				resultado = metroParaKm(valor);
			} else if (para.equals("Polegada")) {
				resultado = metroParaPolegada(valor);
			} else if (para.equals("Pés")) {
				resultado = metroParaPes(valor);
			}
		} else if (de.equals("Km")) {
			if (para.equals("Milímetro")) {
				resultado = kmParaMilimetro(valor);
			} else if (para.equals("Centímetro")) {
				resultado = kmParaCentimetro(valor);
			} else if (para.equals("Metro")) {
				resultado = kmParaMetro(valor);
			} else if (para.equals("Polegada")) {
				resultado = kmParaPolegada(valor);
			} else if (para.equals("Pés")) {
				resultado = kmParaPes(valor);
			}
		} else if (de.equals("Polegada")) {
			if (para.equals("Milímetro")) {
				resultado = polegadaParaMilimetro(valor);
			} else if (para.equals("Centímetro")) {
				resultado = polegadaParaCentimetro(valor);
			} else if (para.equals("Metro")) {
				resultado = polegadaParaMetro(valor);
			} else if (para.equals("Km")) {
				digito = 5;
				resultado = polegadaParaKm(valor);
			} else if (para.equals("Pés")) {
				resultado = polegadaParaPes(valor);
			}
		} else if (de.equals("Pés")) {
			if (para.equals("Milímetro")) {
				resultado = pesParaMilimetro(valor);
			} else if (para.equals("Centímetro")) {
				resultado = pesParaCentimetro(valor);
			} else if (para.equals("Metro")) {
				resultado = pesParaMetro(valor);
			} else if (para.equals("Km")) {
				digito = 5;
				resultado = pesParaKm(valor);
			} else if (para.equals("Polegada")) {
				resultado = pesParaPolegada(valor);
			}
		}

		labelResultado.setText(String.format("Res.: %." + digito + "f %s", resultado, para));
	}
}
