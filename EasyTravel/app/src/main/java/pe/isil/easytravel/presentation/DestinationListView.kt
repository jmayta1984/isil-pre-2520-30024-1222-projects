package pe.isil.easytravel.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.isil.easytravel.domain.Destination

@Composable
fun DestinationListView(
    modifier: Modifier = Modifier,
    viewModel: DestinationListViewModel
) {

    val destinations = viewModel.destinations.collectAsState()
    val selectedCategory = viewModel.category.collectAsState()

    val categories = listOf("All", "Beach", "Adventure", "City", "Cultural")
    LazyColumn(modifier = modifier) {

        item {
            LazyRow {
                itemsIndexed(categories) { index, category ->
                    FilterChip(
                        selected = selectedCategory.value == category,
                        onClick = {
                            viewModel.onCategoryChanged(category)
                        },
                        label = { Text(category) },
                        modifier = Modifier
                            .padding(start = if (index == 0) 8.dp else 4.dp)
                            .padding(end = if (index == categories.size - 1) 8.dp else 4.dp)
                    )
                }
            }
        }
        items(destinations.value) { destination ->

            DestinationCard(destination)
        }
    }
}

@Composable
fun DestinationCard(destination: Destination) {
    Card(modifier = Modifier.padding(8.dp)) {
        Column {
            AsyncImage(
                destination.posterPath,
                contentDescription = destination.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(200.dp).fillMaxWidth()
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    destination.title,
                    style = MaterialTheme.typography.titleMedium,

                    )
                Text(
                    destination.overview,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1
                )
            }

        }
    }
}