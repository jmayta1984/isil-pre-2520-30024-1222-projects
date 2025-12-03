package pe.isil.videoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.net.toUri
import pe.isil.videoapp.ui.theme.VideoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val uri =
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4".toUri()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val modifier = Modifier.fillMaxSize()
            VideoAppTheme {
                Surface(modifier = modifier) {
                    Column(modifier = modifier.fillMaxSize()) {
                        VideoPlayer(uri, modifier)
                    }
                }
            }
        }
    }
}
