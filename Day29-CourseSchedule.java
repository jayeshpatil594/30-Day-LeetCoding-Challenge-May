class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Time : O(V + E) Space: O(V + E)
        if(numCourses == 0 || prerequisites.length == 0 || prerequisites == null){
            return true;
        }
        //arraylist graph to represent the courses.
        List<List<Integer>> courses = new ArrayList<List<Integer>>(numCourses);
        
        for(int i = 0; i < numCourses; i++){
            courses.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            //create a dependency graph
            courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] visited = new int[numCourses];
         // dfs visit each course
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, visited, courses)){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int course, int[] visited, List<List<Integer>> courses){
        // mark it being visited
        visited[course] = 1;
        // get its children
        List<Integer> eligibleCourses = courses.get(course);
        // dfs its children
        for(int i = 0; i < eligibleCourses.size(); i++){
            int eligibleCourse = eligibleCourses.get(i);
            // has been visited while visiting its children - cycle !
            if(visited[eligibleCourse] == 1){
                return false;
            }
            // not visited
            if(visited[eligibleCourse] == 0){
                if(!dfs(eligibleCourse, visited, courses)){
                    return false;
                }
            }
        }
        // mark it done visiting
        //runtime 2ms with this line
        visited[course] = 2;
        //runtime 59ms with this line
        //visited[course] = 0;
        return true;
    }
}
