package com.aaa.lee.repast.controller;

import com.aaa.lee.repast.base.BaseService;
import com.aaa.lee.repast.base.CommonController;
import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.model.Address;
import com.aaa.lee.repast.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.Sqls;

/**
 * @autor:
 * @date: 2020-03-12
 * @Description:
 */
@RestController
public class AddressController extends CommonController<Address> {

    @Autowired
    private AddressService addressService;
    public BaseService<Address> getBaseService() {
        return addressService;
    }

    @PostMapping("/address/add")
    Integer addAddress(@RequestBody Address address) {
        return addressService.add(address);
    }

}
