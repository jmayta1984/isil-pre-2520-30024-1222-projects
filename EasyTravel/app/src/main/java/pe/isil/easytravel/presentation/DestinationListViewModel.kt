package pe.isil.easytravel.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.isil.easytravel.domain.Destination
import pe.isil.easytravel.domain.DestinationRepository

class DestinationListViewModel(private val repository: DestinationRepository): ViewModel() {
    private val _destinations = MutableStateFlow<List<Destination>>(emptyList())
    val destinations: StateFlow<List<Destination>> = _destinations

    private val _category = MutableStateFlow("All")
    val category: StateFlow<String> = _category

    fun onCategoryChanged(value: String) {
        _category.value = value
        getDestinations()
    }

    fun getDestinations(){
        viewModelScope.launch {
         _destinations.value = repository.getDestinations( if (category.value == "All") "" else category.value )
        }
    }

    init {
        getDestinations()
    }
}