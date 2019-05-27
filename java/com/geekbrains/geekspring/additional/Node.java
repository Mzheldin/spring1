package com.geekbrains.geekspring.additional;

import lombok.Data;
import org.apache.commons.codec.digest.DigestUtils;

@Data
public class Node {

    private Object object;

    private String key;

    private Node next;

    Node(Object object){
        this.object = object;
        key = DigestUtils.md5Hex(object.toString());
    }

}
