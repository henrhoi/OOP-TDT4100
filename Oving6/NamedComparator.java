package oving6;

import java.util.Comparator;

public class NamedComparator implements Comparator<Named>{

	@Override
	public int compare(Named o1, Named o2) {
		String f1 = o1.getGivenName();
		String f2 = o2.getGivenName();
		String l1 = o1.getFamilyName();
		String l2 = o2.getFamilyName();
		
		if(l1.equals(l2)){
			return f1.compareTo(f2);
		}
		return l1.compareTo(l2);
	}
	
	

}
