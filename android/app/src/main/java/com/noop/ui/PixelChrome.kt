package com.noop.ui

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Layout numbers for the Pixel 9+ layer.
 *
 * [Standard] is the shipped layout, value for value. [Active] is what a Pixel 9 or newer
 * uses: the sky runs under the status bar, the side inset stops reading as a boxed column,
 * cards sit a little further apart, and the bottom bar's icon and label are large enough
 * to read on that screen.
 */
internal data class PixelChrome(
    val active: Boolean,
    val screenHorizontal: Dp,
    val screenBottomClearance: Dp,
    val screenRowSpacing: Dp,
    val todayRowSpacing: Dp,
    val cardPadding: Dp,
    val navIcon: Dp,
    val navLabel: TextUnit,
    val navOuterHorizontal: Dp,
    val navVertical: Dp,
) {
    companion object {
        val Standard = PixelChrome(
            active = false,
            screenHorizontal = 28.dp,
            screenBottomClearance = 28.dp,
            screenRowSpacing = 20.dp,
            todayRowSpacing = 12.dp,
            cardPadding = 16.dp,
            navIcon = 18.dp,
            navLabel = 10.sp,
            navOuterHorizontal = 22.dp,
            navVertical = 7.dp,
        )

        val Active = PixelChrome(
            active = true,
            screenHorizontal = 16.dp,
            screenBottomClearance = 16.dp,
            screenRowSpacing = 16.dp,
            todayRowSpacing = 16.dp,
            cardPadding = 18.dp,
            navIcon = 22.dp,
            navLabel = 12.sp,
            navOuterHorizontal = 12.dp,
            navVertical = 8.dp,
        )
    }
}

internal val LocalPixelChrome = staticCompositionLocalOf { PixelChrome.Standard }
