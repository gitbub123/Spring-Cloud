package com.hgz.controller;

import com.hgz.entity.Product;
import com.hgz.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LuoWei
 * @Date 2019/12/1
 */
@RestController
@RequestMapping("product")
@Slf4j
public class ProductController {
    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private IProductService productService;

    @GetMapping("list")
    public List<Product> list(){
        log.info(serverPort);
        return productService.list();
    }
}