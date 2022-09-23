package com.example.numbers;

import com.example.numbers.list.INumberList;
import com.example.numbers.list.SortedNumberList;
import com.example.numbers.utils.Common;

public final class Main {

    public static void main(String[] args) {
        int amount = 1_000_000;

        INumberList list = new SortedNumberList();
        for (int i = 0; i < amount; i++) {
            list.add(Common.irand(0, amount));
        }

        for (int i = 0; i < list.count(); i++) {
            System.out.println("Number at %d : %d".formatted(i, list.get(i)));
        }
    }

}
