

public class VectorPuntoFijo{
	private int tamanio = 0;
	private FraccionAux [][] p;
	private FraccionAux [][] vector;
	private FraccionAux [][] p_aux;

	public VectorPuntoFijo(int tam, FraccionAux[][] p, FraccionAux [][] vector, FraccionAux [][] p_aux){
		this.tamanio = tam;
		this.p = p;
		this.vector = vector;
		this.p_aux = p_aux;
	}

	public void getVectorPuntoFijo(){
		if(this.tamanio > 1){
		 	
			for ( int y = 0; y < this.tamanio; y++){
			    for ( int x = 0; x < this.tamanio; x++){
				    for ( int z = 0; z < this.tamanio; z++ ){
				    	vector[x][y].sumar(FraccionAux.multiplicar(p[x][z],p[z][y]));
				    }
				}
		    }
			for(int i=0;i<=100; i++){
		    	for ( int y = 0; y < this.tamanio; y++){
					for ( int x = 0; x < this.tamanio; x++){
				    	for ( int z = 0; z < this.tamanio; z++ ){
				    	p_aux[x][y].sumar(FraccionAux.multiplicar(vector[x][z],p[z][y]));
				    	}
					}
		   		}
		    	for(int n = 0; n < tamanio; n++){
					for (int m = 0; m < tamanio ; m++) {
						vector[n][m] = p_aux[n][m];
						p_aux[n][m] = new FraccionAux(0, 1);
						if(FraccionAux.isLong(vector[n][m]))
							vector[n][m].reduceLong();
					}
				}
			}
		System.out.println();
		System.out.print("Vector de punto fijo:  (");
		for(int j=0; j < this.tamanio; j++){
	    		this.vector[0][j].consFraccion();
	    		if((j+1)!=this.tamanio)
	    			System.out.print(",");
	    	}
	    System.out.println(")");
		}
		else{
			System.out.println("Vector de punto fijo:  (1)");
		}
	}
}