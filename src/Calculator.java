import java.util.function.*;

public class Calculator {
    static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> { //y > 0 ? x / y : 0;
        // На ноль делить нельзя ... мы можем просто выводить ноль или обрабатывать исключение
        try {
            return x / y;
        } catch (ArithmeticException e) {
            System.out.println("На ноль делить нельзя.");
            //throw new ArithmeticException("Делить на ноль нельзя");
            return 0;
        }
    };

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;
}
