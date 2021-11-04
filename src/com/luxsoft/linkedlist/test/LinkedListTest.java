package com.luxsoft.linkedlist.test;
import com.luxsoft.linkedlist.list.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class LinkedListTest {
    @DisplayName("Test to string return good text")
    @Test
    public void testToStringReturnGoodText(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("Tolik");
        linkedList.add("The");
        linkedList.add("Best");
        assertEquals("(Tolik, The, Best)", linkedList.toString());
    }
    @DisplayName("test Last Index Of Return Negative When Object Does Not Contains")
    @Test
    public void testLastIndexOfReturnNegativeWhenObjectDoesNotContains(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        assertEquals(-1, linkedList.lastIndexOf("C"));
    }
    @DisplayName("test Index Of Return Negative When Object Does Not Contains")
    @Test
    public void testIndexOfReturnNegativeWhenObjectDoesNotContains(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        assertEquals(-1, linkedList.indexOf("C"));
    }
    @DisplayName("test Index Of Return Index")
    @Test
    public void testIndexOfReturnIndex(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("B");
        assertEquals(1, linkedList.indexOf("B"));
    }
    @DisplayName("test Contains Return True When Object Contains")
    @Test
    public void testContainsReturnTrueWhenObjectContains(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        assertTrue(linkedList.contains("A"));
    }
    @DisplayName("test Contains Return False When Object Not Contains")
    @Test
    public void testContainsReturnFalseWhenObjectNotContains(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("B");
        linkedList.add("C");
        assertFalse(linkedList.contains("A"));
    }
    @DisplayName("test Add And Size Work Correctly")
    @Test
    public void testAddAndSizeWorkCorrectly(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        assertEquals(1,linkedList.size());
        linkedList.add("B");
        assertEquals(2,linkedList.size());
        linkedList.add("C");
        assertEquals(3,linkedList.size());
    }
    @DisplayName("test Add And Size And Clear Work And IsEmpty Correctly")
    @Test
    public void testAddAndSizeAndClearWorkAndIsEmptyCorrectly(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        assertEquals(1,linkedList.size());
        linkedList.clear();
        assertTrue(linkedList.isEmpty());
        assertEquals(0,linkedList.size());
    }
    @DisplayName("test Add With Index And Remove Work Correctly")
    @Test
    public void testAddWithIndexAndRemoveWorkCorrectly(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B",0);
        linkedList.add("C",0);
        linkedList.add("D",0);
        assertEquals("D",linkedList.remove(0));
        assertEquals("C",linkedList.remove(0));
        assertEquals("B",linkedList.remove(0));
        assertEquals("A",linkedList.remove(0));
        assertEquals(0,linkedList.size());
    }
    @DisplayName("test Add ThrowIndexOutOfBoundsException When List IsEmpty")
    @Test
    public void testAddThrowIndexOutOfBoundsExceptionWhenListIsEmpty() {
        LinkedList linkedList = new LinkedList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.remove(1);
            linkedList.get(1);
            linkedList.set("A", 1);
        });
    }
    @DisplayName("test Get ThrowIndexOutOfBoundsExceptionWhen List IsEmpty")
    @Test
    public void testGetThrowIndexOutOfBoundsExceptionWhenListIsEmpty() {
        LinkedList linkedList = new LinkedList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(1));
    }
    @DisplayName("test Set ThrowIndexOutOfBoundsException When List IsEmpty")
    @Test
    public void testSetThrowIndexOutOfBoundsExceptionWhenListIsEmpty() {
        LinkedList linkedList = new LinkedList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.set("A", 1));
    }
    @DisplayName("test Remove ThrowIndexOutOfBoundsException When List IsEmpty")
    @Test
    public void testRemoveThrowIndexOutOfBoundsExceptionWhenListIsEmpty() {
        LinkedList linkedList = new LinkedList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(1));
    }
    @DisplayName("test Get ThrowIndexOutOfBoundsException When Index Is Out Of Size")
    @Test
    public void testGetThrowIndexOutOfBoundsExceptionWhenIndexIsOutOfSize() {
        LinkedList linkedList = new LinkedList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.add("A");
            linkedList.add("B");
            linkedList.get(2);
        });
    }
    @DisplayName("test Add And Get And Size Work Correctly")
    @Test
    public void testAddAndGetAndSizeWorkCorrectly() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("A",2);
        linkedList.add("B",3);
        assertEquals("A",linkedList.get(0));
        assertEquals(4,linkedList.size());
        assertEquals("B",linkedList.get(1));
        assertEquals(4,linkedList.size());
        assertEquals("A",linkedList.get(2));
        assertEquals(4,linkedList.size());
        assertEquals("B",linkedList.get(3));
        assertEquals(4,linkedList.size());
    }
}