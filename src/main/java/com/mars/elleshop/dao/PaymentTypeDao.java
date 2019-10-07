package com.mars.elleshop.dao;

import com.mars.elleshop.entity.Coupons;
import com.mars.elleshop.entity.PaymentType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/07  13:22:00
 */
@Repository
public interface PaymentTypeDao {

    PaymentType findPaymentTypeById(Integer paymentTypeId);

    List<PaymentType> findAllPaymentType();
}
