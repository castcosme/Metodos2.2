//Guillermo Arturo Hernández Tapia      A01321776

public class Fraccion {
	//Miembros de datos
	private int numerador;
	private int denominador;
	
	//Constructores
	public Fraccion(){
		asignaNumerador(0);
		asignaDenominador(1);
	}
	public Fraccion(int num){
		asignaNumerador(num);
		asignaDenominador(1);
		
	}
	public Fraccion(int num, int denom){
		asignaNumerador(num);
		asignaDenominador(denom);	
	}
	
	//Metodos que obtienen el numerador y denominador de una fraccion
	public int obtenNumerador(){
		return numerador;
	}
	public int obtenDenominador(){
		return denominador;
	}
	
	//Metodos que asignan el numerador y denominador 
	public void asignaNumerador(int num){
		numerador = num;
	}
	public void asignaDenominador(int denom){
		//Comprueba que el denominador no sea 0
		if(denom == 0){
            System.out.println("Error. Divicion entre 0.");
		}
			denominador = denom;
	}
	//Metodo que simplifica una fraccion
	public Fraccion simplifica(){
		int menor;
		if(obtenNumerador() < obtenDenominador()){
			menor = obtenNumerador();
		}else{
			menor = obtenDenominador();
		}
		
		for(int i = menor; i >= 2; i--){
			if (obtenNumerador()%i == 0 && obtenDenominador()%i == 0){
				//Numerador asignale numerador entre i
				asignaNumerador(obtenNumerador()/i);
				asignaDenominador(obtenDenominador()/i);
			}
		}
		
		Fraccion fraccSimp = new Fraccion(obtenNumerador()/numerador, obtenDenominador()/denominador);
		return fraccSimp;
	}
	
	public Fraccion suma(Fraccion fracc){
		int a, b, c, d;
		
		a = obtenNumerador();
		b = obtenDenominador();
		c = fracc.obtenNumerador();
		d = fracc.obtenDenominador();
		
		Fraccion suma = new Fraccion((a*d + b*c), b*d);
		return suma;
	}
	public Fraccion resta(Fraccion fracc){
		int a, b, c, d;
		
		a = obtenNumerador();
		b = obtenDenominador();
		c = fracc.obtenNumerador();
		d = fracc.obtenDenominador();
		
		Fraccion resta = new Fraccion((a*d - b*c), b*d);
		return resta;	
	}
	public Fraccion multiplica(Fraccion fracc){
		int a, b, c, d;
		
		a = obtenNumerador();
		b = obtenDenominador();
		c = fracc.obtenNumerador();
		d = fracc.obtenDenominador();
		
		Fraccion multiplica = new Fraccion(a*c, b*d);
		return multiplica;	
	}
	public Fraccion divide(Fraccion fracc){
		int a, b, c, d;
		
		a = obtenNumerador();
		b = obtenDenominador();
		c = fracc.obtenNumerador();
		d = fracc.obtenDenominador();
		
		Fraccion divide = new Fraccion((a*d + b*c), b*d);
		return divide;	
	}
	
	public String consFraccion(int espacios){
		String esp = "";
		int espa = espacios - Integer.toString(denominador).length();
		for(int i = 0; i < espa; i++){
			esp += " ";
		}
        return (obtenNumerador() + "/" + esp + obtenDenominador());
	}
	
	public Fraccion invertir(Fraccion fracc){
		if(numerador != 0){
			numerador = fracc.obtenDenominador();
			denominador = fracc.obtenNumerador();
			Fraccion fraccion = new Fraccion(numerador, denominador);
			return fraccion;
		}
		return null;
	}

}