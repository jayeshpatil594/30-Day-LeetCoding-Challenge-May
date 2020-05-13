class Solution {
    public String removeKdigits(String num, int k) {
        //greedy Time: O(n) Space:O(n)
        if(k == num.length()){
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while(i < num.length()){
            // if we find a smaller number than the current top of stack we remove the top
            //eg: if our stack is : 1 5 and next number is 4 so we remove 5 and take 4 so now stack is: 1 4
            while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }
        //for cases where there are repeating numbers eg 2222, the above algo will fail so
        // we just remove k numbers.
        while(k > 0){
            stack.pop();
            k--;
        }
        //cuz we need to return a string.
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            char curr = stack.pop();
            sb.append(curr);
        }
        sb.reverse();
        // remove leading zeros
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
