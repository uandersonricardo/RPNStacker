import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import Token;
import TokenType;

public class RPNStacker {
    public static void main(String[] args) {
        try {
            List<Token> tokens = scan("Calc1.stk");
            Stack<String> stack = new Stack<String>();

            while (!tokens.isEmpty()) {
                Token token = tokens.remove(0);

                System.out.println(token);

                if (token.type != TokenType.NUM) {
                    String op1 = stack.pop();
                    String op2 = stack.pop();

                    int result = 0;
                    
                    switch (token.type) {
                        case PLUS:
                            result = Integer.parseInt(op2) + Integer.parseInt(op1);
                            break;
                        case MINUS:
                            result = Integer.parseInt(op2) - Integer.parseInt(op1);
                            break;
                        case STAR:
                            result = Integer.parseInt(op2) * Integer.parseInt(op1);
                            break;
                        case SLASH:
                            result = Integer.parseInt(op2) / Integer.parseInt(op1);
                            break;
                        default:
                            break;
                    }

                    stack.push(String.valueOf(result));
                } else {
                    stack.push(token.lexeme);
                }
            }

            System.out.println(stack.pop());
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Não foi possível calcular a operação");
        }
    }

    private static List<Token> scan(String filename) throws FileNotFoundException {
        File file = new File(filename);

        Scanner scan = new Scanner(file);
        List<Token> tokens = new ArrayList<Token>();

        while (scan.hasNextLine()) {
            String line = scan.nextLine().trim();

            Token token;

            if (line.equals("+")) {
                token = new Token(TokenType.PLUS, line);
            } else if (line.equals("-")) {
                token = new Token(TokenType.MINUS, line);
            } else if (line.equals("*")) {
                token = new Token(TokenType.STAR, line);
            } else if (line.equals("/")) {
                token = new Token(TokenType.SLASH, line);
            } else if (line.matches("[0-9]+")) {
                token = new Token(TokenType.NUM, line);
            } else {
                scan.close();

                throw new RuntimeException("Token inválido: " + line);
            }
            
            tokens.add(token);
        }

        scan.close();

        return tokens;
    }
}