package com.wang.search.controller.entity;

import lombok.Data;

@Data
public class Node {
    int value;
    boolean visited = false;
    Node leftChild;
    Node rightChild;

    public Node(int value) {
        this.value = value;
    }

}
