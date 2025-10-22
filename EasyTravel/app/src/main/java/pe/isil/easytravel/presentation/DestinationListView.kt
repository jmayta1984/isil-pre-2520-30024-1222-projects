package pe.isil.easytravel.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import pe.isil.easytravel.domain.Destination

@Composable
fun DestinationListView(modifier: Modifier = Modifier) {

    val destinations = remember {
        mutableStateOf<List<Destination>>(emptyList())
    }
    LazyColumn {
        items(destinations.value) { destination ->
            Text(destination.title)
        }
    }

}