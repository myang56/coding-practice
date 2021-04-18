class RandomizedSet {
    
    Map<Integer, Integer> map; // value -- index
    List<Integer> nums;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        nums = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        
        if (!map.containsKey(val)) {
           return false; 
        }
        int index = map.get(val);
        if (index != nums.size() - 1) {
            int lastVal = nums.get(nums.size() - 1);
            nums.set(index, lastVal);
            map.put(lastVal, index);
        }
        map.remove(val);
        nums.remove(nums.size() - 1); // O(1)
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        
        int index = rand.nextInt(nums.size());
        return nums.get(index);
    }
}