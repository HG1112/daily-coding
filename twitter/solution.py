from typing import List
from heapq import heappop, heappush, heapify
class Tweet:
    def __init__(self, userId, tweetId, timestamp) -> None:
        self.userId = userId
        self.tweetId = tweetId
        self.timestamp = timestamp


class User:
    def __init__(self, id) -> None:
        self.posts = []
        self.follows = set()
        self.id = id
        self.follow(self)

    def follow(self, user):
        self.follows.add(user)
    def unfollow(self, user):
        if user in self.follows:
            self.follows.remove(user)

    def post(self, tweet):
        self.posts.append(tweet)

    def retrieve(self, heap):
        for post in self.posts:
            heappush(heap, [-post.timestamp, post])

class Twitter:

    def __init__(self):
        self.users = {}
        self.time = 0
        

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.time += 1
        if userId not in self.users:
            self.users[userId] = User(userId)
        user = self.users[userId]
        user.post(Tweet(userId, tweetId, self.time))

        

    def getNewsFeed(self, userId: int) -> List[int]:
        ans = []
        heapify(ans)
        if userId not in self.users:
            self.users[userId] = User(userId)
        for user in self.users[userId].follows:
            user.retrieve(ans)
        return [ heappop(ans)[1].tweetId for _ in range(10) if ans]
        

    def follow(self, followerId: int, followeeId: int) -> None:
        userId = followeeId
        if userId not in self.users:
            self.users[userId] = User(userId)
        userId = followerId
        if userId not in self.users:
            self.users[userId] = User(userId)
        follower = self.users[followerId]
        followee = self.users[followeeId]
        follower.follow(followee)


    def unfollow(self, followerId: int, followeeId: int) -> None:
        userId = followeeId
        if userId not in self.users:
            self.users[userId] = User(userId)
        userId = followerId
        if userId not in self.users:
            self.users[userId] = User(userId)
        follower = self.users[followerId]
        followee = self.users[followeeId]
        follower.unfollow(followee)

