public class RandomizedSet {
    private HashMap<Integer, Integer> numMap;
    private int size;

    public RandomizedSet() {
        numMap = new HashMap<>();
        size = 0;
    }

    public boolean insert(int val) {
        if (numMap.containsKey(val)) {
            return false;
        }
        numMap.put(val, 1);
        size++;
        return true;
    }

    public boolean remove(int val) {
        if (!numMap.containsKey(val)) {
            return false;
        }
        numMap.remove(val);
        size--;
        return true;
    }

    public int getRandom() {
        int idx = new Random().nextInt(size);
        Iterator<Integer> it = numMap.keySet().iterator();
        while (idx-- > 0) {
            it.next();
        }
        return it.next();
    }
}