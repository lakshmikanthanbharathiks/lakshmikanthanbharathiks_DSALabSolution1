package com.greatlearning.BalancedOrUnbalancedBrackets.Model;
import java.util.*;
public class Main 
{
	public static boolean checkForBalanced(String expr)
    {
        Deque<Character> parenthesisStack = new ArrayDeque<Character>();
 
        for (int i = 0; i < expr.length(); i++)
        {
            char symbol = expr.charAt(i);
 
            if (symbol == '(' || symbol == '[' || symbol == '{')
            {
                parenthesisStack.push(symbol);
                continue;
            }
 
            if (parenthesisStack.isEmpty())
                return false;
            char checkSymbol;
            switch (symbol) {
            case ')':
                checkSymbol = parenthesisStack.pop();
                if (checkSymbol == '{' || checkSymbol == '[')
                    return false;
                break;
 
            case '}':
                checkSymbol = parenthesisStack.pop();
                if (checkSymbol == '(' || checkSymbol == '[')
                    return false;
                break;
 
            case ']':
                checkSymbol = parenthesisStack.pop();
                if (checkSymbol == '(' || checkSymbol == '{')
                    return false;
                break;
            }
        }
        return (parenthesisStack.isEmpty());
    }
 
    // Driver code
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        String expr = sc.nextLine();
        if (checkForBalanced(expr))
            System.out.println("\nThe entered String has Balanced Brackets");
        else
            System.out.println("\nThe entered Strings do not contain Balanced Brackets");
    }
}
