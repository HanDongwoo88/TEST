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
	// ��ȣ�� üũ �޼ҵ�
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
	
	
	// ��ȣ�� üũ �޼ҵ�
	private static boolean checkBracket(String str) {
		stack.clear();
		char tmp;	// �ӽ÷� ���ڸ� ������ ����
		// ���ڿ� ������ ����
		for(int i = 0 ; i<str.length() ; i++) {
			tmp = str.charAt(i); // ���ڿ��� ���� �ε����� �޾� tmp�� ����
			
			// ���� ��ȣ�� ��� ���ÿ� Ǫ��
			if(tmp=='('||tmp=='{'||tmp=='['||tmp=='<')
				stack.push(tmp);
			
			// ���� ��ȣ�� �ƴѰ�� ������ ������� �ʴٸ� �� �Ͽ� ¦�� �´��� üũ. ������ ���� �ε����� ����, Ʋ���� false����
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
			
			// ���� ��ȣ�� �ƴ�(��ȣ�̿��� ���ڴ� �������� �����Ƿ� �ݴ°�ȣ��)�� ������ ����ִ� ��� false ����
			else
				return false;
		}
		
		// ���ڿ��� ���� üũ�ߴµ� ������ ����ִ� ��� true ����
		if(stack.isEmpty())
			return true;
		// ���ڿ��� ���� üũ�ߴµ� ������ ���� ������� ������ ���� ��ȣ�� �ִ� ���̹Ƿ� false ����
		else
			return false;
	}

}
