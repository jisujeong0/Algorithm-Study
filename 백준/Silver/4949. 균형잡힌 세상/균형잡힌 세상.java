import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;

            Stack<String> stack = new Stack<>();

            String[] sentence = str.split("");
            for(String word : sentence){
                switch (word) {
                    case ("("):
                    case ("["):
                        stack.push(word);
                        break;
                    case (")"):
                        if(!stack.isEmpty() && stack.peek().equals("("))
                            stack.pop();
                        else stack.push(")");
                        break;
                    case ("]"):
                        if(!stack.isEmpty() && stack.peek().equals("["))
                            stack.pop();
                        else stack.push("]");
                        break;
                }
            }

            if (stack.empty())
                sb.append("yes").append('\n');
            else
                sb.append("no").append('\n');
        }
        System.out.println(sb);
    }
}