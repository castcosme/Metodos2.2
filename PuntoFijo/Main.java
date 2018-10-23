import java.util.Scanner;

public class Main {
	public static void main (String args[]) {
		FraccionAux[][] p;
	    FraccionAux[][] vector;
		FraccionAux[][] p_aux;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Tamanio de matriz: ");
		
		int tamanio = scan.nextInt();
		System.out.println(tamanio);
		p = new FraccionAux[tamanio][tamanio];
		vector = new FraccionAux[tamanio][tamanio];
		p_aux = new FraccionAux[tamanio][tamanio];

		for(int i = 0; i < tamanio; i++){
			for (int j = 0; j < tamanio ; j++) {
				p[i][j] = new FraccionAux(scan.nextLong(), scan.nextLong());
				vector[i][j] = new FraccionAux(0, 1);
				p_aux[i][j] = new FraccionAux(0, 1);
			}
		}

		VectorPuntoFijo _mat = new VectorPuntoFijo(tamanio, p, vector, p_aux);
		
		_mat.getVectorPuntoFijo();
	}
}