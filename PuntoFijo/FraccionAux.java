public class FraccionAux {

	private long numerador = 1;
	private long denominador = 1;

	public FraccionAux(long num, long den){
		this.numerador = num;
		this.denominador = den;
	}

	public void consFraccion(){
		System.out.print(this.numerador + "/" + this.denominador );
	}

	public void multiplicar(FraccionAux fra){
		this.numerador *= fra.numerador;
		this.denominador *= fra.denominador;
		reduce();
	}
	public static FraccionAux multiplicar(FraccionAux fra, FraccionAux fra2){
		FraccionAux x= new FraccionAux(fra.numerador, fra.denominador);
		FraccionAux y= new FraccionAux(fra2.numerador, fra2.denominador);
		x.multiplicar(y);
		return x;
	}

	public void sumar(FraccionAux fra){
		long denoTmp = this.denominador * fra.denominador;
		long nume1 = (denoTmp / this.denominador) * this.numerador;
		long nume2 = (denoTmp / fra.denominador) * fra.numerador;
		this.denominador = denoTmp;
		this.numerador = nume1 + nume2;
		reduce();
	}
	public static FraccionAux sumar(FraccionAux fra, FraccionAux fra2){
		FraccionAux x= new FraccionAux(fra.numerador, fra.denominador);
		FraccionAux y= new FraccionAux(fra2.numerador, fra2.denominador);
		x.sumar(y);
		return x;
	}
	public void reduce(){
		long mcd = mcd();
        this.numerador = this.numerador / mcd;
        this.denominador = this.denominador / mcd;
    	
	}
	public void reduceLong(){
		double n,d;
		n = (double)this.numerador;
		d = (double)this.denominador;
		n = n/d;
		d = 100;
		n = 100*n;
		this.numerador = Math.round(n);
		this.denominador = (long)d;
    	
	}

    private long mcd() {
        long u = Math.abs(this.numerador);
        long v = Math.abs(this.denominador);
        if (v == 0) {
            return u;
        }
        long r;
        while (v != 0) {
            r = u % v;
            u = v;
            v = r;
        }
        return u;
    }
    public static boolean isLong(FraccionAux fra){
		if (fra.numerador>2147483647||fra.denominador>2147483647){
			return true;
		}
		return false;
	}
}