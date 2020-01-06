package com.alchen.proxy;

public class Producer implements IProducer {
    /**
     * 销售
     *
     * @param money
     */
    @Override
    public void saleProduct(float money) {
        System.out.println("销售产品，收入：" + money);
    }

    /**
     * 售后
     *
     * @param money
     */
    @Override
    public void afterService(float money) {
        System.out.println("售后服务，收入" + money);
    }
}
