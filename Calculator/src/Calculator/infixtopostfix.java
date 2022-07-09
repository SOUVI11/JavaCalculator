package Calculator;
import java.util.Scanner;
import java.util.Stack;
import java.util.Hashtable;

public class infixtopostfix {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.close();

        Stack<Character> stack = new Stack<>();

        Hashtable<Character, Integer> priority = new Hashtable<>();

        priority.put('(', 0);// ignore
        priority.put(')', 1);
        priority.put('+', 2);
        priority.put('-', 2);
        priority.put('*', 3);
        priority.put('/', 3);
        priority.put('^', 4);// high priority

        System.out.println("Enter the infix expression: ");
        String s = sc.next();

        char[] output = new char[s.length()];
        int h = 0;

        for (int i = 0; i < s.length(); i++) {

            if (Character.isAlphabetic(s.charAt(i))) {
                output[h++] = s.charAt(i);
            }

            else if (stack.isEmpty()) {// stack empty condition
                stack.push(s.charAt(i));
            }

            else if (s.charAt(i) == '(') {// bracket
                stack.push(s.charAt(i));
            }

            else if (priority.get(s.charAt(i)) == 1) { // closing bracket handling
                while (true) {
                    if (stack.peek() == '(') {
                        stack.pop();
                        break;// ( means break condition)
                    } else {
                        output[h++] = stack.pop();// poping till (

                    }
                }
            }

            else if (priority.get(s.charAt(i)) == 4 && priority.get(stack.peek()) == 4) {// for exponential double
                                                                                         // handling
                stack.push(s.charAt(i));
            }

            else {
                do {
                    if (priority.get(stack.peek()) > priority.get(s.charAt(i))) {// top of stack having higher priority
                                                                                 // than incoming
                        output[h] = stack.pop();// pop old and push new
                        h++;
                        break;
                    } else if (priority.get(stack.peek()) < priority.get(s.charAt(i))) {
                        break;// here we just push, as new one has higher priority
                    } else if (priority.get(stack.peek()) == priority.get(s.charAt(i))) {
                        output[h] = stack.pop();// equal priority, we pop and push
                        h++;
                        break;
                    }
                } while (!stack.isEmpty());

                stack.push(s.charAt(i));
            }
        }
        // if none of abv satisfies, no more char left, hence pop everything

        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                output[h] = stack.pop();
                h++;
            }
        }

        for (int i = 0; i < h; i++) {
            System.out.print(output[i] + "");
        }


    }
}