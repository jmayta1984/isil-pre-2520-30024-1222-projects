package pe.isil.easyshop

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.isil.easyshop.ui.theme.EasyShopTheme

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "login") {
        composable("login") {
            Login(navController)
        }
        composable("home") {
            Home()
        }

    }

}

@Preview(showBackground = true)
@Composable
fun AppNavigationPreview() {
    EasyShopTheme(dynamicColor = false) {
        AppNavigation()
    }
}