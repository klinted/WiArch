package com.friple.wiarch.util

import android.content.Context
import android.graphics.Point
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.LayoutRes


val Context.windowManager : WindowManager
    get() {
    return getSystemService(Context.WINDOW_SERVICE) as WindowManager
}


fun Context.getScreenSize() : Point {
    val size = Point()
    windowManager.defaultDisplay.getSize(size)
    return size
}


fun Context.getScreenWidth() : Int {
    return getScreenSize().x
}

val Context.layoutInflater : LayoutInflater
    get() {
    return getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
}


fun Context.inflate(@LayoutRes layout : Int, parent : ViewGroup, attachToRoot : Boolean) : View {
    return layoutInflater.inflate(layout, parent, attachToRoot)
}