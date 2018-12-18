package argspass;

/**
 * @author innerpeacez
 * @since 2018/12/18
 */
public class AppleSimpleFormatter implements AppleFormatter {

    @Override
    public String accept(Apple apple) {
        return "A apple of " + apple.getWeigth() + " g";
    }
}
