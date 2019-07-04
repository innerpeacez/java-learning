package com.zhw.java.study.example;

import com.zhw.java.study.pojo.transactions.Trader;
import com.zhw.java.study.pojo.transactions.Transaction;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TransactionTest {

    private List<Transaction> transactions;

    {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brain = new Trader("Brain", "Cambridge");
        transactions = Arrays.asList(new Transaction(brain, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));

    }

    /**
     * 2011 年所有发生的交易，按交易额的大小排序（从小到大）
     */
    @Test
    public void test2011Transaction() {
        List<Transaction> transactions2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(transactions2011);
    }

    /**
     * 交易员都在哪个城市工作过
     */
    @Test
    public void testCityDifferent() {
        List<String> differentCity = transactions.parallelStream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(differentCity);

        Set<String> differentCity2 = transactions.parallelStream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet());
        System.out.println(differentCity2);
    }

    /**
     * 查找来自剑桥的交易员,按姓名顺序排列
     */
    @Test
    public void testCambridge() {
        List<Trader> cambridge = transactions.parallelStream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(cambridge);
    }

    /**
     * 查找交易员的名字，按名字排序
     */
    @Test
    public void testName() {
        List<String> traders = transactions.parallelStream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(traders);

        String nameStr = transactions.parallelStream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(Collectors.joining());
        System.out.println(nameStr);
    }

    /**
     * 查找有没有交易员在米兰工作
     */
    @Test
    public void testMilan() {
        boolean milan = transactions.parallelStream()
                .map(Transaction::getTrader)
                .distinct()
                .anyMatch(trader -> trader.getCity().equals("Milan"));
        System.out.printf("有没有交易员在米兰工作? %s", milan ? "有" : "无");
    }

    /**
     * 生活在剑桥的交易员的总交易额
     */
    @Test
    public void testTransactionValueSum() {
        int cambridgeSum = transactions.parallelStream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .mapToInt(Transaction::getValue)
                .sum();
        System.out.println(cambridgeSum);


        transactions.parallelStream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .mapToInt(Transaction::getValue)
                .forEach(System.out::println);
    }

    /**
     * 最高交易额
     */
    @Test
    public void TestMax() {
        OptionalInt max = transactions.parallelStream()
                .mapToInt(Transaction::getValue)
                .max();
        System.out.println(max.orElse(0));

        Optional<Integer> max2 = transactions.parallelStream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(max2);
    }

    /**
     * 最小交易
     */
    @Test
    public void TestMinTransaction() {
        Optional<Transaction> min = transactions.parallelStream()
                .min(Comparator.comparing(Transaction::getValue));
        System.out.println(min.orElse(null));
    }
}
