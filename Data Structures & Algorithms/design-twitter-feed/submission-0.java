class Twitter {

    private static int timeStamp = 0;

    private class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id) {
            this.id = id;
            this.time = timeStamp++;
            this.next = null;
        }
    }

    private class User {
        int id;
        Set<Integer> followed;
        Tweet head;

        User(int id) {
            this.id = id;
            this.followed = new HashSet<>();
            follow(id);
        }

        void follow(int id) {
            followed.add(id);
        }

        void unfollow(int id) {
            if (id != this.id) {
                followed.remove(id);
            }
        }

        void post(int id) {
            Tweet t = new Tweet(id);
            t.next = head;
            head = t;
        }
    }

    private Map<Integer, User> userMap;

    public Twitter() {
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return result;
        }

        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);

        for (int u : users) {
            User user = userMap.get(u);
            if (user != null && user.head != null) {
                maxHeap.add(user.head);
            }
        }

        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            Tweet t = maxHeap.poll();
            result.add(t.id);
            count++;
            if (t.next != null) {
                maxHeap.add(t.next);
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId) {
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }
}