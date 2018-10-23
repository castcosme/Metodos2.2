public class GaussianElimination{

    public Fraccion[] GaussianElim(Fraccion P[][], Fraccion v[]){
        int n = v.length;

        Fraccion pivot, factor;
        
        for(int i=0; i < n; i++){
            pivot = P[i][i];

            for(int j=0; j < n; j++){
                P[i][j] = P[i][j].divide(pivot);
            }

            v[i] = v[i].divide(pivot);

            for(int k=0; k < n; k++){
                if(k != i){
                    factor = P[k][i];

                    for(int j=0; j < n; j++){
                        P[k][j] = P[k][j].resta(factor.multiplica(P[i][j]));
                    }

                    v[k] = v[k].resta(factor.multiplica(v[i]));
                }
            }
        }
        return v;
    }
}