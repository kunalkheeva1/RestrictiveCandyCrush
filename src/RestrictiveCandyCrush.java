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

        Stack<Pair> stack = new Stack<>();
      for(int i=0; i<s.length(); i++){


        if(stack.isEmpty()){
            Pair pair = new Pair(s.charAt(i), 1);
            stack.push(pair);
        }
        else{
            if(stack.peek().ch != s.charAt(i)){
                Pair pair = new Pair(s.charAt(i), 1);
                stack.push(pair);
            }else{
                int frequency = stack.peek().freq;
                frequency = frequency+1;

                if(frequency != k){
                    Pair pair = new Pair(s.charAt(i), frequency);
                    stack.push(pair);
                }else{
                    frequency --;
                    while(frequency>0){
                        stack.pop();
                        frequency--;
                    }
                }
            }
        }










    }StringBuilder ans = new StringBuilder();
      ans =ans.append(stack.pop().ch);
      StringBuilder ans2 = new StringBuilder();
      ans2 = ans.reverse();
      return ans2.toString();
    }






    public static void main(String[] args) {

    }
}
