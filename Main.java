import java.util.Scanner;

public class Main{
  public static void main(String[] args) {
    int s, i, pasos;
    Scanner sc = new Scanner(System.in);
    s = Integer.parseInt(sc.next());
    int estados[] = new int[s*4];
    Fraccion arr[] = new Fraccion[s*2];
    for (i=0; i<s*4; i++) {
      estados[i]=Integer.parseInt(sc.next());
    }
    int c=0;
    for (i=0; i<s*2; i++) {
      arr[i]=new Fraccion(estados[c], estados[c+1]);
      c+=2;
    }

    pasos =Integer.parseInt(sc.next());
    System.out.println("P1:");
    for (i=0; i<arr.length; i++) {
      System.out.println(arr[i] + "     " + arr[i+1]);
      i++;
    }

    for (i=2; i<=pasos; i++) {
      pasosMatrices(arr, i);
    }
  }

  public static void pasosMatrices(Fraccion a[], int p){
    int pasoMatrix=p;
    Fraccion paso[]=new Fraccion[a.length];

    while(p!=1){
      paso[0]=Fraccion.sumar(Fraccion.multiplicar(a[0],a[0]),Fraccion.multiplicar(a[1],a[2]));
      paso[1]=Fraccion.sumar(Fraccion.multiplicar(a[0],a[1]),Fraccion.multiplicar(a[1],a[3]));
      paso[2]=Fraccion.sumar(Fraccion.multiplicar(a[2],a[0]),Fraccion.multiplicar(a[3],a[2]));
      paso[3]=Fraccion.sumar(Fraccion.multiplicar(a[2],a[1]),Fraccion.multiplicar(a[3],a[3]));

      p--;
    }
    System.out.println("P"+pasoMatrix);
    for (p=0; p<paso.length; p++) {
      System.out.println(paso[p] + "      " + paso[p+1]);
      p++;
    }
  }
}
