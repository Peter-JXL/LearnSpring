package com.peterjxl.proxy;

/**
 * 对生产厂家要求的接口，例如厂家需要规模大、负责任等
 */
public interface IProducer {

    // 销售
    void saleProduct(float money);

    // 售后
    void afterService(float money);
}
