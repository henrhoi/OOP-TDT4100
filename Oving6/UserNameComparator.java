package oving6;

import java.util.Comparator;

public class UserNameComparator implements Comparator<TwitterAccount>{

	@Override
	public int compare(TwitterAccount o1, TwitterAccount o2) {
		String u1 = o1.getUserName();
		String u2 = o2.getUserName();
		return u1.compareTo(u2);
	}

}
