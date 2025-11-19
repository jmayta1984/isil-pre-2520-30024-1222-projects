package pe.isil.easypet.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.isil.easypet.domain.models.Product
import pe.isil.easypet.domain.repositories.ProductRepository

class ProductListViewModel(private val repository: ProductRepository) : ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    fun getAllProducts() {
        viewModelScope.launch {
            _products.value = repository.getAllProducts()
        }
    }

    fun toggleFavorite(product: Product) {
        viewModelScope.launch {
            repository.toggleFavorite(product)
        }
        getAllProducts()
    }

    init {
        getAllProducts()
    }
}