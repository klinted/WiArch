package com.friple.wiarch.util

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes


fun ViewGroup.inflate(@LayoutRes layout : Int, attachToRoot : Boolean = false) : View {
    return context.inflate(layout, this, attachToRoot)
}