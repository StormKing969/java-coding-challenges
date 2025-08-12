package Question02;

import java.util.Stack;

public class  Q2_Attempt_3 {
    public static String clearDigitsV3(String word) {
         Stack<Character> characterStack = new Stack<>();

         // Iterate over each character in the string
         for(char character : word.toCharArray()){
             if(!Character.isDigit(character)){
                 // Push non-digit characters onto the stack
                 characterStack.push(character);
             } else {
                 // If a digit is encountered, remove the last non-digit character (if stack is not empty)
                 if(!characterStack.isEmpty()){
                     characterStack.pop();
                 }
             }
         }

         StringBuilder new_word = new StringBuilder();
         // Construct the final result by popping characters from the stack
         while(!characterStack.isEmpty()){
             new_word.append(characterStack.pop());
         }

         // Reverse the string as stack follows LIFO order and return the result
         return new_word.reverse().toString();
    }
}
