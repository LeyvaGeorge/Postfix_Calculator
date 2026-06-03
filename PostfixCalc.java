import java.util.Stack;
public class PostfixCalc {
    public static int evaluatePostfix(String expression) {
        Stack<Integer> pile = new Stack<>();
        String str = "";
        for (char ch : expression.toCharArray()){
            if  (ch >= '0' && ch <='9'){ //Adds to new string to later convert to integer
                str += ch;
            }
            if(ch == '+'){
                int x = pile.pop();
                try{
                    int y = pile.pop();
                    pile.push(x + y);
                }catch(Exception e){
                    System.out.println("Error at addition");
                }
            }
            if(ch == '-'){
                int x = pile.pop();
                try{
                    int y = pile.pop();
                    pile.push(x - y);
                } catch(Exception e) {
                    System.out.println("Error at subtraction");
                }
            }
            if(ch == '*'){
                int x = pile.pop();
                try{
                    int y = pile.pop();
                    pile.push(x * y);
                } catch(Exception e) {
                    System.out.println("Error at multiplication");
                }
            }
            if(ch == '/' || ch == '%'){
                int x = pile.pop();
                try{
                    int y = pile.pop();
                    x = x / y;
                    pile.push(x);
                } catch(Exception e) {
                    System.out.println("Error at division");
                }
            }
            //Pushes to stack when white space is present or skips if str is empty
            if (ch == ' '){
                if (str.length() == 0) { //str has no characters to push
                    continue;
                }
                try{
                    pile.push(Integer.parseInt(str)); //converts str to int and pushes it to the stack
                    str = "";
                }catch(Exception e){
                    System.out.println("Error cannot convert to Integer");
                }
            }
        }
        //If stack contains more than ine que
        if(pile.size()>1){
            throw new IllegalArgumentException("Stack has more than one element in queue");
        }
        return pile.pop();
    }
    public static void main(String[] args){
        String expression1 = "2 3 18 / *";
        int result = evaluatePostfix(expression1);
        System.out.println("Result 1: " + result);

        String expression2 = "4 12 - 5 *";
        result = evaluatePostfix(expression2);
        System.out.println("Result 2: " + result);

        String expression3 = "9 2 1 10 + %";
        result = evaluatePostfix(expression3);
        System.out.println("Result 3: " + result);
    }
}
