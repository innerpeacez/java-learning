package argspass;

import java.util.ArrayList;
import java.util.List;

/**
 * @author innerpeacez
 * @since 2018/12/17
 */
public class AppleFilter {

    public static List<Apple> fileterGreenApples(List<Apple> inventory, String color) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (color.equals(apple.getColor()))
                result.add(apple);
        }
        return result;
    }
}
