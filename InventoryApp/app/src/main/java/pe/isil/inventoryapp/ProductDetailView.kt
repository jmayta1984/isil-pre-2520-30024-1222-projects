package pe.isil.inventoryapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ProductDetailView(
    modifier: Modifier = Modifier,
    product: Product? = null,
    onDelete: (Product) -> Unit = {},
    onSave: (Product) -> Unit = {}
) {

    val name = remember { mutableStateOf(product?.name ?: "") }
    val price = remember { mutableStateOf(product?.price?.toString() ?: "") }
    val quantity = remember { mutableStateOf(product?.quantity?.toString() ?: "") }

    val isEdit = product != null
    val isEnabled = remember {
        mutableStateOf(product == null)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        if (product == null) "New product" else "Edit product",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                },
                actions = {
                    if (isEdit) {
                        IconButton(onClick = {
                            isEnabled.value = !isEnabled.value
                        }) {
                            Icon(
                                Icons.Default.Edit,
                                contentDescription = "edit"
                            )
                        }
                    }


                }
            )
        },
        floatingActionButton = {

            FloatingActionButton(
                onClick = {
                    if (product == null) {
                        onSave(
                            Product(
                                name = name.value,
                                quantity = quantity.value.toIntOrNull() ?: 0,
                                price = price.value.toDoubleOrNull() ?: 0.0
                            )
                        )
                    } else {
                        product.name = name.value
                        product.quantity = quantity.value.toIntOrNull() ?: 0
                        product.price = price.value.toDoubleOrNull() ?: 0.0
                        onSave(product)
                    }


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
                },
                enabled = isEnabled.value
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
                },
                enabled = isEnabled.value
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
                },
                enabled = isEnabled.value
            )

            if (isEdit) {
                Button(
                    enabled = isEnabled.value,
                    onClick = {
                        onDelete(product)
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text("Remove product")
                }
            }

        }
    }
}