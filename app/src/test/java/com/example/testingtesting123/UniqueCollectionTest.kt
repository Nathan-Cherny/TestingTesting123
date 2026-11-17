package com.example.testingtesting123

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }


    @Test
    fun addAnItem() {
        val originalSize = collection.size()
        collection.addItem(Item("item1"))
        val newSize = collection.size()
        assert(originalSize == 0 && newSize == 1) {"Couldn't add an item"}
        assert(collection.get(newSize - 1) == Item("item1"))
    }

    // Uniqueness is determined by the Item.name property, which is set via the constructor
    @Test
    fun addUniqueItem() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("item2"))
        collection.addItem(Item("item2"))
        assert(collection.size() == 2) {"Not a set"}
    }

    // Test Driven Development (TDD) test - complete specified function so that this test passes
    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }
}