package pack;

import java.util.ArrayList;
import java.util.List;

public class ExpressionEngine {
    public static List<String> tokenize(String expression) {
        List<String> tokens = new ArrayList<>();
        String token = "";
        for(int i = 0; i < expression.length(); i++){
            String character = Character.toString(expression.charAt(i));
            if((character.equals(" ") || i == expression.length() - 1) && !token.isEmpty()) {
                if(i == expression.length() - 1) {
                    token = token + character;
                }
                tokens.add(token);
                token = "";
            } else if(character.equals(")") || character.equals("(") || character.equals(">") || character.equals("<")) {
                if(!token.isEmpty()) {
                    tokens.add(token);
                    token = "";
                }
                tokens.add(character);

            } else {
                token = token + character;
            }
        }
        return tokens;
    }

    static int index = 0;

    public static Node createNodeFromExpression(List<String> tokens) {
        if(index < tokens.size()) {
            Node left = null;
            if(tokens.get(index + 1).equals("(")) {
                index++;
                left = createNodeFromExpression(tokens);
            } else {
                left = new Node(tokens.get(++index));
            }
            Node node = new Node(tokens.get(++index));
            node.left = left;
            Node right = null;
            if(tokens.get(index + 1).equals("(")) {
                index++;
                right = createNodeFromExpression(tokens);
            } else {
                right = new Node(tokens.get(++index));
            }
            node.right = right;
            while (index < tokens.size() && !tokens.get(index).equals(")")) {
                index++;
            }
            return node;
        }
        return null;
    }

    public static void main(String[] args) {
        //System.out.println(tokenize("(xx > 15)"));
        //System.out.println(tokenize("(xx > 15) && myCons == 'Stop'"));
        //System.out.println(createNodeFromExpression(tokenize("(xx > 15)")));
        System.out.println(createNodeFromExpression(tokenize("((xx > 15) && (myCons == 'Stop'))")));
    }

    static class Node {
        String value;
        Node left;
        Node right;

        public Node(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
