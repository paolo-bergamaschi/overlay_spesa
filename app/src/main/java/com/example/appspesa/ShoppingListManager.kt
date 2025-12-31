package com.example.appspesa

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object ShoppingListManager {
    private val _items = MutableLiveData<List<String>>(listOf("Latte", "Pane", "Uova", "Pasta"))
    val items: LiveData<List<String>> = _items

    private var currentIndex = 0

    fun getNextItem(): String? {
        val currentList = _items.value ?: return null
        if (currentList.isEmpty()) return "Lista vuota"
        
        val item = currentList[currentIndex]
        currentIndex = (currentIndex + 1) % currentList.size
        return item
    }
    
    fun getCurrentItem(): String {
        val currentList = _items.value ?: return "Nessun dato"
        if (currentList.isEmpty()) return "Lista vuota"
        // Return current without incrementing (for initial display)
        // Adjust logic as needed if we want "Next" to drive it strictly
         return currentList[if (currentIndex >= currentList.size) 0 else currentIndex]
    }

    fun addItem(item: String) {
        val list = _items.value?.toMutableList() ?: mutableListOf()
        list.add(item)
        _items.value = list
    }
}
