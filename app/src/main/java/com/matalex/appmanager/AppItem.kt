package com.matalex.appmanager

import android.graphics.drawable.Drawable

data class AppItem(
    val appIcon: Drawable?,
    val appName: String?,
    val appPackage: String,
    val appDate: String
)
