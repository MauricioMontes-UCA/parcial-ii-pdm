package com.mamvuno.catalogue.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object MainScreen

@Serializable
data class DetailsScreen(val id: Int)

@Serializable
object _ShoppingCart