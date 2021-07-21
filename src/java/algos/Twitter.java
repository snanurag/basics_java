package algos;

import java.util.*;

class Twitter {

    Map<Integer, Set<Integer>> followersMap = new HashMap<>();
    Map<Integer, List<Integer>> notification = new HashMap<>();
    Map<Integer,List<Integer>> selfPost = new HashMap<>();

    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        List<Integer> self = selfPost.get(userId);
        if (self == null){
            self = new ArrayList<>();
            selfPost.put(userId, self);
        }

        Set<Integer> followers = followersMap.get(userId);

        if(followers == null){
            followers = new HashSet<>();
            followersMap.put(userId, followers);
        }

        if(self.size() == 10){
            Integer e = self.remove(0);
            for (Integer follower: followers){
                List<Integer> l = notification.get(follower);
                if(l == null){
                    l = new ArrayList<>();
                    notification.put(follower, l);
                }
                l.remove(new Integer(e));
            }
        }

        self.add(tweetId);
        for (Integer follower: followers){
            List<Integer> l = notification.get(follower);
            if(l == null){
                l = new ArrayList<>();
                notification.put(follower, l);
            }
            l.add(tweetId);
        }

        List<Integer> l = notification.get(userId);
        if(l == null){
            l = new ArrayList<>();
            notification.put(userId, l);
        }
        l.add(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> finalList = new ArrayList<>();

        List<Integer> l = notification.get(userId);

        if(l == null){
            return new ArrayList<>();
        }

        int totalNotifications = l.size();
        int uptoIndex =0;
        if(totalNotifications > 10){
            uptoIndex = totalNotifications - 10;
        }

        for(int i = l.size()-1; i>= uptoIndex ; i--){
            finalList.add(l.get(i));
        }

        return finalList;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> followers = followersMap.get(followeeId);
        if(followers == null){
            followers = new HashSet<>();
            followersMap.put(followeeId, followers);
        }
        if(!followers.contains(followerId)){
            followers.add(followerId);
            List<Integer> posts = selfPost.get(followeeId);
            if(posts == null){
                return;
            }
            List<Integer> followersNotification = notification.get(followerId);
            if(followersNotification == null){
                followersNotification = new ArrayList<>();
                notification.put(followerId,followersNotification );
            }
            followersNotification.addAll(posts);
        }


    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followers = followersMap.get(followeeId);
        if(followers == null){
            return;
        } else{
            followers.remove(followerId);
            List<Integer> followeePosts = selfPost.get(followeeId);
            if(followeePosts == null){
                return;
            }
            List<Integer> followersNotificationList = notification.get(followerId);
            if(followersNotificationList == null){
                return;
            }

            for(Integer i : followeePosts){
                followersNotificationList.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should
    }
}