public class TestGaussianElimination{
    public static void main(String[] args){
        Fraccion [][] P;
        Fraccion[] b, v;

        GaussianElimination ge = new GaussianElimination();

        int n = 2;

        P = new Fraccion[n][n];
        b = new Fraccion[n];

        P[0][0] = new Fraccion(1, 2);
        P[0][1] = new Fraccion(1, 2);
        P[1][0] = new Fraccion(1, 3);
        P[1][1] = new Fraccion(2, 3);

        b[0] = new Fraccion(1);
        b[1] = new Fraccion(1);

        v = ge.GaussianElim(P, b);

        System.out.println("Soluciones:");
        for(int i=0; i < n; i++){
            System.out.println("x[" + (i+1) + "] = " + v[i].consFraccion(1));
        }
    }
}
