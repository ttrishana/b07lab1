
public class Polynomial{
	double [] coefficients;
	
	public Polynomial(){
		coefficients = new double[1];
		coefficients[0] = 0;
	}
	
	public Polynomial(double [] arr) {
		if(arr!=null) {
			coefficients = new double[arr.length];
			for(int i = 0;i<arr.length;i++) {
				coefficients[i]=arr[i];
			}
		}
	}
	public Polynomial add(Polynomial poly) {
		// [6 0 7 2] + [3 2 1 3 4]?
		if(poly!=null) {
			int result_length = Math.max(poly.coefficients.length, coefficients.length);
			
			double [] result = new double[result_length];
			
			for(int i = 0;i<result_length;i++) {
				if(i>=poly.coefficients.length) {
					result[i] = coefficients[i];
				}
				else if(i>=coefficients.length) {
					result[i] = poly.coefficients[i];
				}
				else {
					result[i] = poly.coefficients[i]+coefficients[i];
				}
			}
			Polynomial sum = new Polynomial(result);
			return sum;
		}
		return null;
	}
	public double evaluate(double x) {
		double result = 0;
		for(int i = 0;i<coefficients.length;i++) {
			if(i==0) {
				result = coefficients[i];
			}
			else {
				result += coefficients[i]*(Math.pow(x, i));
			}
		}
		return result;
	}
	public boolean hasRoot(double root) {
		if(evaluate(root)==0) {
			return true;
		}
		else {
			return false;
		}
	}
}