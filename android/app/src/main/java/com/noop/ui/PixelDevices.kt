package com.noop.ui

import android.os.Build

/**
 * Pixel 9 and newer, matched from the retail model string ("Pixel 10 Pro") and, when a
 * build reports only a codename, from the known Pixel 9 / 10 device names.
 *
 * Future Pixels keep working through the generation number in [Build.MODEL]. The codename
 * list only covers devices whose model string does not already say "Pixel 9" or higher.
 */
internal object PixelDevices {
    /** Debug-only preview. Release builds never read it. Set from a launch extra. */
    var previewEnabled: Boolean = false

    fun isCurrent(): Boolean {
        if (previewEnabled) return true
        return isPixel9OrNewer(Build.MANUFACTURER, Build.MODEL, Build.DEVICE)
    }

    fun isPixel9OrNewer(manufacturer: String, model: String, device: String): Boolean {
        if (!manufacturer.equals("Google", ignoreCase = true)) return false
        val haystack = "$model $device"
        val generation = PIXEL_GENERATION.find(haystack)?.groupValues?.getOrNull(1)?.toIntOrNull()
        if (generation != null) return generation >= 9
        return device.lowercase() in PIXEL_9_PLUS_CODENAMES
    }

    private val PIXEL_GENERATION = Regex("""pixel\s*(\d+)""", RegexOption.IGNORE_CASE)

    // Retail model strings already match the regex. These are the device codenames for the
    // same phones, so a build that reports the codename in DEVICE still opts in.
    private val PIXEL_9_PLUS_CODENAMES = setOf(
        "tokay",    // Pixel 9
        "caiman",   // Pixel 9 Pro
        "komodo",   // Pixel 9 Pro XL
        "comet",    // Pixel 9 Pro Fold
        "tegu",     // Pixel 9a
        "frankel",  // Pixel 10
        "blazer",   // Pixel 10 Pro
        "mustang",  // Pixel 10 Pro XL
    )
}
