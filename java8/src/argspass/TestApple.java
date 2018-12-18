package argspass;

import java.util.ArrayList;
import java.util.List;

/**
 * @author innerpeacez
 * @since 2018/12/18
 */
public class TestApple {

    public static void prettyPrintApple(List<Apple> apples, AppleFormatter appleFormatter) {
        for (Apple apple : apples) {
            String output = appleFormatter.accept(apple);
            System.out.println(output);
        }
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.setColor("red");
        apple.setWeigth(10);
//        AppleSimpleFormatter formatter = new AppleSimpleFormatter();
        List<Apple> inventory = new ArrayList<>();
        inventory.add(apple);
        prettyPrintApple(inventory, apple1 -> "A apple of " + apple1.getWeigth() + " g");
    }
}
