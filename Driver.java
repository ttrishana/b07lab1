
import java.io.File;
import java.util.Arrays;
public class Driver {
	public static void main(String [] args) {
		/*
		//Polynomial p = new Polynomial();
		//System.out.println(p.evaluate(3));
		double [] c1 = {6,3,2,5};
		int [] e1 = {1, 2, 0, 4};
		Polynomial p1 = new Polynomial(c1, e1);
		double [] c2 = {5,-2,2,1,-9};
		int [] e2 = {0, 1, 2, 3, 4};
		//4x+5x^2 +7+x^3-4x^4
		Polynomial p2 = new Polynomial(c2, e2);
		Polynomial s = p1.add(p2);
		//System.out.println(Arrays.toString(s.coefficients)); 
        //System.out.println(Arrays.toString(s.exponents));
		Polynomial m = p1.multiply(p2);

		System.out.println(Arrays.toString(m.coefficients)); 
        System.out.println(Arrays.toString(m.exponents));
		File file = new File("/Users/trishana/Documents/polyFile.txt");
		Polynomial fileP = new Polynomial(file);
		System.out.println(Arrays.toString(fileP.coefficients)); 
        System.out.println(Arrays.toString(fileP.exponents));
		fileP.saveToFile("/Users/trishana/Documents/writeToPoly.txt");
		*/
		double [] c1 = {5, 2, 3};
		int [] e1 = {2, 1, 0};

		double [] c2 = {0};
		int [] e2 = {0};

		double [] c3 = {3};
		int [] e3 = {0};

		Polynomial p1 = new Polynomial(c1, e1);
		Polynomial zeroPoly = new Polynomial(c2, e2);
		Polynomial constant = new Polynomial(c3, e3);
		
		Polynomial result = p1.multiply(zeroPoly);
		//System.out.println(Arrays.toString(result.coefficients)); 
        //System.out.println(Arrays.toString(result.exponents));
		
		Polynomial result2 = constant.multiply(p1);
		//System.out.println(Arrays.toString(result2.coefficients)); 
        //System.out.println(Arrays.toString(result2.exponents));

		Polynomial poop = new Polynomial(new double[]{1, 2, 3}, new int[]{2, 1, 0});
		Polynomial pee = new Polynomial(new double[]{2, 1}, new int[]{2, 1});
		Polynomial result3 = poop.multiply(pee);
		//System.out.println(Arrays.toString(result3.exponents));
		//System.out.println(Arrays.toString(result3.coefficients)); 

		Polynomial p5 = new Polynomial(new double[]{-2, 3, -1}, new int[]{2, 1, 0});
		Polynomial p6 = new Polynomial(new double[]{4, -5}, new int[]{2, 0});
		Polynomial result4 = p5.multiply(p6);
		//System.out.println(Arrays.toString(result4.exponents));
		//System.out.println(Arrays.toString(result4.coefficients)); 

		Polynomial p7 = new Polynomial(new double[]{1, 1}, new int[]{1, 0});
		Polynomial result5 = p7.multiply(p7);
		//System.out.println(Arrays.toString(result5.exponents));
		//System.out.println(Arrays.toString(result5.coefficients));

		Polynomial poly = zeroPoly.multiply(zeroPoly);
		//System.out.println(Arrays.toString(poly.exponents));
		//System.out.println(Arrays.toString(poly.coefficients));

		File file = new File("/Users/trishana/Documents/polyFile.txt");
		Polynomial fileP = new Polynomial(file);
		System.out.println(Arrays.toString(fileP.coefficients)); 
        System.out.println(Arrays.toString(fileP.exponents));
		fileP.saveToFile("/Users/trishana/Documents/writeToPoly.txt");

	}
}