package pe.isil.easycommerce

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.isil.easycommerce.core.ui.theme.EasyCommerceTheme
import pe.isil.easycommerce.di.AppModule.getProductsViewModel
import pe.isil.easycommerce.presentation.ProductsViews

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EasyCommerceTheme {
                ProductsViews(getProductsViewModel())
            }
        }
    }
}
