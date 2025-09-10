package pe.isil.easyshop

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.isil.easyshop.ui.theme.EasyShopTheme

@Composable
fun Login(){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
        ){

        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder =
                {
                    Text("Email")
                }
            ,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(8.dp),
            leadingIcon = {
                Icon(Icons.Default.Person,
                    contentDescription = null)
            }
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            placeholder = { Text("Password") },
            leadingIcon = {
                Icon(Icons.Default.Lock,
                    contentDescription = null)
            },
            shape = RoundedCornerShape(8.dp)
        )

        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            shape = RoundedCornerShape(8.dp)
            ) {
            Text("Sign in")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    EasyShopTheme (dynamicColor = false){
        Login()
    }
}
