package com.example.progallery

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun FullScreenViewer(
    media:   GalleryMedia,
    onClose: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (media.isVideo) {
            VideoPlayer(uri = media.uri)
        } else {
            AsyncImage(
                model          = media.uri,
                contentDescription = null,
                modifier       = Modifier.fillMaxSize(),
                contentScale   = ContentScale.Fit
            )
        }
        IconButton(
            onClick = onClose,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }
    }
}