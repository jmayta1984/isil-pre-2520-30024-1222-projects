package pe.isil.easytravel.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun DestinationListView(
    modifier: Modifier = Modifier,
    viewModel: DestinationListViewModel
) {

    val destinations = viewModel.destinations.collectAsState()

    LazyColumn(modifier = modifier) {
        items(destinations.value) { destination ->
            Text(destination.title)
        }
    }

}