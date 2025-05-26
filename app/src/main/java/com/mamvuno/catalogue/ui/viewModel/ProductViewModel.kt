package com.mamvuno.catalogue.ui.viewModel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mamvuno.catalogue.data.ProductRepository
import com.mamvuno.catalogue.models.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class ProductViewModel(private val productRepository: ProductRepository): ViewModel() {
    private val _productList = MutableStateFlow<List<Product>>(emptyList())

    private val _query = MutableStateFlow<String>("")
    val query: StateFlow<String> = _query

    val filteredList: StateFlow<List<Product>> = query.map { text ->
        _productList.value.filter { it.name.contains(text, true) || it.category.contains(text, true) }
    }.stateIn(viewModelScope, SharingStarted.Lazily, _productList.value)

    init {
        _productList.value = productRepository.getProducts()
    }

    fun findProductById(id: Int): Product {
        return _productList.value.find { it.id == id }!!
    }

    fun setQuery(text: String){
        _query.value = text
    }

    fun addToCart(product: Product) {
        product.addedToCart = true
    }

    fun getCartItems(): List<Product>{
        val items = mutableListOf<Product>()

        _productList.value.forEach {
            item -> if (item.addedToCart) items.add(item)
        }

        return items
    }
}