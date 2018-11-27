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
  
    public static String produceAnswer(String input){ 
    	String[] expression = input.split(" "); //separating the operands and operators
    	String operand1 = expression[0]; 
    	String operator = expression[1];
    	String operand2 = expression[2]; 
    	int[] op1 = parseOperands(operand1);
    	int[] op2 = parseOperands(operand2);
    	doMath(op1, op2, operator);
    	return "";
    }
 
    public static int[] parseOperands(String operand) {
    	String whole;
    	String numerator;
    	String denominator;
    	String[] splitOperand = operand.split("_");
    	if (splitOperand.length == 1) { 
        	String[] splitFrac = splitOperand[0].split("/");
        	if (splitFrac.length == 1) { //no fraction
        		whole = splitFrac[0];
        		numerator = "0";
        		denominator = "1";
        	}
        	else { //no whole, no fraction
        		whole = "0";
        		numerator = splitFrac[0];
            	denominator = splitFrac[1];
        	}
    	}
    	else { //normal mixed number, with both a whole and a fraction
        	whole = splitOperand[0];
        	String fraction = splitOperand[1];
        	String [] splitFrac = fraction.split("/");
        		numerator = splitFrac[0];
        		denominator = splitFrac[1];
    	}
    	return intArray(whole, numerator, denominator);
	//	return "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator;
    }

    public static int[] intArray(String whole, String numerator, String denominator) {
    	int parseWhole = Integer.parseInt(whole);
    	int parseNum = Integer.parseInt(numerator);	
    	int parseDenom = Integer.parseInt(denominator);	
    	int[] fracParts = {parseWhole, parseNum, parseDenom};
		return fracParts;
    }
    
    public static int doMath(int[] op1, int[] op2, String operator) {
        int answer;
        int whole1 = op1[0];
        int num1 = op1[1];
        int denom1 = op1[2];
        int whole2 = op2[0];
        int num2 = op2[1];
        int denom2 = op2[2];
        if(operator.equals("+")) {
        	int newdenom = commonDenominator(denom1, denom2);
        }
        if(operator.equals("-")) {
        }
        if(operator.equals("*")) {
        }
        if(operator.equals("/")) {
        }
		return 2;
         
    }
    
    public static int commonDenominator(int denom1, int denom2) {
    	int common = denom1 * denom2;
    	return common;
    }
}
   