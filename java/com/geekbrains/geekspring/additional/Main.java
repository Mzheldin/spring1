package com.geekbrains.geekspring.additional;

public class Main {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node("some");
        Node node3 = new Node(new Long(54));
        Node node4 = new Node('g');

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        Queue queue = new Queue();
        System.out.println(queue.search(node1));
    }
}
