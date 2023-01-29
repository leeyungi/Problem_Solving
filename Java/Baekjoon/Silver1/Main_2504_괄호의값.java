package Java.Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2504_괄호의값 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0, multi = 1;
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
                multi *= 2;
            }
            else if (c == '[') {
                stack.push(c);
                multi *= 3;
            }
            else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    answer = 0;
                    break;
                }
                if (s.charAt(i - 1) == '(') answer += multi;
                multi /= 2;
            }
            else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    answer = 0;
                    break;
                }
                if (s.charAt(i - 1) == '[') answer += multi;
                multi /= 3;
            }
            else {
                answer = 0;
                break;
            }
        }
        if (stack.isEmpty()) System.out.println(answer);
        else System.out.println(0);
    }
}
