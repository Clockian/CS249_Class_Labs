/*
 * Created by Jasque Saydyk
 * Project 02 - Linked Lists, Stacks, and Queues
 * CS 249
 * 19 March 2017
 * Description - This class performs adhoc tests on the various classes included
*/

public class test {
	public static void main(String[] args){
		/*String number1 = "one";
		String number2 = "two";
		String number3 = "three";
		String number4 = "four";
		String number5 = "five";
		String[] transfer = {number1, number2, number3, number4, number5};
		//LinkedList<String> test = new LinkedList<>();
		Stack<String> stack = new Stack<>();
		Queue<String> queue = new Queue<>();
		
		int ii = 0;
		for(String x: transfer){
			//test.add(x, ii);
			stack.push(x);
			queue.push(x);
			ii++;
		}*/
		/*
		LinkedList<String>.INode<String> cursor = test.getFirstNode();
		for(int jj = 0; jj < test.size(); jj++){
			System.out.println("Data: " + cursor.data());
			cursor = cursor.next();
		}
		*/
		/*
		System.out.println(queue.toString());
		
		
		String alt = "Alternative";
	    queue.pop();
	    System.out.println(queue.toString());
	    queue.pop();
	    System.out.println(queue.toString());
	    queue.push(alt);
	    System.out.println(queue.toString());
	    queue.pop();
	    System.out.println(queue.toString());
	    queue.pop();
	    System.out.println(queue.toString());
	    
		System.out.println();
		
		//test.remove(2);
		//(LinkedList<String>.INode<String>)
		ILinkedList<String> list2 = queue.getInternalLinkedList();
		ILinkedList.INode cursor2 = list2.getFirstNode();
		
		for(int jj = 0; jj < list2.size(); jj++){
			System.out.println("Data: " + cursor2.data());
			cursor2 = cursor2.next();
		}
		
		
		/*
		ILinkedList<String> list = stack.getInternalLinkedList();
		ILinkedList.INode cursor1 = list.getFirstNode();
		for(int jj = 0; jj < stack.size(); jj++){
			System.out.println("Stack Data: " + cursor1.data());
			cursor1 = cursor1.next();
		}
		System.out.println(stack.toString());*/
		/*
		PostfixCalculator calc = new PostfixCalculator();
		
		String token = "/";
		
		System.out.println(token.equals("/"));
		
		calc.inputToken("20");
	    calc.inputToken("2");
	    calc.inputToken("/");
	    
	    System.out.println(calc.toString());*/
		System.out.println("add subtract test");
		InfixCalculator calc1 = new InfixCalculator();
		calc1.inputOperand(2);
	    calc1.inputOperator('+');
	    calc1.inputOperand(3);
	    System.out.println(calc1.getInternalStack().toString());
	    System.out.println(calc1.getInternalPostfixQueue().toString());
	    System.out.println(calc1.getInternalPostfixCalculator().toString());
	    System.out.println();
	    calc1.endEquation();
	    System.out.println(calc1.getInternalStack().toString());
	    System.out.println(calc1.getInternalPostfixQueue().toString());
	    System.out.println(calc1.getInternalPostfixCalculator().toString());
	    System.out.println();
	    
	    System.out.println("Multiply and divide test = 20");
		InfixCalculator calc = new InfixCalculator();
		calc.inputOperand(4);
	    calc.inputOperator('*');
	    calc.inputOperand(5);
	    calc.inputOperator('/');
	    calc.inputOperand(10);
	    calc.inputOperator('+');
	    calc.inputOperand(4);
	    calc.inputOperator('+');
	    calc.inputOperand(11);
	    System.out.println(calc.getInternalStack().toString());
	    System.out.println(calc.getInternalPostfixQueue().toString());
	    System.out.println(calc.getInternalPostfixCalculator().toString());
	    System.out.println();
	    calc.endEquation();
	    System.out.println(calc.getInternalStack().toString());
	    System.out.println(calc.getInternalPostfixQueue().toString());
	    System.out.println(calc.getInternalPostfixCalculator().toString());
	    System.out.println();
	    
	    System.out.println("Parenthesis test = 2");
	    InfixCalculator calc2 = new InfixCalculator();
	    calc2.inputOperand(20);
	    calc2.inputOperator('+');
	    calc2.inputOperand(7);
	    calc2.inputOperator('+');
	    calc2.inputOperand(13);
	    calc2.inputOperator('/');
	    calc2.inputOperator('(');
	    calc2.inputOperand(4);
	    calc2.inputOperator('*');
	    calc2.inputOperand(5);
	    calc2.inputOperator(')');
	    System.out.println(calc2.getInternalStack().toString());
	    System.out.println(calc2.getInternalPostfixQueue().toString());
	    System.out.println(calc2.getInternalPostfixCalculator().toString());
	    System.out.println();
	    calc2.endEquation();
	    System.out.println(calc2.getInternalStack().toString());
	    System.out.println(calc2.getInternalPostfixQueue().toString());
	    System.out.println(calc2.getInternalPostfixCalculator().toString());
	    System.out.println();
	    
	    System.out.println("Input Token Test = 2(same as previous but flipped)");
	    InfixCalculator calc3 = new InfixCalculator();
	    calc3.inputToken("(");
	    calc3.inputToken("4");
	    calc3.inputToken("*");
	    calc3.inputToken("10");
	    calc3.inputToken(")");
	    calc3.inputToken("/");
	    calc3.inputToken("10");
	    calc3.inputToken("+");
	    calc3.inputToken("2");
	    calc3.inputToken("+");
	    calc3.inputToken("8");
	    System.out.println(calc3.getInternalStack().toString());
	    System.out.println(calc3.getInternalPostfixQueue().toString());
	    System.out.println(calc3.getInternalPostfixCalculator().toString());
	    System.out.println();
	    calc3.endEquation();
	    System.out.println(calc3.getInternalStack().toString());
	    System.out.println(calc3.getInternalPostfixQueue().toString());
	    System.out.println(calc3.getInternalPostfixCalculator().toString());
	    System.out.println();
	    
	    InfixCalculator calc4 = new InfixCalculator();
	    System.out.println("Convert Equation Test = 4 10 * 10 2 8 + + /");
	    System.out.println(calc4.convertEquation("( 4 * 10 ) / 10 + 2 + 8"));
	    System.out.println();
	    
	    InfixCalculator calc5 = new InfixCalculator();
	    InfixCalculator calc6 = new InfixCalculator();
	    InfixCalculator calc7 = new InfixCalculator();
	    InfixCalculator calc8 = new InfixCalculator();
	    InfixCalculator calc9 = new InfixCalculator();
	    //InfixCalculator calc10 = new InfixCalculator();
	    System.out.println("Input Equation Test = 2");
	    System.out.println(calc5.InputEquation("( 4 * 10 ) / 10 + 2 + 8") + " = 2");
	    System.out.println(calc6.InputEquation("20 + 7 + 13 / ( 4 * 10 )") + " = 27");
	    System.out.println(calc7.InputEquation("4 * 5 / 10 + 4 + 11") + " = 0");
	    System.out.println(calc8.InputEquation("4 * 25 / 10 + 4 + 11") + " = 4");
	    System.out.println(calc9.InputEquation("2 + 3") + " = 5");
	    //System.out.println(calc10.InputEquation("2 +") + " = fail?"); //Don't need to test for case
	}
}
