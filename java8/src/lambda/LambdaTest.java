package lambda;

import java.nio.file.DirectoryStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author innerpeacez
 * @since 2018/12/18
 */
public class LambdaTest {

    public static void process(Runnable runnable) {
        runnable.run();
    }


    public static void main(String[] args) {
//        process(() -> System.out.println("Hello World Lambda"));

        Predicate<String> filter = (String s) -> !s.isEmpty();
        List strings = new ArrayList<>();
        strings.add("zhw");
        strings.add("");
        List list = filter(strings, filter);
        System.out.println(list);
    }

    public static <T> List<T> filter(List<T> list, Predicate p) {
        List results = new ArrayList();
        list.forEach((T) -> {
            if (p.test(T)) {
                results.add(T);
            }
        });
        return results;
    }
}
