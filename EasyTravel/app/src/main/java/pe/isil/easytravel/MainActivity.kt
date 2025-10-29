package pe.isil.easytravel

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
import pe.isil.easytravel.di.Module.getDestinationListViewModel
import pe.isil.easytravel.presentation.DestinationListView
import pe.isil.easytravel.presentation.DestinationListViewModel
import pe.isil.easytravel.ui.theme.EasyTravelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EasyTravelTheme {
                Scaffold { innerPadding ->
                    DestinationListView(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = getDestinationListViewModel()
                        )
                }
            }
        }
    }
}
