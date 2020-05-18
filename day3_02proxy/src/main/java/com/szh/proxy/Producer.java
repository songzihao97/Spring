package com.szh.proxy;

/**
 * 生产者
 */
public class Producer implements IProducer{

    /**
     * 销售商品
     * @param money
     */
    public void saleProduct(float money){
        System.out.println("销售商品，拿到钱"+money);
    }

    /**
     * 售后服务
     * @param money
     */
    public void afterService(float money){
        System.out.println("售后服务，拿到钱"+money);
    }
}
