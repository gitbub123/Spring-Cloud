package com.hgz.service.impl;
import	java.util.ArrayList;

import com.hgz.entity.Product;
import com.hgz.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LuoWei
 * @Date 2019/12/1
 */
@Service
public class ProductServiceImpl implements IProductService {
    @Override
    public List<Product> list() {
        List<Product> list= new ArrayList<Product> ();
        list.add(new Product(1L,"教你日赚百万",999L));
        list.add(new Product(2L,"教你3天精通前端",99999L));
        return list;
    }
}
