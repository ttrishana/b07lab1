import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;


public class Polynomial{
	double [] coefficients;
	int [] exponents;
	
	public Polynomial(){
		coefficients = null;
		exponents = null;
	}
	
	public Polynomial(double [] arrCoeff, int [] arrExp) {
		if(arrCoeff != null) {
			coefficients = new double[arrCoeff.length];
			for(int i = 0;i<arrCoeff.length;i++) {
				coefficients[i]=arrCoeff[i];
			}
		}
		if(arrExp != null) {
			exponents = new int[arrExp.length];
			for(int i = 0;i<arrExp.length;i++) {
				exponents[i]=arrExp[i];
			}
		}
	}

	public Polynomial(File file) {
		String line = "";
		try {
			Scanner scanner = new Scanner(file);

            line = scanner.nextLine();
            //System.out.println(line);
            
            scanner.close();
		}
		catch (FileNotFoundException e) {
            System.out.println("File not found error: " + e.getMessage());
        }
		String [] arr = line.trim().split("(?=[+-])");
		//System.out.println(Arrays.toString(arr)); 

		int length = arr.length;
		if(length == 1 && Double.parseDouble(arr[0].split("x")[0])==0){
			exponents = new int[0];
			coefficients = new double[0];
			length = 0;
		}
		else{
			exponents = new int[length];
			coefficients = new double[length];
		}
		

		for(int i=0;i<length;i++){
			arr[i] = arr[i].trim();
			if(arr[i].contains("x")){
				String [] subArr = arr[i].split("x");
				coefficients[i] = Double.parseDouble(subArr[0]);
				exponents[i] = Integer.parseInt(subArr[1]);
			}
			else{
				exponents[i]=0;
				coefficients[i]= Double.parseDouble(arr[i]);
			}
		}

	}

	public void saveToFile(String fileName){
		File file = new File(fileName);
		try {
			PrintStream ps = new PrintStream(file);
			String output = "";
			for(int i = 0;i<coefficients.length;i++){
				double coeff = coefficients[i];
				int exp = exponents[i];
				//System.out.println("coeff:"+coeff +"exp:"+exp);
				if (i>0 && coeff > 0) {
					output+= "+";
				}

				if (exp == 0) {
					output += coeff;
				}
				else{
					output += coeff+"x"+exp;
				}
				
			}
			//System.out.println(output);
			ps.println(output);
		} catch (FileNotFoundException e) {
            System.out.println("File not found error: " + e.getMessage());
        }
	}

	public Polynomial add(Polynomial poly) {
		HashMap<Integer, Double> poly1 = new HashMap<>();
		HashMap<Integer, Double> poly2 = new HashMap<>();

		
		if(this.exponents.length>poly.exponents.length){
			poly1 = convert_to_hash(this);
			poly2 = convert_to_hash(poly);
		}
		else{
			poly2 = convert_to_hash(this);
			poly1 = convert_to_hash(poly);
		}
		
		HashMap<Integer, Double> addedHash = new HashMap<>();
		
		
		for (int i: poly1.keySet()) {
			if (poly2.containsKey(i)) {
				double sum = poly1.get(i) + poly2.get(i);
                if (sum != 0) {
                    addedHash.put(i, sum);
                }
			}
			else {
                addedHash.put(i, poly1.get(i));
            }
		}
		
		Polynomial addedPoly = convert_to_poly(addedHash);
		return addedPoly;
	}
	
	public HashMap<Integer, Double> convert_to_hash(Polynomial poly) {
		HashMap<Integer, Double> newHash = new HashMap<>();
		for(int i = 0; i<poly.exponents.length;i++) {
			newHash.put(poly.exponents[i], poly.coefficients[i]);
		}
		return newHash;
	}
	
	public Polynomial convert_to_poly(HashMap<Integer, Double> hash) {
		
		int [] new_exp = new int[hash.size()];
		double [] new_coeff = new double[hash.size()];
		//int [] array = new int[hash.size()];
		
		int[] array = hash.keySet().stream().mapToInt(Integer::intValue).toArray();
		
		
		for(int j = 0; j<hash.size();j++) {
			new_exp[j] = array[j];
			new_coeff[j] = hash.get(array[j]);
		}
		Polynomial newPoly = new Polynomial(new_coeff, new_exp);
		return newPoly;
	}
	
	public double evaluate(double x) {
		double result = 0;
		HashMap<Integer, Double> poly1 = convert_to_hash(this);
		for(int i: poly1.keySet()) {
			result+= Math.pow(x, i)* poly1.get(i);
		}
		
		return result;
	}

	public boolean hasRoot(double root) {
		return evaluate(root)==0;
	}

	public Polynomial multiply(Polynomial poly){
		HashMap<Integer, Double> poly1 = convert_to_hash(poly);
		HashMap<Integer, Double> poly2 = convert_to_hash(this);

		HashMap<Integer, Double> multHash = new HashMap<>();

		for(int i: poly1.keySet()){
			for(int j: poly2.keySet()){
				if (poly1.get(i)*poly2.get(j)!=0) {
					if(multHash.containsKey(i+j)){
						multHash.put(i+j, multHash.get(i+j)+ poly1.get(i)*poly2.get(j));
					}
					else{
						multHash.put(i+j, poly1.get(i)*poly2.get(j));
					}
				}
			}
		}

		Polynomial multPoly = convert_to_poly(multHash);
		return multPoly;
	}
}