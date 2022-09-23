package com.example.numbers.list;

public interface INumberList {

    String toString();

    void add(int number);

    int get(int index);

    void remove(int number);

    boolean contains(int number);

    void clear();

    default int count() {
        return this.count(new int[0]);
    }

    int count(int... i);

}
