import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class main {
	
	//FUNCION PARA RETORNAR LAS OPCIONES DE CONVERSION, EL MSJ DE CONVERSION Y EL NOMBRE DE VENTANA
	public static String retornarOpcion(String[] opciones, String mensaje, String ventana) {
		
		return (String)JOptionPane.showInputDialog(null,mensaje 
	            ,ventana, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
	}
	
	//MUESTRA MSJ DE FIN
	public static void msjFin(){
		JOptionPane.showMessageDialog(null, "Programa finalizado");
	}
	
	//CONSULTA SI SE CANCELO EL PROGRAMA Y FINALIZA TODO
	public static void canceloPrograma(String input) {
		if(input==null) {msjFin();System.exit(0);}
	}
	
	//SWITCH PARA CALCULAR EL VALOR SEGUN LA MONEDA ELEGIDA
	public static double convertirMoneda(String conversion, double valor) {
		
		double valorFinal = 0;
		int dolar = 280;
		double euro = 300;
		double yen = 200;
		double libra = 320;
		switch(conversion) {
		case "Pesos a Dolar": valorFinal = valor * dolar; break;
		case "Pesos a Euro" : valorFinal = valor * euro; break;
		case "Pesos a Libra" : valorFinal = valor * libra;break;
		case "Pesos a Yen" : valorFinal = valor * yen;break;
		}

		return  valorFinal;
	}
	
	//FUNCION QUE TOMA EL NRO A CONVERTIR Y MANEJO DE EXEPCIONES
	public static String obtenerValor(String input) {
		String string = "";
		
		//COMPROBACION DE QUE SOLO SEAN NROS
		do {
            input = JOptionPane.showInputDialog("", "Ingrese la cantidad de dinero");
            
            canceloPrograma(input);
            if (input.matches("^[0-9]*$")) {
                string = input;
            } else {
                JOptionPane.showMessageDialog(null, "Valor no Valido");
            }
            
        } while (!input.matches("^[0-9]*$"));
		
		
		return string;
	}
	
	
	public static void programa() {
		String[] options = {"Conversor de moneda", "Conversor de temperatura"};
		String[] options2 = {"Pesos a Dolar", "Pesos a Euro", "Pesos a Libra", "Pesos a Yen", "Dolar a Pesos", "Euro a Pesos", "Libra a Pesos", "Yen a Pesos"};
		double valorFinal = 0;
		String cant = "";
			
		//SOLICITA AL USUARIO OPCION DE CONVERSION
		String listaOpciones = retornarOpcion(options, "Seleccione una opcion de convsersion" ,"Menu ");
		canceloPrograma(listaOpciones);
		if(listaOpciones == options[0]){
        	//CONVERSION DE MONEDA
	        cant = obtenerValor(cant);
	        double cantF = Double.parseDouble(cant );
	        		
	        String listaDeConversion = retornarOpcion(options2, "Elije la moneda a la que desea convertir", "Monedas");
	        canceloPrograma(listaDeConversion);		
	        //Logica de conversion
	        valorFinal = convertirMoneda(listaDeConversion, cantF);
	        	
	        JOptionPane.showMessageDialog(null, "Tienes " + valorFinal + " moneda");
	   
		} else if (listaOpciones == options[1]) {
			//CONVERSION DE TEMPERATURA
			JOptionPane.showMessageDialog(null, "Funcionalidad no implementada");
		}
	}
	
	public static int confirmacion(int i) {
		//DIalogo de confirmacion
    	return i = JOptionPane.showConfirmDialog(null, "Desea continuar?");
        // 0=yes, 1=no, 2=cancel
	}
	
	public static void main(String[] args) {
		int i = 0;
		//ICONO
		//ImageIcon icon = new ImageIcon("src/images/turtle32.png");
        while (i==0) {
        	programa();	
        	i = confirmacion(i);
        }
        JOptionPane.showMessageDialog(null, "Programa finalizado");
         
        }
}

