package by.sterlikov.jstlexample.model;

import lombok.Data;

@Data
public class Product {
    private String id; // id для монго строка
    private String name;
    private int price;
}
