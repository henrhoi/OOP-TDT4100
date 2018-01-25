package oving6;

import oving6.TwitterAccount;


public class Tweet {
	
	private TwitterAccount twitterAccount;
	private Tweet originalTweet;
	private boolean isRetweet;
	private int beenRetweeted = 0;
	private String tweet;
	
	public Tweet(TwitterAccount twitterAccount, String tweet){
		this.tweet = tweet;
		this.twitterAccount = twitterAccount;
		isRetweet = false;
	}
	
	public Tweet(TwitterAccount twitterAccount, Tweet retweet){
		if (retweet.twitterAccount.equals(twitterAccount)){
			throw new IllegalArgumentException("Kan ikke retweete en egen tweet");
		}
		tweet = retweet.tweet;
		retweet.beenRetweeted += 1;
		originalTweet = retweet;
		this.twitterAccount = twitterAccount;
		isRetweet = true;
	}
	
	public String getText(){
		return tweet;
	}
	
	public TwitterAccount getOwner(){
		return twitterAccount;
	}
	
	public Tweet getOriginalTweet(){
		if (isRetweet == true){
			return originalTweet;
		}
		return null;
	}

	public int getRetweetCount(){
		return beenRetweeted;
	}
}
