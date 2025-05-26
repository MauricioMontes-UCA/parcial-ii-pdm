package com.mamvuno.catalogue.ui.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mamvuno.catalogue.ui.components.ProductCard
import com.mamvuno.catalogue.ui.navigation.MainScreen
import com.mamvuno.catalogue.ui.viewModel.ProductViewModel

@Composable
fun ShoppingCart(
    navController: NavController,
    productViewModel: ProductViewModel
){
    val cartItems = productViewModel.getCartItems()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = { navController.navigate(MainScreen) }
        ) {
            Text("Regresar")
        }

        LazyColumn {
            items(cartItems){
                item ->
                ProductCard(item, navController)
            }
        }
    }
}