package com.luxsoft.linkedlist.list;
import java.util.StringJoiner;
public class LinkedList implements List {
    Node head;
    Node tail;
    int size = 0;
    @Override
    public void add(Object value) {
        if(value == null){
            throw new NullPointerException("You cannot add null element");
        }
        if(size==0){
            Node newNode = new Node(value);
            head = tail = newNode;
            size++;
        }
        else {
            add(value,size);
        }
    }
    @Override
    public void add(Object value, int index) {
        if(value == null){
            throw new NullPointerException("You cannot add null element");
        }
        Node newNode = new Node(value);
        if(size == 0){
            head = tail = newNode;
        }
        else if (index == 0) {
            head.setPrev(newNode);
            newNode.setNext(head);
            head = newNode;
        }
        else if(index == size){
            tail.setPrev(tail);
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.setPrev(current.getPrev());
            newNode.setNext(current);
            current.prev.setNext(newNode);
            current.setPrev(newNode);
        }
        size++;
    }
    @Override
    public Object remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("There is no element in that index");
        }
        Node result = new Node(null);
        if(size == 1){
            result = head;
            head = new Node(null);
        }
        else if(index == size - 1){
            result = tail;
            tail = tail.prev;
            tail.next = null;
        }
        else  if(index == 0){
            result = head;
            head = head.next;
            head.prev = null;
        }
        else{
            result = head;
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
            result.next.setPrev(result.getPrev());
            result.prev.setNext(result.getNext());
        }
        size--;
        return result.value;
    }
    @Override
    public Object get(int index) {
        if(index >= size){
            throw new IndexOutOfBoundsException("incorrect index");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }
    @Override
    public Object set(Object value, int index) {
        if(index >= size){
            throw new IndexOutOfBoundsException("There is no element in that index");
        }
        Node newNode = new Node(value);
        Node result = head;
        if(index == 0){
            head.setPrev(newNode);
            newNode.setNext(head);
            head = newNode;
        }
        else if(index == size - 1){
            result = tail;
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        else{
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
            result.prev.setNext(newNode);
            result.next.setPrev(newNode);
            newNode.setPrev(result.getPrev());
            newNode.setNext(result.getNext());
        }
        return result.value;
    }
    @Override
    public void clear() {
        size = 0;
        head.next = null;
        head.prev = null;
        head = null;
        tail.next = null;
        tail.prev = null;
        tail = null;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public boolean contains(Object value) {
        Node current = head;
        int count = 0;
        while(count != size){
            if(current.value.equals(value)){
                return true;
            }
            current = current.next;
            count++;
        }
        return false;
    }
    @Override
    public int indexOf(Object value) {
        Node current = head;
        for (int i = 0; i < size; i++){
            if (current.value == value) {
                return i;
            } else {
                current = current.next;
            }
        }
        return -1;
    }
    @Override
    public int lastIndexOf(Object value) {
        Node current = tail;
        for (int i = size - 1; i >= size; i--) {
            if(current.value == value){
                return i;
            }else{
                current = current.prev;
            }
        }
        return -1;
    }
    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "(", ")");
        Node current = head;
        while (current != null) {
            stringJoiner.add(current.getValue().toString());
            current = current.getNext();
        }
        return stringJoiner.toString();
    }
}
