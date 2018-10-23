
import java.math.BigInteger;

public class FraccionBigInt{

  //Miembros de datos
	private BigInteger numerador;
	private BigInteger denominador;

	public FraccionBigInt(BigInteger num, BigInteger denom){
		asignaNumerador(num);
		asignaDenominador(denom);
	}

	//Metodos que obtienen el numerador y denominador de una FraccionBigInt
	public BigInteger obtenNumerador(){
		return numerador;
	}
	public BigInteger obtenDenominador(){
		return denominador;
	}

	//Metodos que asignan el numerador y denominador
	public void asignaNumerador(BigInteger num){
		numerador = num;
	}
	public void asignaDenominador(BigInteger denom){
		denominador = denom;
	}


  public static FraccionBigInt sumar(FraccionBigInt a, FraccionBigInt b){
     BigInteger num = a.obtenNumerador().multiply(b.obtenDenominador()).add(b.obtenNumerador().multiply(a.obtenDenominador()));
     BigInteger den = a.obtenDenominador().multiply(b.obtenDenominador());
     return new FraccionBigInt (num, den);
  }
  public static FraccionBigInt multiplicar(FraccionBigInt a, FraccionBigInt b){
     return new FraccionBigInt(a.obtenNumerador().multiply(b.obtenNumerador()), a.obtenDenominador().multiply(b.obtenDenominador()));
  }
  public static FraccionBigInt simplificar(FraccionBigInt a){
     BigInteger dividir=mcd(a);
     BigInteger num = a.obtenNumerador().divide(dividir);
     BigInteger den = a.obtenDenominador().divide(dividir);
     return new FraccionBigInt(num,den);
  }
  private static BigInteger mcd(FraccionBigInt a){
     BigInteger u= a.obtenNumerador().abs();
     BigInteger v= a.obtenDenominador().abs();
     if(BigInteger.valueOf(0).equals(v)){
          return u;
     }
     BigInteger r;
     while(!BigInteger.valueOf(0).equals(v)){
          r=u.mod(v);
          u=v;
          v=r;
     }
     return u;
  }
  public String toString(){
     String texto=obtenNumerador()+" / "+obtenDenominador();
     return texto;
  }
}
