package lambda;

import java.nio.file.DirectoryStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
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

//        Predicate<String> filter = (String s) -> !s.isEmpty();
//        List strings = new ArrayList<>();
//        strings.add("zhw");
//        strings.add("");
//        List list = filter(strings, filter);
//        System.out.println(list);

//        Consumer<Integer> integerConsumer = (Integer t) -> System.out.println(t);
//        forEach(Arrays.asList(1, 2, 3, 4, 5), integerConsumer);

        List<Integer> map = map(Arrays.asList("zhai", "hong", "wei"), (String::length));
        System.out.println(map);
    }

    public static <T> void forEach(List<T> t, Consumer<T> c) {
        t.forEach(i -> c.accept(i));
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        list.forEach(v -> result.add(f.apply(v)));
        return result;
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
