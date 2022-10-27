package ru.netology.domain;

public class Smartphone extends Product {
    private String produce;

    public Smartphone(int id, String name, long price, String produce) {
        super(id, name, price);
        this.produce = produce;
    }

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }
}
