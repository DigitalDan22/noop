package com.noop.ui

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PixelDevicesTest {
    @Test fun pixel10ProMatches() {
        assertTrue(PixelDevices.isPixel9OrNewer("Google", "Pixel 10 Pro", "blazer"))
    }

    @Test fun pixel9FamilyMatches() {
        assertTrue(PixelDevices.isPixel9OrNewer("Google", "Pixel 9", "tokay"))
        assertTrue(PixelDevices.isPixel9OrNewer("Google", "Pixel 9 Pro XL", "komodo"))
        assertTrue(PixelDevices.isPixel9OrNewer("Google", "Pixel 9a", "tegu"))
        assertTrue(PixelDevices.isPixel9OrNewer("google", "Pixel 10 Pro Fold", "rango"))
    }

    @Test fun codenameAloneMatchesWhenModelOmitsTheGeneration() {
        assertTrue(PixelDevices.isPixel9OrNewer("Google", "sdk", "mustang"))
    }

    @Test fun olderPixelsAndOtherPhonesDoNotMatch() {
        assertFalse(PixelDevices.isPixel9OrNewer("Google", "Pixel 8 Pro", "husky"))
        assertFalse(PixelDevices.isPixel9OrNewer("Google", "Pixel 7", "panther"))
        assertFalse(PixelDevices.isPixel9OrNewer("Google", "Pixel Fold", "felix"))
        assertFalse(PixelDevices.isPixel9OrNewer("Google", "Pixel Tablet", "tangorpro"))
        assertFalse(PixelDevices.isPixel9OrNewer("samsung", "Pixel 10 Pro", "blazer"))
        assertFalse(PixelDevices.isPixel9OrNewer("Google", "sdk_gphone64_x86_64", "emu64xa"))
    }
}
