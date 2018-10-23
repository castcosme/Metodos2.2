import java.util.Scanner;
import java.util.Arrays;
import java.math.BigInteger;

public class Main{
  public static void main(String[] args) {
    FraccionAux[][] p;
	  FraccionAux[][] vector;
		FraccionAux[][] p_aux;

    int s, i, j, pasos;
    Scanner sc = new Scanner(System.in);
    s = Integer.parseInt(sc.next());
    int saltodelinea = s;

    p = new FraccionAux[s][s];
    vector = new FraccionAux[s][s];
    p_aux = new FraccionAux[s][s];
    for (i=0; i<s; i++) {
      for (j=0; j<s; j++) {
        vector[i][j] = new FraccionAux(0, 1);
				p_aux[i][j] = new FraccionAux(0, 1);
      }
    }

    long estadosAux[]= new long [s*s*2];

    BigInteger estados[]= new BigInteger[s*s*2];
    FraccionBigInt arr[] = new FraccionBigInt[s*s];
    FraccionBigInt dosD[][] = new FraccionBigInt[s][s];

    for (i=0; i<estados.length; i++) {
      estados[i]=sc.nextBigInteger();
      estadosAux[i]=estados[i].longValue();
    }

    int c=0;
    for (i=0; i<arr.length; i++) {
      arr[i]=new FraccionBigInt(estados[c], estados[c+1]);
      c+=2;
    }

    int d=0;
    for (i=0; i<s; i++) {
      for (j=0; j<s; j++) {
        p[i][j]=new FraccionAux(estadosAux[d], estadosAux[d+1]);
        d+=2;
      }
    }

    pasos =Integer.parseInt(sc.next());
    System.out.println("P1:");
    for (i=0; i<arr.length; i++) {
      System.out.print(arr[i]);
      System.out.print("          ");
      if (i == (saltodelinea-1)) {
        System.out.println();
        saltodelinea+=s;
      }
    }

    int test=0;
    for (i=0; i<s; i++) {
      for (j=0; j<s; j++) {
        dosD[i][j] = arr[test];
        test++;
      }
    }

    for (i=2; i<=pasos; i++) {
      pasosMatrices(dosD,i, s);
    }

    VectorPuntoFijo _mat = new VectorPuntoFijo(s, p, vector, p_aux);

		_mat.getVectorPuntoFijo();
  }

  public static void pasosMatrices(FraccionBigInt a[][], int p, int tamanio){
    int pasoMatrix=p;

    FraccionBigInt base[][] = new FraccionBigInt[tamanio][tamanio];

    FraccionBigInt paso[][] = new FraccionBigInt[tamanio][tamanio];
    for (int i = 0; i<tamanio; i++) {
      for (int j =0; j<tamanio; j++) {
        paso[i][j]=a[i][j];
      }
    }

    FraccionBigInt producto[][] = new FraccionBigInt[tamanio][tamanio];

    while(p!=1){

      for (int i = 0; i<tamanio; i++) {
        for (int j =0; j<tamanio; j++) {
          base[i][j]=a[i][j];
        }
      }


      for (int i = 0; i<tamanio; i++) {
        for (int j =0; j<tamanio; j++) {
          producto[i][j]=new FraccionBigInt(BigInteger.valueOf(0),BigInteger.valueOf(1));
        }
      }

      for (int i = 0; i < tamanio ; i++) {
        for (int j = 0; j < tamanio; j++) {
          for (int k = 0; k < tamanio ; k++) {
            producto[i][j] = FraccionBigInt.simplificar(FraccionBigInt.sumar(producto[i][j],FraccionBigInt.multiplicar(base[i][k],paso[k][j])));
          }
        }
      }

      for (int i = 0; i<tamanio; i++) {
        for (int j =0; j<tamanio; j++) {
          paso[i][j]=producto[i][j];
        }
      }
      p--;
    }


    System.out.println("\nP"+pasoMatrix+":");
    for (int i=0; i<tamanio; i++) {
      for (int j=0; j<tamanio; j++) {
        System.out.print(producto[i][j]);
        System.out.print("          ");
      }
      System.out.println("");
    }
  }
}
