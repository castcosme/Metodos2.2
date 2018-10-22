public class GaussJordan{

    //Intercambia la fila i con la fila k
    public void swap(Fraccion P[][], int i, int k, int j){
        int m = P[0].length - 1;
        Fraccion temp = null;
        for(int c = j; c <= m; c++){
            temp = P[i][c];
            P[i][c] = P[k][c];
            P[k][c] = temp;
        }
    }

    //Divide la fila i por A[i][j]
    public void divideRow(Fraccion P[][], int i, int j){
        int m = P[0].length - 1;
        for(int c = j+1; c <= m; c++){
            P[i][c].divide(P[i][j]);    
        }
        P[i][j] = new Fraccion(1);
    }

    // Resta el multiplo apropiado de la fila i por cualquier otra fila
    public void eliminateFactors(Fraccion P[][], int i, int j){
        int n = P.length - 1;
        int m = P[0].length - 1;

        Fraccion cero = new Fraccion();
        
        for(int c = 1; c <= n; c++){
            if(c != i && !P[c][j].sonIguales(cero)){
                for(int q = j+1; q <= m; q++){
                    P[c][q] = P[c][q].resta(P[c][j].multiplica(P[i][q]));
                }
                P[c][j] = new Fraccion();
            }
        }
    }

    public void GaussJordanElimination(Fraccion P[][]){
        int i = 0;
        int j = 0;
        int k = 0;
        int n = P.length;
        int m = P[0].length;

        Fraccion cero = new Fraccion();
        Fraccion uno = new Fraccion(1);

        while(i <= n && j <= m){
            k = i;
            while(k <= n && P[k][j].sonIguales(cero)){
                k++;
            } 

            if(k <= n){
                if(k != i){
                    swap(P, i, k, j);
                }

                if(!P[i][j].sonIguales(uno)){
                    divideRow(P, i, j);
                }

                eliminateFactors(P, i, j);
                i ++;
            }
            j++;
        }
    }
}