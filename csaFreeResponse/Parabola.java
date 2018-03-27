package csaFreeResponse;

public class Parabola {
	private int a,b,c;
	public Parabola(int a,int b,int c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}
	public double getAxis() {
		return ((double)(-b)/(a*2));
	}
	public boolean isOnGraph(int x,int y) {
		return (a*x*x+b*x+c)==y;
	}
}
