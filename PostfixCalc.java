import java.util.Stack;
public class PostfixCalc {
    public static int evaluatePostfix(String expression) {
        Stack<Integer> pile = new Stack<>();
        String str = "";
        for (char ch : expression.toCharArray()){
            if  (ch >= 0 && ch <= 9){ //Adds to new string to later convert to integer
                str += ch;
            }
            if(ch == '+'){
                //TODO
            }
            if(ch == '-'){
                //TODO
            }
            if(ch == '*'){
                //TODO
            }
            if(ch == '/' || ch == '%'){
                //TODO
            }
            //Pushes to stack when white space is present or skips if str is empty
            if (ch == ' '){
                if (str.length() == 0) { //str has no characters to push
                    continue;
                }
                try{
                    pile.push(Integer.parseInt(str)); //converts str to int and pushes it to the stack
                }catch(Exception e){
                    System.out.println("Error cannot convert to Integer");
                }
            }
        }
        //TODO
        return pile.pop();
    }
    public static void main(String[] args){
        String expression1 = "4 2 * 3 +";
        int result = evaluatePostfix(expression1);
        System.out.println("Result 1: " + result);
    }
}
