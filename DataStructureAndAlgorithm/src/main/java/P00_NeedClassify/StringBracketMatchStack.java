package P00_NeedClassify;

import java.util.*;

public class StringBracketMatchStack {

	public static void main(String[] args) {
		System.out.println(isValid("()[]{}"));
	}

	public static boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;
        }else if("".equals(s)){
            return true;
        }else if( s.charAt(0)==')' || s.charAt(0)==']' || s.charAt(0)=='}' ) {
        	return false;
        }

        Stack sMatch = new Stack();
        for(char c:s.toCharArray()) {
        	switch(c) {
        		case '(':sMatch.push(c);break;
        		case '[':sMatch.push(c);break;
        		case '{':sMatch.push(c);break;
        		case ')':
        			if(sMatch.empty()) {
                        return false;
                    }
        			if(sMatch.peek().toString().charAt(0)=='(') {
        				sMatch.pop();break;
        			}
        			return false;
        		case ']':
        			if(sMatch.empty()) {
                        return false;
                    }
        			if(sMatch.peek().toString().charAt(0)=='[') {
        				sMatch.pop();break;
        			}
        			return false;
        		case '}':
        			if(sMatch.empty()) {
                        return false;
                    }
        			if(sMatch.peek().toString().charAt(0)=='{') {
        				sMatch.pop();break;
        			}
        			return false;
        	}
        }

        return sMatch.empty();
    }

}
