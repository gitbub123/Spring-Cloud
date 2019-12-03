package com.hgz.controller;

import com.hgz.entity.Product;
import com.hgz.feign.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author LuoWei
 * @Date 2019/12/1
 */
@Controller
@RequestMapping("index")
public class IndexController {
    //@Autowired
    //private RestTemplate restTemplate;
    //private String PRODUCT_SERVICE_URL = "http://PRODUCT-SERVICE/product/list";
    @Autowired
    private ProductService productService;

    @RequestMapping("show")
    @ResponseBody
    public List<Product> show(){
        //1.调用商品服务，获取到商品信息
        //RestTemplate restTemplate = new RestTemplate();
        //String list = restTemplate.getForObject(PRODUCT_SERVICE_URL, String.class);
        List<Product> list = productService.list();
        return list;
    }
}
