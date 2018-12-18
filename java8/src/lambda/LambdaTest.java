package lambda;

/**
 * @author innerpeacez
 * @since 2018/12/18
 */
public class LambdaTest {

    public static void process(Runnable runnable) {
        runnable.run();
    }


    public static void main(String[] args) {
        process(() -> System.out.println("Hello World Lambda"));
    }
}
