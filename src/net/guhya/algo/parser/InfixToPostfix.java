package net.guhya.algo.parser;

import java.util.Arrays;
import java.util.LinkedList;

public class InfixToPostfix {

    public static LinkedList<String> convert(LinkedList<String> expr) {
        LinkedList<String> stack = new LinkedList<>();
        LinkedList<String> result = new LinkedList<>();
        for (String el : expr) {
            switch (el) {
                case "(" :
                    stack.add(el);
                    break;
                    
                case ")" :
                    while (!stack.isEmpty() && !stack.peekLast().equals("(")) {
                        result.add(stack.removeLast());
                    }
                    if (!stack.isEmpty()) stack.removeLast();
                    break;
                    
                case "*" :
                    popStack(stack, el, result);
                    break;
                    
                case "/" :
                    popStack(stack, el, result);
                    break;
                    
                case "+" :
                    popStack(stack, el, result);
                    break;
                    
                case "-" :
                    popStack(stack, el, result);
                    break;
                    
                default:
                    result.add(el);
                    break;
            }
        }
        
        while(!stack.isEmpty()) result.add(stack.removeLast());
        
        return result;
    }
    
    private static void popStack(LinkedList<String> stack, String el, LinkedList<String> result) {
        while (!stack.isEmpty() && !isHigherPriority(stack, el)) {
            String top = stack.removeLast();
            result.add(top);
        }
        
        stack.add(el);
    }

    private static boolean isHigherPriority(LinkedList<String> stack, String operator) {
        if (stack.isEmpty()) return true;
        String el = stack.peekLast();
        if (el.equals("(")) return true;
        
        if ("*".equals(operator) || "/".equals(operator)) {
            if ("*".equals(el) || "/".equals(el)) 
                return false;
            else
                return true;
        } else {
            return false;
        }
    
    }
    
    public static void main(String[] args) {
        String[] expr = {"1", "+", "2", "*", "3", "-", "1", "*", "2"};
        LinkedList<String> r = convert(new LinkedList<>(Arrays.asList(expr)));
        System.out.println(r);
        
        int calc = EvaluatePostfix.evaluate(r);
        System.out.println(calc);
        
        String[] expr2 = {"1", "*", "(", "2", "+", "3", ")"};
        LinkedList<String> r2 = convert(new LinkedList<>(Arrays.asList(expr2)));
        System.out.println(r2);
        
        int calc2 = EvaluatePostfix.evaluate(r2);
        System.out.println(calc2);
        
        String[] expr3 = {"1", "*", "(", "2", "+", "(", "3", "/", "1", ")", ")"};
        LinkedList<String> r3 = convert(new LinkedList<>(Arrays.asList(expr3)));
        System.out.println(r3);
        
        int calc3 = EvaluatePostfix.evaluate(r3);
        System.out.println(calc3);
        
    }

}
