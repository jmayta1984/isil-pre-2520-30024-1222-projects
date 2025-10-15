package pe.isil.inventoryapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun ProductDetailView(
    modifier: Modifier = Modifier,
    product: Product? = null,
    onSave: (Product) -> Unit = {}
) {

    val name = remember { mutableStateOf("") }
    val quantity = remember { mutableStateOf("") }
    val price = remember { mutableStateOf("") }

    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {
            onSave(
                Product(
                    name = name.value,
                    quantity = quantity.value.toIntOrNull() ?: 0,
                    price = price.value.toDoubleOrNull() ?: 0.0
                )
            )
        }) {
            Icon(
                Icons.Default.Save,
                contentDescription = "add"
            )
        }
    }) { paddingValues ->

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                value = name.value, onValueChange = { value ->
                    name.value = value
                },
                placeholder = {
                    Text(text = "Name")
                }
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                value = quantity.value, onValueChange = { value ->
                    quantity.value = value
                },
                placeholder = {
                    Text(text = "Quantity")
                }
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                value = price.value, onValueChange = { value ->
                    price.value = value
                },
                placeholder = {
                    Text(text = "Price")
                }
            )
        }
    }
}