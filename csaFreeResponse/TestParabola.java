package csaFreeResponse;
public class TestParabola {
	public static void main(String[] args) {
		Parabola par1=new Parabola(2,-6,-5);
		double axis1=par1.getAxis();
		System.out.println(axis1); //1.5
		boolean onGraph1=par1.isOnGraph(4, 3);
		System.out.println(onGraph1); //true
		Parabola par2=new Parabola(4,2,-2);
		double axis2=par2.getAxis();
		System.out.println(axis2); //-0.25
		boolean onGraph2=par2.isOnGraph(4, 3);
		System.out.println(onGraph2); //false
	}
}
