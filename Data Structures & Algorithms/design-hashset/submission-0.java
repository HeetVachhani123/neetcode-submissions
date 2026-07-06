class MyHashSet {
    private static final int BASE = 769;
    private LinkedList<Integer>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        buckets = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    private int hash(int key) {
        return key % BASE;
    }
    
    public void add(int key) {
        int bucketIdx = hash(key);
        if (!buckets[bucketIdx].contains(key)) {
            buckets[bucketIdx].addFirst(key);
        }
    }
    
    public void remove(int key) {
        int bucketIdx = hash(key);
        // Cast to Integer object so it removes by value, not by index reference
        buckets[bucketIdx].remove((Integer) key);
    }
    
    public boolean contains(int key) {
        int bucketIdx = hash(key);
        return buckets[bucketIdx].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */