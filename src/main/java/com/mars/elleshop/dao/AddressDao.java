package com.mars.elleshop.dao;

import com.mars.elleshop.entity.Address;

import java.util.List;

public interface AddressDao {
    List<Address> queryById(Integer uid);
}
