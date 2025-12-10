package pe.isil.easycommerce.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.isil.easycommerce.domain.Product
import pe.isil.easycommerce.domain.ProductRepository

class ProductsViewModel
    (private val repository: ProductRepository) : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query

    fun searchProducts() {
        viewModelScope.launch {
            val products = repository.searchProducts(query.value)
            _products.value = products
        }
    }

    fun onQueryChange(value: String) {
        _query.value = value
    }

}