package com.mamvuno.catalogue.ui.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mamvuno.catalogue.ui.components.ProductCard
import com.mamvuno.catalogue.ui.navigation._ShoppingCart
import com.mamvuno.catalogue.ui.viewModel.ProductViewModel

@Composable
fun ProductList(
    productViewModel: ProductViewModel,
    navController: NavController
){
    val productList by productViewModel.filteredList.collectAsState()
    var query by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize()
    ){
        TextField(
            value = query,
            onValueChange = {
                query = it
                productViewModel.setQuery(query) },
            placeholder = { Text("Buscar producto...") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {navController.navigate(_ShoppingCart)}
        ) {
            Text("Ir al carrito")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn (
            modifier = Modifier.fillMaxSize()
        ){
            items(productList) { product ->
                ProductCard(
                    product = product,
                    navController = navController
                )
            }
        }
    }
}