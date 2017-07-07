package com.example.user.kasir;

/**
 * Created by user on 7/6/2017.
 */

public class makanan {
    protected int harga,totalharga;
    protected int quantity;
    protected String Order;



    public int getTotalharga() {
        totalharga = harga*quantity;
        return totalharga;
    }

    public void setTotalharga(int totalharga) {
        this.totalharga = totalharga;
    }

    public int getHarga() {
        return harga;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrder() {
        return Order;
    }

    public void setOrder(String order) {
        Order = order;
    }

    public void setharga(int harga) {
        this.harga = harga;
    }


}
