class LogSystem {

    // leetcode dis 
    List<String[]> db;
    Map<String, Integer> map;
    
    public LogSystem() {
        db = new ArrayList();
        map = new HashMap();
        map.put("Year", 4);
        map.put("Month", 7);
        map.put("Day", 10);
        map.put("Hour", 13);
        map.put("Minute", 16);
        map.put("Second", 19);
    }
    
    public void put(int id, String timestamp) {
        db.add(new String[]{String.valueOf(id), timestamp});
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        
        int index = map.get(gra);
        List<Integer> res = new ArrayList();
        
        for (String[] info : db) {
            
            String timestamp = info[1];
            
            if (timestamp.substring(0, index).compareTo(s.substring(0, index)) >= 0 &&
              timestamp.substring(0, index).compareTo(e.substring(0, index)) <= 0) {
                res.add(Integer.valueOf(info[0]));
            }
        }
        return res;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */