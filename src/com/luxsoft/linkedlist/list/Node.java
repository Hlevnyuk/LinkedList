package com.luxsoft.linkedlist.list;
public class Node<T> {
    Node<T> next;
    Node<T> prev;
    T value;
    public Node(T value) {
        this.value = value;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Node getPrev() {
        return prev;
    }
    public void setPrev(Node prev) {
        this.prev = prev;
    }
    public Object getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
}
