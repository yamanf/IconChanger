package com.yamanf.iconchanger

import androidx.annotation.DrawableRes


data class AppIcon(
    val id : String,
    val component: String,
    @DrawableRes
    val foregroundResource: Int
)

val appIcons : List<AppIcon> = listOf(
    AppIcon(
        id = "default",
        component = "com.yamanf.iconchanger.MainActivity",
        foregroundResource = R.mipmap.ic_launcher_default
    ),
    AppIcon(
        id = "smile",
        component = "com.yamanf.iconchanger.MainActivitySmile",
        foregroundResource = R.mipmap.ic_launcher_smile
    ),
    AppIcon(
        id = "tongue",
        component = "com.yamanf.iconchanger.MainActivityTongue",
        foregroundResource = R.mipmap.ic_launcher_tongue
    ),
    AppIcon(
        id = "sad",
        component = "com.yamanf.iconchanger.MainActivitySad",
        foregroundResource = R.mipmap.ic_launcher_sad
    )
)