package com.laioffer.OOD.vendingmachine;

public class Inventory {
    // Notice size defines the capacity of the inventory, not the actual product amount.
    protected String product;
    protected int price;
    protected int size;
    protected boolean isFilled;

    public Inventory(String product, int price, int size) {
        this.product = product;
        this.price = price;
        this.size = size;
    }

    // fill will always fill the inventory to its capacity.
    public void fill() {
        isFilled = true;
    }

    // return the product name.
    public String getProduct() {
        if (!isFilled) {  // not filled, not product
            return null;
        } else {         // if there is product
            return product;
        }
    }

    // return the product price.
    public int getPrice() {
        return price;
    }

    // return if the product can be vended with the given amount of money.
    public boolean canVend(int money) {
        if (money >= price && isFilled) { // if there are still products
            return true;                      // and your money is enough
        }
        return false;
    }

    // return if the product is actually vended.
    public boolean vend(int money) {
        if (canVend(money)) {     // when product is actually vended
            isFilled = false;               // we decrease the amount，卖完了
            return true;            // and say "it is vended"
        }
        return false;
    }
}
