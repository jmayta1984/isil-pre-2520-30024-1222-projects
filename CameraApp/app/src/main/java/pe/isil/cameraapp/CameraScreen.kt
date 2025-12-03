package pe.isil.cameraapp

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.LocalLifecycleOwner
import java.io.File

@Composable
fun CameraScreen() {
    val context = LocalContext.current
    val cameraPermission = Manifest.permission.CAMERA

    val imageCapture = remember {
        mutableStateOf<ImageCapture?>(null)
    }

    val hasPermission = remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                cameraPermission
            ) == PackageManager.PERMISSION_GRANTED
        )
    }

    val permissionLauncher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { granted ->
            hasPermission.value = granted
        }

    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(true) {
        if (!hasPermission.value) {
            permissionLauncher.launch(cameraPermission)

        }
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {

                val file = createFile(context)

                val outputOptions = ImageCapture.OutputFileOptions.Builder(file).build()

                imageCapture.value?.takePicture(
                    outputOptions, ContextCompat.getMainExecutor(context),
                    object : ImageCapture.OnImageSavedCallback {
                        override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                            val message = "Capture photo succeed"
                            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                        }

                        override fun onError(exception: ImageCaptureException) {
                            Toast.makeText(context, exception.message, Toast.LENGTH_SHORT).show()

                        }

                    }
                )
            }) {
                Icon(Icons.Default.Check, contentDescription = null)
            }
        }

    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {


            if (hasPermission.value) {
                AndroidView(
                    modifier = Modifier,
                    factory = { context ->
                        val previewView = PreviewView(context)
                        val cameraProviderFuture = ProcessCameraProvider.getInstance(context)

                        cameraProviderFuture.addListener({
                            val cameraProvider = cameraProviderFuture.get()
                            val preview = Preview.Builder().build().also {
                                it.surfaceProvider = previewView.surfaceProvider
                            }
                            imageCapture.value = ImageCapture.Builder().build()
                            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

                            try {
                                cameraProvider.unbindAll()
                                cameraProvider.bindToLifecycle(
                                    lifecycleOwner,
                                    cameraSelector,
                                    preview,
                                    imageCapture.value
                                )
                            } catch (e: Exception) {
                                Log.e("CameraScreen", e.toString())
                            }
                        }, ContextCompat.getMainExecutor(context))

                        previewView
                    })
            } else {
                Text("Permission required")
            }
        }
    }
}

fun createFile(context: Context): File {
    val directory = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
    return File(directory, "IMG_${System.currentTimeMillis()}.jpg")
}