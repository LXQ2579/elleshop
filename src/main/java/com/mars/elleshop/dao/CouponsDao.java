package com.mars.elleshop.dao;

import com.mars.elleshop.entity.Coupons;
import org.springframework.stereotype.Repository;

/**
 * @author sanriyue
 */
@Repository
public interface CouponsDao {
    Coupons findCouponsById(Integer couponsId);
}
