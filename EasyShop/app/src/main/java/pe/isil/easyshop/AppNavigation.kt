package pe.isil.easyshop

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.isil.easyshop.ui.theme.EasyShopTheme

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    val username = remember {
        mutableStateOf("")
    }

    NavHost(navController, startDestination = Routes.Login.route) {
        composable(Routes.Login.route) {
            LoginScreen { value ->
                navController.navigate(Routes.Home.route)
                username.value = value
            }
        }
        composable(Routes.Home.route) {
            HomeScreen(username.value)
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