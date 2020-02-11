package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Twitter {

	/** Initialize your data structure here. */
	private LinkedHashMap<Integer, Integer> userTweets;
	private HashMap<Integer, List<Integer>> userRelation;//key follower, value followee
    public Twitter() {
        userTweets = new LinkedHashMap();
        userRelation = new HashMap();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        userTweets.put(tweetId, userId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new LinkedList();
        
        for(Map.Entry<Integer, Integer> map: this.userTweets.entrySet()) {
        	if(map.getValue() == userId) {
        		ans.add(map.getKey());
        	}
        	//check following tweets
        	if(this.userRelation.containsKey(userId) && this.userRelation.get(userId).contains(map.getValue())) {
        		ans.add(map.getKey());
        	}
		}
        
        List<Integer> output = new LinkedList();
        for(int i=ans.size()-1;i>=0;i--) {
        	if(!output.contains(ans.get(i)) && output.size()<10)
        		output.add(ans.get(i));
        }
        return output;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        userRelation.putIfAbsent(followerId, new ArrayList());
        List<Integer> l1 = userRelation.get(followerId);
        l1.add(followeeId);
        userRelation.put(followerId, l1);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId){
            return;
        }
        if(!userRelation.containsKey(followerId) || !userRelation.get(followerId).contains(followeeId)) {
        	return;
        }
        List<Integer> l1 = userRelation.get(followerId);
        for(int i=0;i<l1.size();i++) {
        	if(l1.get(i)==followeeId) {
        		l1.remove(i);
        		break;
        	}
        }
        userRelation.put(followerId, l1);
    }

}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
