import java.util.Stack;

public class RestrictiveCandyCrush {

    static class Pair{
        char ch;
        int freq;
        Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    public static String reduced_String(int k, String s){
        if(k==1) return "";

        // initialize a stack of pairs
        Stack<Pair> stack = new Stack<>();

        // loop till the end of the string
      for(int i=0; i<s.length(); i++){

        // if stack is empty then add the character with frequency 1
        if(stack.isEmpty()){
            Pair pair = new Pair(s.charAt(i), 1);
            stack.push(pair);
        }
        //else
        else{
            // if the element in the stack is not same then add that too
            if(stack.peek().ch != s.charAt(i)){
                Pair pair = new Pair(s.charAt(i), 1);
                stack.push(pair);
            }
            // if element is same and stack is not empty then increment the frequency
            else
            {
                int frequency = stack.peek().freq;
                frequency = frequency+1;
                // but if the frequency is not equals to k limit, then add the pair with incremented frequency
                if(frequency != k){
                    Pair pair = new Pair(s.charAt(i), frequency);
                    stack.push(pair);
                }// otherwise decrement the frequency and delete that element until its frequency gets 0
                else
                {
                    frequency --;           // idk why did we do this, as we are doing same thing in loop
                    while(frequency>0){
                        stack.pop();
                        frequency--;
                    }
                }
            }
        }










    }// append the elements in string builder and then reverse it to get the ans as stack is FILO
      StringBuilder ans = new StringBuilder();
      ans =ans.append(stack.pop().ch);
      StringBuilder ans2 = new StringBuilder();
      ans2 = ans.reverse();
      return ans2.toString();
    }






    public static void main(String[] args) {

    }
}
