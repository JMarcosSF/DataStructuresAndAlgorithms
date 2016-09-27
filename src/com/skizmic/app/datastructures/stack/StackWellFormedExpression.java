package com.skizmic.app.datastructures.stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StackWellFormedExpression {
	// For a test implementation, implement a "match parenthesis" program
	private static final Map<Character, Character> matchingParenMap = new HashMap<>();
	private static final Set<Character> openingParenSet = new HashSet<>();
	
	static{
		matchingParenMap.put(')', '(');
		matchingParenMap.put('}', '{');
		matchingParenMap.put(']', '[');
		openingParenSet.addAll(matchingParenMap.values());
	}
	
    public static void main(String[] args) {
    	
        System.out.println(String.format(
                "Has matching parens %s? : %s", "(abcd)", hasMatchingParens("(abcd)")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{{{}}", hasMatchingParens("{{{{}}")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{{{}}})", hasMatchingParens("{{{{}}})")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{{}}}()", hasMatchingParens("{{{}}}()")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{{}}]()", hasMatchingParens("{{{}}]()")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{}}([]){}{}{}{}{[[[[]]]]}",
                hasMatchingParens("{{}}([]){}{}{}{}{[[[[]]]]}")));
    }

	
	public static boolean hasMatchingParens(String input) {
		try {
			Stack<Character> parenStack = new Stack<>();
			for(int i = 0; i < input.length(); i++) {
				Character curr = input.charAt(i);
				// If it's an opening char, push it to the stack
				if(openingParenSet.contains(curr)) {
					parenStack.push(curr);
				}
				// If it's an ending character, match it with the last
				// opening character which went into the stack.
				// If they match, pop the stack. If they don't, then it's
				// a bad statement.
				if(matchingParenMap.containsKey(curr)) {
					Character lastParen = parenStack.pop();
					if(lastParen != matchingParenMap.get(curr)) {
						return false;
					}
				}
			}
			// Iterated through string without any issues. 
			return parenStack.isEmpty();
		}catch (Stack.StackOverflowException exc) {
			System.out.println("Stack Overflow");
		}catch (Stack.StackUnderflowException exc) {
			System.out.println("Stack Underflow");
		}
		return false;
	}
}
