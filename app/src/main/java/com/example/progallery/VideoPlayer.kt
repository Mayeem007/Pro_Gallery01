package com.example.progallery

import android.net.Uri
import android.view.ViewGroup.LayoutParams
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.media3.common.MediaItem as ExoMediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.StyledPlayerView
import androidx.compose.ui.platform.LocalContext

@Composable
fun VideoPlayer(
    uri:      Uri,
    modifier: Modifier = Modifier.fillMaxSize()
) {
    val context = LocalContext.current
    val player  = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(ExoMediaItem.fromUri(uri))
            prepare()
            playWhenReady = true
        }
    }

    DisposableEffect(player) {
        onDispose { player.release() }
    }

    AndroidView(
        factory = {
            StyledPlayerView(it).apply {
                this.player = player
                layoutParams = LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT
                )
            }
        },
        modifier = modifier
    )
}