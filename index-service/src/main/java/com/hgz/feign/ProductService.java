package com.hgz.feign;

import com.hgz.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LuoWei
 * @Date 2019/12/2
 */
@FeignClient(name ="PRODUCT-SERVICE",fallback = ProductService.productFallback.class)
public interface ProductService {

    @GetMapping("product/list")
    public List<Product> list();
    //添加兜底方案
    @Slf4j
    @Component
    static class productFallback implements ProductService {
        @Override
        public List<Product> list() {
            log.info("调用product-service出现问题，进入熔断机制，，，，，");
            List<Product> products=new ArrayList<>();
            return products;
        }
    }
}
