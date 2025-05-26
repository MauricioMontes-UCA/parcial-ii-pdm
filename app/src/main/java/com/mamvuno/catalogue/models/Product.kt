package com.mamvuno.catalogue.models

data class Product(
    val id: Int,
    val name: String,
    val category: String,
    val price: Float,
    val description: String,
    val imageURL: String,
    var addedToCart: Boolean
)