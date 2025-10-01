package pe.isil.easyshop

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pe.isil.easyshop.ui.theme.EasyShopTheme

@Composable
fun AppNavigation() {
    val navController = rememberNavController()


    NavHost(navController, startDestination = Routes.Login.route) {
        composable(Routes.Login.route) {
            LoginScreen { user ->
                navController.navigate("${Routes.Home.route}/$user")
            }
        }
        composable(
            route = Routes.Home.routeWithArgument,
            arguments = listOf(navArgument(Routes.Home.argument) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.let { arguments ->
                val user = arguments.getString(
                    Routes.Home.argument,
                    ""
                )
                HomeScreen(user)
            }

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