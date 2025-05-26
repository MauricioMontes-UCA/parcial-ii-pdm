package com.mamvuno.catalogue.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.mamvuno.catalogue.models.Product
import com.mamvuno.catalogue.ui.Screens.ProductDetails
import com.mamvuno.catalogue.ui.navigation.DetailsScreen

@Composable
fun ProductCard(
    product: Product,
    navController: NavController
){
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(5.dp)
            .clickable{ navController.navigate(DetailsScreen(product.id))}
    ){
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            AsyncImage(
                model = product.imageURL,
                contentDescription = "Imagen de producto",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Column (
                modifier = Modifier.fillMaxHeight()
            ){
                Text(product.name)
                Text("Categoría: ${product.category}")
                Text("$${product.price}")
            }
        }
    }
}