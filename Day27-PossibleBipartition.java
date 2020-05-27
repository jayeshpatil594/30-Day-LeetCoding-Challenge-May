class Solution {
    
    public boolean possibleBipartition(int N, int[][] dislikes) {
                
        //BFS
        // Time : O(N + D) Space: O(N + D)
        List<Integer> adj[] = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<Integer>();
        }
        //create a graph of dislike edges
        for(int[] d : dislikes){
            adj[d[0]].add(d[1]);
            adj[d[1]].add(d[0]);
        }
        int[] color = new int[N + 1];
        
        for(int i = 1; i <= N; i++){
            if(color[i] == 0){
                color[i] = 1;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                while(!queue.isEmpty()){
                    int curr = queue.poll();
                    for(int neighbor : adj[curr]){
                        if(color[neighbor] == 0){
                            color[neighbor] = color[curr] == 1 ? -1 : 1;
                            queue.add(neighbor);
                        }
                        else if(color[curr] == color[neighbor]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
        
        /*
        //DFS
        //Time : O(N + D) Space : O(N + D)
        List<Integer> adj[] = new ArrayList[N + 1];
        Map<Integer,Integer> color = new HashMap<>();
        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<Integer>();
        }
        //create a graph of dislike edges
        for(int[] d : dislikes){
            adj[d[0]].add(d[1]);
            adj[d[1]].add(d[0]);
        }
        for(int i = 1; i <= N; i++){
            if(!color.containsKey(i) && !dfs(i, 0, adj, color)){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int node, int c, List<Integer> adj[], Map<Integer, Integer> color){
        if(color.containsKey(node)){
            return color.get(node) == c;         
        }
        
        color.put(node, c);
        
        for(int neighbor : adj[node]){
            // 0 ^ 1 = 1, 1 ^ 1 = 0
            //color adjacent with other color
            if(!dfs(neighbor, c ^ 1, adj, color)){
                return false;
            }
        }
        return true;*/

    }
}
