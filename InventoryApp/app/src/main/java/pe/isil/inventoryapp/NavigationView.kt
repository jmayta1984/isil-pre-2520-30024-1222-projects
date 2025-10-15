package pe.isil.inventoryapp

import androidx.compose.runtime.Composable
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
    val selectedProduct = remember{
        mutableStateOf<Product?>(null)
    }

    NavHost(navController, startDestination = "product_list", modifier = modifier) {

        composable("product_list") {
            ProductListView {
                navController.navigate("product_detail")
            }
        }

        composable("product_detail") {
            ProductDetailView()
        }
    }

}