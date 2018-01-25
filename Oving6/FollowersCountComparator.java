package oving6;

import java.util.Comparator;

public class FollowersCountComparator implements Comparator<TwitterAccount>{

	@Override
	public int compare(TwitterAccount o1, TwitterAccount o2) {
		int f1 = o1.getFollowerCount();
		int f2 = o2.getFollowerCount();
		
		if (f1 > f2){
			return -1;
		}
		if (f1 < f2){
			return 1;
		}
		return 0;
	}

}
