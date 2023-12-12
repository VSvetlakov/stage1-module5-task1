package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {

        return strings -> {
                for (String s: strings) {
                    if (!Character.isUpperCase(s.charAt(0)))
                        return false;
                };
                return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {

        return integers -> {

            int size = integers.size();

            for (int i = 0; i < size; i++) {
                Integer cur = integers.get(i);
                if (cur % 2 == 0) {
                    integers.add(cur);
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {

        return () -> {

            List<String> newList = new ArrayList<>();

            for (String s : values) {

                if (Character.isLowerCase(s.charAt(0))) continue;

                if (!s.endsWith(".")) continue;

                if (s.split(" ").length <= 3) continue;

                newList.add(s);
            }

            return newList;
    };}


    public Function<List<String>, Map<String, Integer>> stringSize() {

        return strings -> {
            Map<String, Integer> map = new HashMap<>();

            for (String s : strings) {
                map.put(s, s.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (integers, integers2) -> {
            ArrayList<Integer> arrayList = new ArrayList<>(integers);
            arrayList.addAll(integers2);
            return arrayList;
        };
    }
}
