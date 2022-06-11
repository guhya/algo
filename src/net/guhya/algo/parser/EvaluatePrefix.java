package net.guhya.algo.parser;

import java.util.Arrays;
import java.util.LinkedList;

public class EvaluatePrefix {
    
    public static int evaluate(LinkedList<String> expr) {
        LinkedList<String> stack = new LinkedList<>();
        while (!expr.isEmpty()) {
            String el = expr.removeLast();
            int op1, op2, r;
            switch (el) {
                case "*" :
                    op1 = Integer.parseInt(stack.removeLast());
                    op2 = Integer.parseInt(stack.removeLast());
                    r = op1 * op2;
                    stack.add(String.valueOf(r));
                    break;
                    
                case "/" :
                    op1 = Integer.parseInt(stack.removeLast());
                    op2 = Integer.parseInt(stack.removeLast());
                    r = op1 / op2;
                    stack.add(String.valueOf(r));
                    break;
                    
                case "+" :
                    op1 = Integer.parseInt(stack.removeLast());
                    op2 = Integer.parseInt(stack.removeLast());
                    r = op1 + op2;
                    stack.add(String.valueOf(r));
                    break;
                    
                case "-" :
                    op1 = Integer.parseInt(stack.removeLast());
                    op2 = Integer.parseInt(stack.removeLast());
                    r = op1 - op2;
                    stack.add(String.valueOf(r));
                    break;
                    
                default:
                    stack.add(el);
                    break;
            }
        }
        
        return Integer.parseInt(stack.removeLast());
    }

    public static void main(String[] args) {
        String[] expr = {"-", "+", "*", "2", "3", "+", "5", "4", "9"};
        int r = evaluate(new LinkedList<>(Arrays.asList(expr)));
        System.out.println(r);        
    }

}
