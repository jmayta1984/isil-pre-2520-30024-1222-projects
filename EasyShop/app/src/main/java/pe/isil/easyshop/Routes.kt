package pe.isil.easyshop

sealed class Routes(val route: String) {
    object Login: Routes("login")
    object Home: Routes("home") {
        const val routeWithArgument = "home/{user}"
        const val argument = "user"
    }
}
