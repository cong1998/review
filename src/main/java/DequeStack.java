import java.util.Deque;
import java.util.LinkedList;

public class DequeStack {

    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();
        int should = 11;
        do{
            int mod = should % 2;
            should /= 2;
            stack.push(mod);
        }while (should > 0);

        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
