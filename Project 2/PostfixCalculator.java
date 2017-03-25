/*
 * Created by Jasque Saydyk
 * Project 02 - Linked Lists, Stacks, and Queues
 * CS 249
 * 19 March 2017
 * Description - This class creates the PostfixCalculator to solve postfix equations
*/

public class PostfixCalculator implements IPostfixCalculator{

	IStack<Integer> stack;
	
	/**
	 * Default constructor for PostfixCalculator
	 */
	public PostfixCalculator(){
		stack = new Stack<>();
	}
	
	
	/**
	 * Resolve a single opeartor.  You must support the operators
     * '+', '-', '*', and '/'. You only need to consider division where
     * the quotient is a whole number.
     * Throw an InvalidArgumentException if an invalid opeator is provided.
     * The return value should give the remaining operands on the stack after
     * the operator is applied.
     * @param operator - The evaluating character for the equation
     * @return The remaining operands on the stack after the operator is applied
     */
	@Override
	public String inputOperator(char operator) {
		if(operator == '+'){
			stack.push(stack.pop() + stack.pop());
		}
		else if(operator == '-'){
			Integer num = stack.pop();
			stack.push(stack.pop() - num);
		}
		else if(operator == '*'){
			stack.push(stack.pop() * stack.pop());
		}
		else if(operator == '/'){
			Integer num = stack.pop();
			stack.push(stack.pop() / num);
		}
		else{
			throw new IllegalArgumentException();
		}
		return toString();
	}

	
	/** 
	 * Enter a single numberical operand onto the stack.
     * The return value should give the remaining operands on the stack after
     * the operand is added.
     * @param operand - Number to be add to the stack
     * @return The remaining operands on the stack after the operand is added
     */
	@Override
	public String inputOperand(int operand) {
		stack.push(operand);
		return toString();
	}

	
	/** 
	 * Enter a single token into the calculator representing either a single
     * number or an opeartor.  Valid examples are '27', '-2', or '/'.
     * Throw an InvalidArgumentException if the token is not an operator or an
     * operand.
     * The return value should give the remaining operands on the stack after
     * the token is applied.
     * Hint: use inputOperator() or inputOperand() to perform the computation.
     * @param token - Any operator or operand as a String
     * @return The remaining operands on the stack after the token is applied.
     */
	@Override
	public String inputToken(String token) {
		// Check if input is empty
		if(token.isEmpty()){
			throw new IllegalArgumentException();
		}
		
		// Check if input is valid char
		if(token.equals("+")){
			inputOperator('+');
		}
		else if(token.equals("-")){
			inputOperator('-');
		}
		else if(token.equals("*")){
			inputOperator('*');
		}
		else if(token.equals("/")){
			inputOperator('/');
		}
		else{
			// Check if input is int, then run operations
			try{
				Integer num = Integer.parseInt(token);
				inputOperand(num);
			}
			catch(NumberFormatException x){
				throw new IllegalArgumentException();
			}
		}
		
		return toString();
	}
	

	/**
	 * Break the equation into tokens and determine the result of the equation.
     * You may assume that all tokens are separated by whitespace.
     * Throw an InvalidArgumentException if the equation contains invalid
     * tokens.
     * The return value should give the result of the equation.
     * Hint: Use input token to perform the computation.
     * @param equation - The entire equation written in infix as a String
     * @return The result of the equation.
     */
	@Override
	public String inputEquation(String equation) {
		String[] tokens = equation.split(" ");
		for(int ii = 0; ii < tokens.length; ii++){
			inputToken(tokens[ii]);
		}
		return toString();
	}

	
	/**
	 * Displays the operands currently on the stack. You may use the same
	 * formatting as used in IStack.
	 */
    public String toString(){
    	return stack.toString();
    }
    
    
	/**
	 * @return The stack used to track the operands.
	 */
	@Override
	public IStack getInternalStack() {
		return stack;
	}
}
