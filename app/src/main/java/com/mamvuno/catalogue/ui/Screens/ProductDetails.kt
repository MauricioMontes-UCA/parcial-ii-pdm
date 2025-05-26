package com.mamvuno.catalogue.ui.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.mamvuno.catalogue.models.Product
import com.mamvuno.catalogue.ui.navigation.MainScreen
import com.mamvuno.catalogue.ui.viewModel.ProductViewModel

@Composable
fun ProductDetails(
    product: Product,
    productViewModel: ProductViewModel,
    navController: NavController
){
    Column (
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()

    ){
        AsyncImage(
            model = product.imageURL,
            contentDescription = "Imagen de producto",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(180.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Text(product.name)
        Text("$${product.price}")
        Text(product.description)
        Text(product.category)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {navController.navigate(MainScreen)}
            ) {
                Text("Regresar")
            }
            Button(
                onClick = {productViewModel.addToCart(product)}
            ) {
                Text("Agregar al carrito")
            }
        }

    }
}