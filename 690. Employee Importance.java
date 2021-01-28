/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
        // build the id-employee map, then bfs
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        int res = 0;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            Employee currEmployee = map.get(curr);
            res += currEmployee.importance;
            
            for (int next : currEmployee.subordinates) {
                queue.offer(next);
            }
        }
        return res;
    }
}