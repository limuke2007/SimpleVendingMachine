package com.laioffer.OOD.vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class TestVendingMachine {

    public static void main(String[] args) {
        TestVendingMachine solution = new TestVendingMachine();
        solution.test();
    }

    public void test() {
        List<Inventory> inventories = new ArrayList<>();

        Inventory water = new Inventory("water", 175, 1);                         // 创建water条目
        water.fill();                                                             // water状态改为“有”
        inventories.add(water);                                                   // 把water加入名单

        Inventory coke = new Inventory("coke", 225, 1);                           // 创建coke条目
        coke.fill();
        inventories.add(coke);

        Inventory drPepper = new Inventory("drPepper", 225, 1);                   // 创建drPepper条目
        drPepper.fill();
        inventories.add(drPepper);

        Inventory lemonade = new Inventory("lemonade", 225, 1);                   // 创建lemonade条目
        lemonade.fill();
        inventories.add(lemonade);


        VendingMachine vm = new VendingMachine(inventories);                      // 创建一个自动售货机vm

        List<String> listInventory = vm.listInventory();                          // 把货品名单扫一遍
        for (String item : listInventory) {
            System.out.println("ListInventory item: " + item);                    // 打印一份名单
        }

//************************************************************************************************************//

        int inputQuarters = 7;
        for (int i = 0; i < inputQuarters; i++) {
            vm.takeQuarter();
        }                                                                   // added 7 coins = 175分
        System.out.println("totalInput: " + vm.inputMoney + " inputQuarters: " + inputQuarters);

        List<String> listCanBuy = vm.listCanBuy();
        for (String item : listCanBuy) {                                    // check buyable list
            System.out.println("listCanBuy item: " + item);                 // 打印175分可以买的所有饮料
        }

        vm.vend("water");                                                   // 成功卖出water
        System.out.println("inputMoney: " + vm.inputMoney);                 // 打印更新的钱

//************************************************************************************************************//

        inputQuarters = 9;
        for (int i = 0; i < inputQuarters; i++) {
            vm.takeQuarter();                                               // 我加入9个币 = 225分
        }
        System.out.println("moneyBalance: " + vm.inputMoney + " inputQuarters: " + inputQuarters);

        listInventory = vm.listInventory();
        for (String item : listInventory) {
            System.out.println("listInventory:  " + item);                  // 再打印一份名单
        }

        listCanBuy = vm.listCanBuy();
        System.out.println("listCanBuy list size(): " + listCanBuy.size());     // 能买几种饮料？ (3种）

        for (String item : listCanBuy) {
            System.out.println("listCanBuy item: " + item);                     // 能买哪几种？
        }

        System.out.println(water.canVend(vm.inputMoney));                       // 还能买water吗？（之前已经卖出）


        water.fill();                                                         // 如果正好有人来补货water
        System.out.println(water.canVend(vm.inputMoney));


        System.out.println("inputMoney: " + vm.inputMoney);                     // 再看一下我已经放进去多少钱

        int change = vm.vend("water");                                        // 买一个water，返还50分
        System.out.println("Please take your change: " + change);             // 打印信息，告诉顾客拿好返还的50分

        System.out.println("inputMoney: " + vm.inputMoney);                   // 看看现在金额（找零的时候已经清零了）

//************************************************************************************************************//

        inputQuarters = 10;
        for (int i = 0; i < inputQuarters; i++) {
            vm.takeQuarter();                                               // 我再加入10个币 = 250分
        }
        System.out.println("moneyBalance: " + vm.inputMoney + " inputQuarters: " + inputQuarters);

        listCanBuy = vm.listCanBuy();
        System.out.println("listCanBuy list size(): " + listCanBuy.size());     // 能买几种饮料？ （3种）

        for (String item : listCanBuy) {
            System.out.println("listCanBuy item: " + item);                     // 能买哪几种？
        }

        System.out.println(water.canVend(vm.inputMoney));                       // 还能买water吗？（之前已经卖出）

        change = vm.vend("coke");                                        // 买一个coke，返还25分
        System.out.println("Please take your change: " + change);             // 打印信息，告诉顾客拿好返还的25分

        System.out.println("inputMoney: " + vm.inputMoney);                   // 看看现在金额（找零的时候已经清零了）



        vm.takeQuarter();                                                       // 投一个币看看机器是否正常
        System.out.println("inputMoney: " + vm.inputMoney);

    }
}
