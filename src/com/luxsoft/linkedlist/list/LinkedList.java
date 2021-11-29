package com.luxsoft.linkedlist.list;
import java.util.StringJoiner;
import java.util.Iterator;
public class LinkedList<T> implements List<T>, Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;
    @Override
    public void add(T value) {
        add(value,size);
    }
    @Override
    public void add(T value, int index) {
        if(value == null){
            throw new NullPointerException("You cannot add null element");
        }
        Node<T> newNode = new Node<T>(value);
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
            Node<T> current = head;
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
    public T remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("There is no element in that index");
        }
        Node<T> result = new Node<T>(null);
        if(size == 1){
            result = head;
            head = new Node<T>(null);
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
        return (T) result.value;
    }
    @Override
    public T get(int index) {
        if(index >= size){
            throw new IndexOutOfBoundsException("incorrect index");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return (T) current.getValue();
    }
    @Override
    public T set(T value, int index) {
        if(index >= size){
            throw new IndexOutOfBoundsException("There is no element in that index");
        }
        Node<T> newNode = new Node<T>(value);
        Node<T> result = head;
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
        return (T) result.value;
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
    public boolean contains(T value) {
        Node<T> current = head;
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
    public int indexOf(T value) {
        Node<T> current = head;
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
    public int lastIndexOf(T value) {
        Node<T> current = tail;
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
        if (isEmpty()) {
            return "[]";
        }
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (Object o : this) {
            stringJoiner.add(String.valueOf(o));
        }
        return stringJoiner.toString();
    }
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }
    private class LinkedListIterator implements Iterator<T> {
        private int position;
        @Override
        public boolean hasNext() {
            return position < size;
        }
        @Override
        public T next() {
            Node<T> node = getNode(position);
            position++;
            return (T) node.value;
        }
    }
    Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current;
        if (index < (size / 2)) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }
}
