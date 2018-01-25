package oving8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BinaryOperator;

public class Manager implements Employee{
	
	private List<Employee> employees;
	int taskCount;
	int turn;
	
	public Manager (Collection<Employee> employees){
		if (employees.isEmpty()){
			throw new IllegalArgumentException("Ingen employees i lista");
		}
		this.employees = new ArrayList<>();
		for (Employee emp : employees){
			this.employees.add(emp);
		}
		this.turn = 0;
		taskCount = 0;
		
	}

	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		if (turn == employees.size()-1){
			turn = 0;
		}
		else{
			turn++;
		}
		Employee emp = employees.get(turn);
		taskCount++;
		return emp.doCalculations(operation, value1, value2);

	}

	@Override
	public void printDocument(String document) {
		if (turn == employees.size()-1){
			turn = 0;
		}
		else{
			turn++;
		}
		Employee emp = employees.get(turn);
		taskCount++;
		emp.printDocument(document);
		
	}

	@Override
	public int getTaskCount() {
		return this.taskCount;
	}

	@Override
	public int getResourceCount() {
		int count = 0;
		for (Employee emp : employees){
			count += emp.getResourceCount();
		}
		
		return count+1;
	}

}
