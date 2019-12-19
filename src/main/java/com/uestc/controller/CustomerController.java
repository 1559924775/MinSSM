package com.uestc.controller;

import com.uestc.domain.Customer;
import com.uestc.service.CustomerService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
//返回的编码位utf-8
//,produces = "text/plain;charset=utf-8"
@RequestMapping(value = {"/customer"})
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @RequestMapping("/test")
    public String test(){
        return "test";
    }

//    http://localhost:8081/MinSSM/customer/find.do?id=1
    @RequestMapping("/find")
   public Customer findOne(@RequestParam int id){
       Customer customer= customerService.findOne(id);
       System.out.println("+++++++++++++++++"+customer.getName());
       return  customer;
   }
}
