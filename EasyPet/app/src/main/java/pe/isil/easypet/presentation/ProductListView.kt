package pe.isil.easypet.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.isil.easypet.di.Module.getProductListViewModel
import pe.isil.easypet.domain.models.Product

@Composable
fun ProductListView(
    modifier: Modifier = Modifier,
    viewModel: ProductListViewModel = getProductListViewModel()
) {
    val products by viewModel.products.collectAsState()

    LazyColumn(modifier = modifier) {
        items(products) { product ->
            ProductCard(product) {
                viewModel.toggleFavorite(product)
            }
        }
    }
}

@Composable
fun ProductCard(product: Product, onToggleFavorite: (Product) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            ProductImage(product, onToggleFavorite)
            Text(product.title, fontWeight = FontWeight.Bold)
            Text(product.description)
            Text(product.rating.toString())
        }
    }
}

@Composable
fun ProductImage(product: Product, onToggleFavorite: (Product) -> Unit) {
    Box(

        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopEnd
    ) {

        AsyncImage(
            model = product.posterPath,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(256.dp)
                .fillMaxWidth(),
            contentDescription = null
        )
        IconButton(onClick = {
            onToggleFavorite(product)
        }) {
            Icon(
                if (product.isFavorite) {
                    Icons.Default.Favorite
                } else {
                    Icons.Default.FavoriteBorder
                }, contentDescription = null
            )
        }
    }
}