class SnapshotArray {
    
    
    // set() O(logN)
    // get() O(logN)
    // snap() O(1)
    // space O(n + m) n : the length of array, m: times of modifications

    private List<TreeMap<Integer, Integer>> map; // each index --> snap history (treemap) -> treemap to store snapId(version) and value
    private int snapId; //version
    
    public SnapshotArray(int length) {
        snapId = 0;
        map = new ArrayList<>();
        
        for (int i = 0; i < length; i++) {
            map.add(new TreeMap<>());
            map.get(i).put(0, 0); // each index, initialize value to 0
        }
    }
    
    public void set(int index, int val) {
        map.get(index).put(snapId, val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        //得到小于等于这个snap_id 对应的值
        return map.get(index).floorEntry(snap_id).getValue();
    }
}