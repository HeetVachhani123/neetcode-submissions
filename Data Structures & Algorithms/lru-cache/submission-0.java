
class LRUCache {
    
    // Doubly Linked List Node to track the usage order
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        
        // Initialize dummy head and tail to avoid edge cases with null pointers
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node node = map.get(key);
        // Move the accessed node to the head (Most Recently Used)
        moveToHead(node);
        
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value; // Update value
            moveToHead(node);   // Mark as Most Recently Used
        } else {
            Node newNode = new Node(key, value);
            
            // If capacity is reached, evict the Least Recently Used item
            if (map.size() >= capacity) {
                Node lruNode = tail.prev;
                removeNode(lruNode);
                map.remove(lruNode.key);
            }
            
            // Add new node to map and list
            map.put(key, newNode);
            addToHead(newNode);
        }
    }
    
    // Helper method to remove a node from its current position in the list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    // Helper method to insert a node right after the dummy head
    private void addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    // Helper method to move an existing node to the head position
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
}