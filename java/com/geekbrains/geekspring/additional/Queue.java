package com.geekbrains.geekspring.additional;

public class Queue {

    private Node getLast(Node current){
        if (current.getNext() == null) return current;
        return getLast(current.getNext());
    }

    public int search(Node start){
        int count = 0;
        String startKey = start.getKey();
        getLast(start).setNext(start);
        do {
            start = start.getNext();
            count++;
        } while (!start.getKey().equals(startKey));
        return count;
    }
}
