package pe.isil.easystore

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.isil.easystore.ui.theme.EasyStoreTheme

@Composable
fun Banner(modifier: Modifier = Modifier) {
    Box(modifier
        .fillMaxWidth()
        .height(256.dp),
        contentAlignment = Alignment.BottomEnd
        ) {

        Row (modifier
            .fillMaxWidth()
            .height(216.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)){

            Text("Special offer",
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.headlineSmall,
                modifier = modifier.padding(8.dp),
                fontWeight = FontWeight.SemiBold
                )

        }

        Image(
            painterResource(R.drawable.banner),
            contentDescription = null,
            modifier = modifier
                .fillMaxWidth(0.75f),
            contentScale = ContentScale.FillHeight
        )
    }

}


@Preview(showBackground = true)
@Composable
fun BannerPreview() {
    EasyStoreTheme {
        Banner()
    }
}