package com.uestc.service;

import com.uestc.domain.Customer;
import com.uestc.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    public void insert(Customer customer ){

        customerMapper.insertSelective(customer);
    }
    public Customer findOne(int id ){

        return customerMapper.selectByPrimaryKey(id);
    }
}
