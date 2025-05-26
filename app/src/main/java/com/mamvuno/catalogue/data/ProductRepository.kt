package com.mamvuno.catalogue.data

import com.mamvuno.catalogue.models.Product

class ProductRepository {
    fun getProducts(): List<Product> {
        return if (!products.isEmpty()) products else emptyList()
    }
}