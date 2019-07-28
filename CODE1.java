package CODE1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class CODE1 {
	private static Stack stack = new Stack();
	
	public static void main(String[] args) throws IOException {
		
		
		String[] values = new String[] {"{[}]}", "{}[]()"};

		String[] result = checkBracket(values);
		
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		//System.out.println(checkBracket(values2));
		/*
        String[] res = braces(values);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
		*/
	}
	/*
	static class Stack {
	    String[] stack;
	    int top;

	    public Stack(int size) {
	        stack = new String[size];
	        this.top = -1;
	    }

	    public void push(String data) {
	        stack[++top] = data;
	    }

	    public String pop() {
	        return stack[top--];
	    }

	    public boolean isEmpty() {
	        if(top == -1) {
	            return true;
	        }
	        return false;
	    }
	}
	
	static String[] braces(String[] values) {
        
		String[] result = new String[] {"","","","",""};
		Stack stack = new Stack(values.length);		
		
		int loopCount = 0;
        for (loopCount = 0; loopCount < values.length; loopCount++) {
            String ch = values[loopCount];
            boolean isIncorrect = false;

            switch (ch) {
            case "(": case "{": case "[":
                stack.push(ch);
                break;

            case ")":
                if (stack.isEmpty() || (ch = stack.pop()) != "(") {
                    isIncorrect = true;
                }
                break;

            case "}":
                if (stack.isEmpty() || (ch = stack.pop()) != "(") {
                    isIncorrect = true;
                }
                break;

            case "]":
                if (stack.isEmpty() || (ch = stack.pop()) != "(") {
                    isIncorrect = true;
                }
                break;
            }
            
            if(isIncorrect) {
                break;
            }
        }
        
        if(stack.isEmpty() && loopCount == values.length) {
            System.out.println("correct");
        }
        else {
            System.out.println("incorrect");
        }
		
		return result;
    }
	
	*/
	// 괄호식 체크 메소드
	private static String[] checkBracket(String[] values) {
		String[] result = new String[values.length];
		
		for(int i = 0; i < values.length; i++) {
			if (checkBracket(values[i])) {
				result[i] = "YES";
			} else {
				result[i] = "NO";
			}
		}
		
		return result;
	}
	
	
	// 괄호식 체크 메소드
	private static boolean checkBracket(String str) {
		stack.clear();
		char tmp;	// 임시로 문자를 저장할 변수
		// 문자열 끝까지 실행
		for(int i = 0 ; i<str.length() ; i++) {
			tmp = str.charAt(i); // 문자열의 현재 인덱스를 받아 tmp에 저장
			
			// 여는 괄호인 경우 스택에 푸쉬
			if(tmp=='('||tmp=='{'||tmp=='['||tmp=='<')
				stack.push(tmp);
			
			// 여는 괄호가 아닌경우 스택이 비어있지 않다면 팝 하여 짝이 맞는지 체크. 맞으면 다음 인덱스로 진행, 틀리면 false리턴
			else if(!stack.isEmpty()){
				tmp = (char) stack.pop();
				if(tmp=='(') {
					if(str.charAt(i)==')')
						continue;
					else
						return false;
				}
				else if(tmp=='{') {
					if(str.charAt(i)=='}')
						continue;
					else
						return false;
				}
				else if(tmp=='[') {
					if(str.charAt(i)==']')
						continue;
					else
						return false;
				}
				else {
					if(str.charAt(i)=='>')
						continue;
					else
						return false;
				}
			}
			
			// 여는 괄호가 아닌(괄호이외의 문자는 포함하지 않으므로 닫는괄호인)데 스택이 비어있는 경우 false 리턴
			else
				return false;
		}
		
		// 문자열을 전부 체크했는데 스택이 비어있는 경우 true 리턴
		if(stack.isEmpty())
			return true;
		// 문자열을 전부 체크했는데 스택이 비지 않은경우 닫히지 않은 괄호가 있는 것이므로 false 리턴
		else
			return false;
	}

}
