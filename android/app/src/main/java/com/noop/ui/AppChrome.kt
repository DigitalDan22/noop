package com.noop.ui

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Screen metrics used on every Android device: side inset, card rhythm, and bottom-bar sizing.
 * The sky draws under the status bar; these numbers keep text and the glass bar clear of it.
 */
internal object AppChrome {
    val screenHorizontal = 16.dp
    val screenBottomClearance = 16.dp
    val screenRowSpacing = 16.dp
    val todayRowSpacing = 16.dp
    val cardPadding = 18.dp
    val navIcon = 22.dp
    val navLabel = 12.sp
    val navOuterHorizontal = 12.dp
    val navVertical = 8.dp
}
