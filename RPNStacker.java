import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class RPNStacker {
    public static void main(String[] args) {
        File file = new File("Calc1.stk");

        try {
            Scanner scan = new Scanner(file);
            Stack<String> stack = new Stack<String>();
    
            while (scan.hasNextLine()) {
                String token = scan.nextLine();

                if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                    String op1 = stack.pop();
                    String op2 = stack.pop();

                    int result = 0;
                    
                    switch (token) {
                        case "+":
                            result = Integer.parseInt(op2) + Integer.parseInt(op1);
                            break;
                        case "-":
                            result = Integer.parseInt(op2) - Integer.parseInt(op1);
                            break;
                        case "*":
                            result = Integer.parseInt(op2) * Integer.parseInt(op1);
                            break;
                        case "/":
                            result = Integer.parseInt(op2) / Integer.parseInt(op1);
                            break;
                    }

                    stack.push(String.valueOf(result));
                } else {
                    stack.push(token);
                }
            }

            System.out.println(stack.pop());

            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
        } catch (Exception e) {
            System.out.println("Não foi possível calcular a operação");
        }
    }
}