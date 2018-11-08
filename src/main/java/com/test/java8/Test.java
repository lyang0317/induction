package com.test.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Test {

    public static Test create(TestInterface<Test> supplier ) {
        return supplier.fuck();
    }

    public static void main(String[] args) {
        TestInterface<Test> supplier  = () -> new Test();
        Test test1 = Test.create(supplier);
        System.out.println(test1);
        Test test2 = Test.create(Test::new);
        System.out.println(test2);

        List<String> list = new ArrayList<String>(){{
            add("1");
            add("2");
            add("2");
        }};
        list.stream()
                .filter(o -> o.equals("1"))
                .map(o -> o.concat("+"))
                .forEach(System.out::println);
        System.out.println("++++++++++++++++++");
        list.stream().map(o -> o.concat("-")).forEach(System.out::println);
        System.out.println("++++++++++++++++++");
        list.stream().
                mapToInt(Integer::valueOf).
                distinct().
                forEach(System.out::println);
        System.out.println("++++++++++++++++++");
        list.parallelStream().filter(o -> o.equals("1")).collect(toList());
        System.out.println("++++++++++++++++++");
        boolean b = list.stream().anyMatch(o -> o.equals("2"));
        System.out.println(b);
        System.out.println("++++++++++++++++++");
        Optional<String> any = list.stream().findAny();
        System.out.println(any.orElse("33"));
        System.out.println("++++++++++++++++++");
        Predicate<String> predicate = t -> t.contains("1");
        list.parallelStream().reduce(new ArrayList<String>(), (r, t) -> {if (predicate.test(t)) r.add(t);  return r; },
                (r1, r2) -> {System.out.println(r1==r2); return r2; }).stream().forEach(System.out::println);
    }
}
