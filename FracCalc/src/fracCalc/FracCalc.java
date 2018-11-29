/*This class contains a method that accepts two fractions and an operator and returns the solution
 * @author Sammi Yeung
 * @version November 19, 2018
 */

package fracCalc;
import static org.junit.Assert.assertArrayEquals;
import java.util.*;

public class FracCalc {
    public static void main(String[] args){
    	Scanner userInput = new Scanner(System.in);
    	System.out.println("Please input the fraction expression you would like to evaluate:");
     	String input = userInput.nextLine();
    	
    	while (!input.equals("quit")) {
    		System.out.println(produceAnswer(input));
    		System.out.println("Do you want to keep going? Type \"quit\" to end.");
			input = userInput.nextLine();
    	}
    	userInput.close();
    }
  
    public static String produceAnswer(String input){ 
    	String[] expression = input.split(" "); //separating the operands and operators
    	String operand1 = expression[0]; 
    	String operator = expression[1];
    	String operand2 = expression[2]; 
    	int[] op1 = parseOperands(operand1);
    	int[] op2 = parseOperands(operand2);
    	String finalanswer = doMath(op1, op2, operator);
    	return finalanswer;
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
    }

    public static int[] intArray(String whole, String numerator, String denominator) {
    	int parseWhole = Integer.parseInt(whole);
    	int parseNum = Integer.parseInt(numerator);	
    	int parseDenom = Integer.parseInt(denominator);	
    	int[] fracParts = {parseWhole, parseNum, parseDenom};
		return fracParts;
    }
    
    public static String doMath(int[] op1, int[] op2, String operator) {
    	int[] imprOperand1 = toImproperFrac(op1[0], op1[1], op1[2]); //arrays breaking apart parts of each operand as an improper fraction
    	int[] imprOperand2 = toImproperFrac(op2[0], op2[1], op2[2]); 
        String answer = "";
        
        if(operator.equals("+")) {
        	int numAnswer = (imprOperand1[0]*imprOperand2[1])+(imprOperand2[0]*imprOperand1[1]); 
        	int denomAnswer = commonDenominator(imprOperand1[1], imprOperand2[1]); //common denominator found
        	String mixed = toMixedNum(numAnswer, denomAnswer);
        	answer += mixed;
        }
        
        else  if(operator.equals("-")) {
        	int numAnswer = (imprOperand1[0]*imprOperand2[1])-(imprOperand2[0]*imprOperand1[1]);
        	int denomAnswer = commonDenominator(imprOperand1[1], imprOperand2[1]); //common denominator found
        	String mixed = toMixedNum(numAnswer, denomAnswer);
        	answer += mixed;
        }
        
        else if(operator.equals("*")) {
        	int numAnswer = imprOperand1[0] * imprOperand2[0];
        	int denomAnswer = imprOperand1[1] * imprOperand2[1];
        	String mixed = toMixedNum(numAnswer, denomAnswer);
        	answer += mixed;
        }
        
        else if(operator.equals("/")) {
        	int numAnswer = imprOperand1[0] * imprOperand2[1];
        	int denomAnswer = imprOperand1[1] * imprOperand2[0];
        	String mixed = toMixedNum(numAnswer, denomAnswer);
        	answer += mixed;
        }
		return answer;
    }
    
    public static int commonDenominator(int denom1, int denom2) {
    	int common = denom1 * denom2;
    	return common;
    }
    
	public static int[] toImproperFrac(int wholenum, int numerator, int denominator) { //converts mixed number to improper fraction
		int answernumerator;
		answernumerator= (wholenum*denominator)+numerator;
		int[] answer = {answernumerator, denominator};
		return answer; 
	}
	
	public static String toMixedNum(int num, int denom) { //converts improper to mixed fraction
		String answer;
		int wholenum = (num/denom);
		int newnumer = (num%denom);
		answer = (wholenum+ "_" + newnumer+"/"+denom); 
		return answer; 
	}
}
   