import java.util.*;

public class HW2_Practice2 {
    public static void main(String[] args) {
        Stack<Integer> stack9 = new Stack<>();

        for (int i = 0; i < 10; i++)
            stack9.push(i);
        
        while (!stack9.empty())
            System.out.print(stack9.pop() + " ");
       }

}
