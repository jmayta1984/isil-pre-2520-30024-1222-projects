package pe.isil.inventoryapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Preview(showBackground = true)
@Composable
fun NavigationView(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val selectedProduct = remember {
        mutableStateOf<Product?>(null)
    }

    val products = remember {
        mutableStateListOf(
            Product(
                name = "Pants",
                price = 99.99,
                quantity = 2
            ),

            Product(
                name = "T-Shirt",
                price = 19.99,
                quantity = 5
            ),
        )
    }
    NavHost(navController, startDestination = "product_list", modifier = modifier) {

        composable("product_list") {
            ProductListView(
                products = products,
                onProductSelected = { product ->
                    selectedProduct.value = product
                    navController.navigate("product_detail")
                },
                onAdd = {
                    selectedProduct.value = null
                    navController.navigate("product_detail")
                }
            )
        }

        composable("product_detail") {
            ProductDetailView(
                product = selectedProduct.value,

                onDelete = { product ->
                    products.remove(product)
                    navController.popBackStack()

                }
            ) { product ->
                if (!products.contains(product)) {
                    products.add(product)
                }
                navController.popBackStack()
            }
        }

    }
}