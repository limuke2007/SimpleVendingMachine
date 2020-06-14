package com.laioffer.OOD.vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    protected List<Inventory> inventories = new ArrayList<>();
    protected int inputMoney;

    public VendingMachine(List<Inventory> inventories) {
        this.inventories = inventories;
        this.inputMoney = 0;
    }

    public int takeQuarter() {
        inputMoney = inputMoney + 25;
        return inputMoney;    // inputMoney is updated when it takes a quarter
    }

    // return all the product names in the machine, even it has been sold out.
    public List<String> listInventory() {
        List<String> ans = new ArrayList<>();
        for (Inventory item : inventories) {
            ans.add(item.product);
        }                 //add all the product names in inventory to the list
        return ans;
    }

    // return all the buyable product names based on the money and inventory status.
    public List<String> listCanBuy() {
        List<String> ans = new ArrayList<>();
        for (Inventory item : inventories) { // check whole inventory
            if (item.canVend(inputMoney)) {    // if canVend for inputMoney
                ans.add(item.product);       // add it the the buyable products list
            }
        }
        return ans;                         // return the list;
    }

    // return the change, note there is no guarantee that the product has not been sold out.
    public int vend(String product) {                           // 卖出method，返回类型是int（返还的钱）
        List<String> listCanBuy = listCanBuy();
        boolean vendSuccess = false;
        if (listCanBuy.contains(product)) {
            for (Inventory item : inventories) {
                if (item.product == product) {
                    vendSuccess = item.vend(inputMoney);
                    inputMoney = inputMoney - item.getPrice();  // update the inputMoney（成功卖出的话，要扣钱）
                    break;
                }
            }
        }
        return refund();                    // return remaining money（成功卖出之后，要找零钱）
    }

    // return the money fed by the current customer.
    public int refund() {
        int refund = inputMoney;    // set refund equals remaining money（不买了，直接把所有输入的钱退还）
        inputMoney = 0;             // set remaining money to 0 before refund（这个很重要，退款同时，余额清零）
        return refund;              // give refund
    }
}
