package oving8;
	
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Printer {
	
	private HashMap<Employee,List<String>> printHistory = new HashMap<>();
	
	public void printDocument(String document, Employee employee){
		if (printHistory.containsKey(employee)){
			List<String> a = printHistory.get(employee);
			a.add(document);
			printHistory.put(employee,a);
		}
		
		else if (!printHistory.containsKey(employee)){
			List<String> a = new ArrayList<>();
			a.add(document);
			printHistory.put(employee,a);
		}
		System.out.println(document);
		
		
	}
	
	public List<String> getPrintHistory(Employee employee){
		if(!printHistory.containsKey(employee)){
			List<String> a = new ArrayList<>();
			return a;
		}
		return printHistory.get(employee);
	
		
	}

}
