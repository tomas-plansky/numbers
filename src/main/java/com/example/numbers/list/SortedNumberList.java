package com.example.numbers.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortedNumberList implements INumberList {

    private final List<Integer> list;

    public SortedNumberList() {
        this.list = new ArrayList<>();
    }

    public SortedNumberList(List<Integer> list) {
        this();
        for (int number : list) {
            add(number);
        }
    }

    public SortedNumberList(Integer... numbers) {
        this();
        for (int number : numbers) {
            add(number);
        }
    }

    @Override
    public String toString() {
        return list.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

    @Override
    public int count(int... i) {
        if (i.length > 1) {
            int count = 0;
            for (int i1 : i) {
                count += this.count(i1);
            }
            return count;
        }
        return list.size();
    }

    private int count(int number) {
        int count = 0;
        int index = Collections.binarySearch(list, number);
        if (index == -1) {
            return count;
        }

        int size = this.count();
        for (; index < size; index++) {
            if (this.get(index) == number) {
                count++;
            } else {
                break;
            }
        }

        for (; index >= 0; index--) {
            if (this.get(index) == number) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    @Override
    public void add(int number) {
        int size = count();
        if (size == 0) {
            list.add(number);
        } else {
            for (int i = 0; i < size; i++) {
                if (get(i) >= number) {
                    list.add(number);
                }
            }
        }
    }

    @Override
    public void remove(int number) {
        list.remove(number);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public int get(int index) {
        return list.get(index);
    }

    @Override
    public boolean contains(int number) {
        return Collections.binarySearch(list, number) != -1;
    }

}
