package com.friple.wiarch.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.friple.widgetlibrary.data.base.BaseWidget

abstract class WidgetViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(widget : BaseWidget)
    open fun bind(widget : BaseWidget, payload : Any){}
}