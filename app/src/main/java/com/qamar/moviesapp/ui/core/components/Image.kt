package com.qamar.moviesapp.ui.core.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.request.ImageRequest

@Composable
fun AsyncImage(
    imageUrl: Any,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit
) {
    coil.compose.AsyncImage(
        modifier = modifier,
        model = ImageRequest.Builder(LocalContext.current).data(imageUrl)
            .crossfade(true)
            .build(),
        contentDescription = "",
        contentScale = contentScale,
    )
}
