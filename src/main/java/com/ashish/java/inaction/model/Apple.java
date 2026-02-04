package com.ashish.java.inaction.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Apple {
    @NonNull
    private int weight = 0;
    @NonNull
    private String color = "";

    public Apple(int i, String green) {
        this.weight = i;
        this.color = green;
    }
}