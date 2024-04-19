package entities;

import java.util.ArrayList;
import java.util.List;

public class Order{
    private Integer quantity;
    private Double price;
    private List<Product> products = new ArrayList<>();
}
