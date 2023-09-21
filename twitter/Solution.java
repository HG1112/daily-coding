import java.util.*;

class Twitter {

  private class Tweet {
    int tweetId;
    int userId;
    int timestamp;
    Tweet(int uid, int tid, int t) {
      userId = uid;
      tweetId = tid;
      timestamp = t;
    }
  }

  private class User {
    int userId;
    List<Tweet> posts;
    Set<User> follows;

    User(int userId) {
      this.userId = userId;
      posts = new LinkedList<>();
      follows = new HashSet<>();
      follows.add(this);
    }

    private void add(User user) {
      follows.add(user);
    }

    private void remove(User user) {
      follows.remove(user);
    }

    void retrieve(PriorityQueue<Tweet> pq, int n) {
      for (Tweet tweet: posts) {
        pq.offer(tweet);
        if (pq.size() > n) pq.remove();
      }
    }

    void post(Tweet tweet) {
      posts.add(tweet);
    }
  }

  int time;
  Map<Integer, User> users;
  public Twitter() {
    time = 0;
    users = new HashMap<>();
  }

  public void postTweet(int userId, int tweetId) {
    users.putIfAbsent(userId, new User(userId));
    users.get(userId).post(new Tweet(userId, tweetId, ++time));
  }

  public List<Integer> getNewsFeed(int userId) {
    List<Integer> ans = new LinkedList<>();
    PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b) -> (a.timestamp - b.timestamp));
    users.putIfAbsent(userId, new User(userId));
    for (User f: users.get(userId).follows) {
      f.retrieve(pq, 10);
    }
    while (!pq.isEmpty()) ans.add(0, pq.remove().tweetId);
    return ans;
  }

  public void follow(int followerId, int followeeId) {
    users.putIfAbsent(followeeId, new User(followeeId));
    users.putIfAbsent(followerId, new User(followerId));
    users.get(followerId).add(users.get(followeeId));
  }

  public void unfollow(int followerId, int followeeId) {
    users.putIfAbsent(followeeId, new User(followeeId));
    users.putIfAbsent(followerId, new User(followerId));
    users.get(followerId).remove(users.get(followeeId));
  }
}


