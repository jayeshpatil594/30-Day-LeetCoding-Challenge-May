class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
    // Slope of three points should be equal : (y - y1) / (x - x1) = (y1 - y0) / (x1 - x0)
    // where Point1: (x0, y0) Point2: (x1, y1) Point3: (x , y)
        if(coordinates.length == 2){
            return true;
        }
        int x0 = coordinates[0][0];
        int x1 = coordinates[1][0];
        int y0 = coordinates[0][1];
        int y1 = coordinates[1][1];
        
        int dx = x1 - x0;
        int dy = y1 - y0;
        
        for(int[] arr : coordinates){
            int x = arr[0];
            int y = arr[1];
            
            if(dx * (y1 - y) != dy * (x1 - x)){
                return false;
            }
        }
        return true;
    }
}
