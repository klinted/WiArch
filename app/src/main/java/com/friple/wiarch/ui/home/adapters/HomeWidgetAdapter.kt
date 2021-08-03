package com.friple.wiarch.ui.home.adapters

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.friple.wiarch.ui.base.WidgetDiffUtilCallback
import com.friple.wiarch.ui.base.WidgetViewHolder
import com.friple.widgetlibrary.data.base.BaseWidget

class HomeWidgetAdapter(
    context: Context,
    private val viewPool : RecyclerView.RecycledViewPool,
//    private val callbackManager: MainScreenCallbackManager
) : RecyclerView.Adapter<WidgetViewHolder>() {

    private val widgetFactory = HomeWidgetFactory(context)

    var widgetList = emptyList<BaseWidget>()
    set(value) {
        val callback = WidgetDiffUtilCallback(field, value)
        val result = DiffUtil.calculateDiff(callback)
        field = value
        result.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WidgetViewHolder {
        return widgetFactory.createViewHolder(parent, viewType, viewPool)
    }

    override fun onBindViewHolder(holder: WidgetViewHolder, position: Int) {
        holder.bind(widgetList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return widgetFactory.getViewTypeForWidget(widgetList[position])
    }

    override fun getItemCount(): Int = widgetList.size
}