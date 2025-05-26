package com.mamvuno.catalogue.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.mamvuno.catalogue.ui.Screens.ProductDetails
import com.mamvuno.catalogue.ui.Screens.ProductList
import com.mamvuno.catalogue.ui.Screens.ShoppingCart
import com.mamvuno.catalogue.ui.viewModel.ProductViewModel

@Composable
fun NavigationHost(productViewModel: ProductViewModel){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MainScreen
    ){
        composable<MainScreen>{
            ProductList(
                navController = navController,
                productViewModel = productViewModel
            )
        }
        composable<DetailsScreen>{
            backStackEntry -> val args = backStackEntry.toRoute<DetailsScreen>()
            val product = productViewModel.findProductById(args.id)

            ProductDetails(
                product = product,
                productViewModel = productViewModel,
                navController = navController
            )
        }
        composable<_ShoppingCart>{
            ShoppingCart(
                navController = navController,
                productViewModel =  productViewModel
            )
        }
    }
}
