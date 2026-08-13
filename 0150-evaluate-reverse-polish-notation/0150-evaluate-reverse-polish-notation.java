class Solution {
    public int evalRPN(String[] tokens) {
      Stack<Integer> st=new Stack<>();
      for(String token:tokens){
        if(token.equals("+") || token.equals("-") ||token.equals("*") ||token.equals("/")) {
            int a=st.pop();
            int b=st.pop();

            int result=0;
            if(token.equals("+")) result=a+b;
            if(token.equals("-")) result=b-a;
            if(token.equals("*")) result=a*b;
            if(token.equals("/")) result=b/a;
            st.push(result);
        }
        else st.push(Integer.parseInt(token));
      }  
      return st.peek();
    }
}