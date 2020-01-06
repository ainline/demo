package com.alchen.cglib;

public class Producer {
    /**
     * 销售
     *
     * @param money
     */
    public void saleProduct(float money) {
        System.out.println("销售产品，收入：" + money);
    }

    /**
     * 售后
     *
     * @param money
     */
    public void afterService(float money) {
        System.out.println("售后服务，收入" + money);
    }
}
