package oving5;
import oving5.Tweet;

import java.util.ArrayList;

public class TwitterAccount {
	
	private String username;
	private ArrayList<TwitterAccount> followers;
	private ArrayList<TwitterAccount> following;
	private ArrayList<Tweet> tweets;
	private int NumberOfTweets = 0;
	private int NumberOfRetweets = 0;
	
	
	
	
	public TwitterAccount(String username){
		ArrayList<TwitterAccount> followers = new ArrayList<TwitterAccount>();
		ArrayList<TwitterAccount> following = new ArrayList<TwitterAccount>();
		ArrayList<Tweet> tweets = new ArrayList<Tweet>();
		this.username = username;
		this.followers = followers;
		this.following = following;
		this.tweets = tweets;
	}
	
	public String getUserName(){
		return username;
	}
	
	public void follow(TwitterAccount account){
		following.add(account);
		account.followers.add(this);
	}
	
	public void unfollow(TwitterAccount account){
		if (account.isFollowedBy(this)){
			int i = account.followers.indexOf(this);
			account.followers.remove(i);
			int j = following.indexOf(account);
			following.remove(j);	
		}
	}
	
	public boolean isFollowing(TwitterAccount account){
		if(following.contains(account)){
			return true;
		}
		return false;
	}
	
	public boolean isFollowedBy(TwitterAccount account){
		if (followers.contains(account)){
			return true;
		}
		return false;
	}
	
	public void tweet(String tweeten){
		Tweet tweet1 = new Tweet(this, tweeten);
		NumberOfTweets += 1;
		tweets.add(tweet1);
	}
	
	public void retweet(Tweet tweeten){
		Tweet tweet1 = new Tweet(this, tweeten);
		NumberOfRetweets += 1;
		NumberOfTweets += 1;
		tweets.add(tweet1);
	}
	
	public Tweet getTweet(int i){
		int index = tweets.size()-i;
		return tweets.get(index);
	}
	
	public int getTweetCount(){
		return NumberOfTweets;
	}
	
	public int getRetweetCount(){
		return NumberOfRetweets;
	}

	
	
	
	
	
}
