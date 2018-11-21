/*This class contains a method that accepts two fractions and an operator and returns the solution
 * @author Sammi Yeung
 * @version November 19, 2018
 */

package fracCalc;
import static org.junit.Assert.assertArrayEquals;
import java.util.*;

public class FracCalc {
    public static void main(String[] args){
    	Scanner console = new Scanner(System.in);
    	System.out.println("Please input the fraction expression you would like to evaluate:");
    	String input = console.nextLine();
    	
    	while (!input.equals("quit")) {
    		System.out.println(produceAnswer(input));
    	console.close();
    	}
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
   
    public static String produceAnswer(String input){ 
    	String[] expression = input.split(" "); //separating the operands and operators
    	String operand1 = expression[0]; 
    	String operator = expression[1];
    	String operand2 = expression[2]; 
    	return parseFractions(operand1, operand2);
    }
    
    public static String parseFractions(String operand1, String operand2) {
    	String[] splitoperand1 = operand1.split("_");
    	String[] splitoperand2 = operand2.split("_");
    	String whole1 = splitoperand1[0];
    	String whole2 = splitoperand2[0];
    	String[] splitfrac1 = splitoperand1[1].split("/");
    	String[] splitfrac2 = splitoperand2[1].split("/");
    	String numerator1 = splitfrac1[0];
    	String denominator1 = splitfrac1[1];
    	String numerator2 = splitfrac2[0];
    	String denominator2 = splitfrac2[1];
    	return "whole:" + whole2 + " numerator:" + numerator2 + " denominator:" + denominator2;
    	
    	//convert mixed numbers to improper fractions
        
       // doMath(frac1, frac2, operator);
       // return "";
        //reduce and make mixed numbers out of answer
        //return String (.toString from an int) answer
    	}
    }
    
    //public static int doMath(int frac1, int frac2, String operator) {
    //	int answer; 
    //	if(operator.equals("+")) {
    //		
	//	return answer;
    //}
     