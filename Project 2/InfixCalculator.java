/*
 * Created by Jasque Saydyk
 * Project 02 - Linked Lists, Stacks, and Queues
 * CS 249
 * 19 March 2017
 * Description - This class creates the InfixCalculator to solve infix equations
*/
public class InfixCalculator implements IInfixCalculator{

	IStack<Character> operatorStack;
	IQueue<String> postfixQueue;
	PostfixCalculator calc;
	
	/**
	 * Default constructor for InfixCalculator
	 */
	public InfixCalculator(){
		operatorStack = new Stack<>();
		postfixQueue = new Queue<>();
		calc = new PostfixCalculator();
	}
	
	
	/** 
	 * Process a single operator.  You must support the operators
     * '+', '-', '*', '/', '(' and ')'.
     * Throw an InvalidArgumentException if an invalid opeator is provided or
     * if a closed parenthesis is provided without an opening paranthesis.
     * @param operator - The evaluating character for the equation
     */
	@Override
	public void inputOperator(char operator) {
		Stack<Character> checkParenthesis = new Stack<>();
		int size = operatorStack.size();
		boolean openingParenthesis = false;
		
		if(operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '('){
			operatorStack.push(operator);
		}
		else if(operator == ')'){
			// Check if a opening parenthesis exists
			for(int ii = 0; ii < size; ii++){
				Character temp = operatorStack.pop();
				if(temp == '('){
					openingParenthesis = true;
					checkParenthesis.push(temp);
				}
				else{
					checkParenthesis.push(temp);
				}
			}
			
			// Revert operator stack back to normal
			int size2 = checkParenthesis.size();
			for(int ii = 0; ii < size2; ii++){
				operatorStack.push(checkParenthesis.pop());
			}
			
			// If there is an opening parenthesis, pop into queue, then get rid of op
			if(openingParenthesis == true){
				while(!operatorStack.peek().equals('(')){
					postfixQueue.push(operatorStack.pop().toString());
				}
				operatorStack.pop();
			}
			else{
				throw new IllegalArgumentException();
			}
		}
		else{
			throw new IllegalArgumentException();
		}
	}

	
	/** 
	 * Process a single numerical operand.
	 * @param operand - any int in equation to be evaluated in equation
	 */
	@Override
	public void inputOperand(int operand) {
		postfixQueue.push(Integer.toString(operand));
	}

	
	/** Closes the conversion, resolving any left over operators.
     * This leaves the operator stack empty and the queue with a
     * complete postfix equasion.
     */
	@Override
	public void endEquation() {
		int size = operatorStack.size();
		for(int ii = 0; ii < size; ii++){
			postfixQueue.push(operatorStack.pop().toString());
		}
		
	}

	
	/** 
	 * Enter a single token into the calculator representing either a single
     * number or opeartor.  Valid examples are '27', '-2', ')', or '/'.
     * Throw an InvalidArgumentException if the token is not valid, or if a
     * closed parenthesis is provided without an opening paranthesis.
     * The return value should give the remaining operands on the stack after
     * the token is applied.
     * Hint: use inputOperator() or inputOperand() to perform the computation.
     * @param token - Any operator or operand as a String
     */
	@Override
	public void inputToken(String token) {
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
		else if(token.equals("(")){
			inputOperator('(');
		}
		else if(token.equals(")")){
			inputOperator(')');
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
	}

	
	/** 
	 * Convert an equation in infix notation into postfix notation.  Break the
     * equation into tokens and then use inputToken() to process each token.
     * Throw an InvalidArgumentException if the equation contains invalid
     * tokens or if parenthesis are not balanced.
     * The return value should give the result of the equation.
     * Hint: Use inputToken() and endEquation() to perform the conversion.
     * @param equation - The entire equation written in infix as a String
     * @return The String rearranged into postfix format
     */
	@Override
	public String convertEquation(String equation) {
		String[] tokens = equation.split(" ");
		for(int ii = 0; ii < tokens.length; ii++){
			inputToken(tokens[ii]);
		}
		endEquation();
		int size = postfixQueue.size();
		String result = "";
		for(int ii = 0; ii < size; ii++){
			result += postfixQueue.pop().toString();
			if(ii != size - 1){
				result += " ";
			}
		}
		return result;
	}

	
	/** 
	 * Find the solution to an infix equation.
     * Throw an InvalidArgumentException if the equation contains invalid
     * tokens or if parethesis are not balanced.
     * Break the equation into tokens
     * You may assume that all tokens are separated by whitespace.
     * Hint: Use convertEquation() to convert to postfix, and then an
     * IPostfixCalculator object to find the result.
     * @param equation - The entire equation written in infix as a String
     * @return The result of the equation, formatted as "[20]"
     */
	@Override
	public String InputEquation(String equation) {
		String result = convertEquation(equation);
		return calc.inputEquation(result);
	}

	
	/** 
	 * Returns the stack used to track the operators.
	 * @return The stack used to track the operators
	 */
	@Override
	public IStack<Character> getInternalStack() {
		return operatorStack;
	}

	
	/** 
	 * Returns the internal queue of postfix tokens.
	 * @return The queue used to store the equation
	 */
	@Override
	public IQueue<String> getInternalPostfixQueue() {
		return postfixQueue;
	}

	
	/** 
	 * Returns the underlying postfix calculator used to find the answer after conversion.
     * @return The PostfixCalculator used to calculate result
     */
	@Override
	public IPostfixCalculator getInternalPostfixCalculator() {
		return calc;
	}
}
