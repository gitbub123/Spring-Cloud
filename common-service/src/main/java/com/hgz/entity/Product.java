package com.hgz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author LuoWei
 * @Date 2019/12/1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    private Long id;
    private String name;
    private Long price;
}
