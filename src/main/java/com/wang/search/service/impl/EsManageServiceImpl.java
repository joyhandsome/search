package com.wang.search.service.impl;

import com.wang.search.controller.entity.Node;
import com.wang.search.core.DocumentEntity;
import com.wang.search.service.EsManageService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

/**
 * es实现类
 *
 * @author wangjunhao
 * @version 1.0
 * @date 2020/7/29 14:25
 * @since JDK 1.8
 */
@Service
@Slf4j
public class EsManageServiceImpl implements EsManageService {

    @Resource
    private RestHighLevelClient client;

    @Override
    public String search() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchQuery("content", "test"));
        searchRequest.source(sourceBuilder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] searchHits = response.getHits().getHits();
        for (SearchHit hit : searchHits) {
            System.out.println("id: " + hit.getId());
            System.out.println("index: " + hit.getIndex());
            Map<String, Object> map = hit.getSourceAsMap();
            System.out.println(map.get("title"));
        }
        client.close();
        return null;
    }

    @Override
    public void add(DocumentEntity documentEntity) {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    }

//    public static void main(String[] args) {
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        Node node4 = new Node(4);
//        Node node5 = new Node(5);
//        Node node6 = new Node(6);
//        node1.setLeftChild(node2);
//        node2.setLeftChild(node3);
//        node2.setRightChild(node4);
//        node3.setRightChild(node5);
//        node3.setLeftChild(node6);
//        deep(node1);
//    }

    private static void greep(Node root) {
        ArrayDeque<Node> arrayDeque = new ArrayDeque();
        arrayDeque.add(root);
        while (arrayDeque.size() != 0) {
            Node node = arrayDeque.pollFirst();
            System.out.println(node.getValue());
            if (node.getLeftChild() != null)
                arrayDeque.add(node.getLeftChild());
            if (node.getRightChild() != null)
                arrayDeque.add(node.getRightChild());
        }

    }

    private static void deep(Node root) {

    }

    private static void deepD(Node root) {
        if (root == null) {
            return;
        }
        if (root.getLeftChild() != null) {
            deepD(root.getLeftChild());
        }
        if (root.getRightChild() != null) {
            deepD(root.getRightChild());
        }
        System.out.println(root.getValue());
    }

    private static void heapDel(int[] arr) {
        int size = arr.length;
        while (size >= 0) {
            size--;
            System.out.println(arr[0]);
            arr[0] = arr[size];
            build(arr, size);
        }
    }

    private static void build(int[] arr, int size) {
        int index = 0;
        int harf = size >> 1;
        while (index < harf) {
            int left = (index << 1) + 1;
            int right = left + 1;
            int inner_index = arr[left] > arr[right] ? left : right;
            if (arr[index] > arr[inner_index]) {
                break;
            }
            swap(index, inner_index, arr);
            index = inner_index;
        }

    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void build(int[] arr, int size, int value, int index) {
        int harf = size >> 1;
        while (index < harf) {
            int left = (index << 1) + 1;
            if (left + 1 < size) {
                left = arr[left] > arr[left + 1] ? left : left + 1;
            }
            if (arr[index] > arr[left]) {
                break;
            }
            arr[index] = arr[left];
            index = left;
        }
        arr[index] = value;
    }

    private static void heapSort(int[] arr) {
        int size = arr.length;
        if (arr.length <= 1) {
            return;
        }
        int index = (arr.length >> 1) - 1;
        while (index >= 0) {
            build(arr, arr.length, arr[index], index);
            index--;
        }
        while (size > 0) {
            size--;
            System.out.println(arr[0]);
            arr[0] = arr[size];
            build(arr, size, arr[0], 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{16, 4, 50, 2, 3, 11};
        heapSort(arr);
    }
}
