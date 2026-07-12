class MyHashMap {
    private static class Node {
        int key;
        int value;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private static final int BASE = 769;
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[BASE];
    }
    
    private int hash(int key) {
        return key % BASE;
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new Node(-1, -1);
        }
        
        Node prev = findElement(buckets[index], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int index = hash(key);
        if (buckets[index] == null) {
            return -1;
        }
        
        Node prev = findElement(buckets[index], key);
        return prev.next == null ? -1 : prev.next.value;
    }
    
    public void remove(int key) {
        int index = hash(key);
        if (buckets[index] == null) {
            return;
        }
        
        Node prev = findElement(buckets[index], key);
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }
    
    private Node findElement(Node bucketHead, int key) {
        Node curr = bucketHead;
        Node prev = null;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */