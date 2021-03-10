class MyCalendarThree {

    TreeMap<Integer, Integer> booked;
    
    public MyCalendarThree() {
        booked = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        
        booked.put(start, booked.getOrDefault(start, 0) + 1);
        booked.put(end, booked.getOrDefault(end, 0) - 1);
        
        int activeEvents = 0;
        int res = 0;
        for (int freq : booked.values()) {
    
            activeEvents += freq;
            res = Math.max(res, activeEvents);
        }
        return res;
    }
}