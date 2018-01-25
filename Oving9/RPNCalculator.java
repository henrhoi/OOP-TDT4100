package oving9;

import java.util.Stack;

public class RPNCalculator extends SimpleCalculator{
	
	Stack<Double> operands;
	private boolean calculated = false;
	double result;
	
	public RPNCalculator(){
		super();
		operands = new Stack<>();
	}
	
	@Override
	public void takeInputNumber(double a){
		operands.push(a);
	}
	
	@Override
	public void takeInputOperator(char operator){
		if(operands.size() < 2){
			throw new IllegalStateException();
			}
		
		double a = operands.pop();
		double b = operands.pop();
		super.setLeftOperand(b);
		super.setOperator(operator);
		super.setRightOperand(a);
		operands.push(super.getResult());
		calculated = true;
	}
		
	@Override
	public boolean hasOutput(){
		return calculated;
		
	}
	
	@Override
	public double getOutput(){
		if(!hasOutput())
				throw new IllegalStateException();
			
		return super.getResult();
	}


}
