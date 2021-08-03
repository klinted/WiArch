package com.friple.wiarch.ui.home.widgets

import android.view.View
import android.view.ViewGroup
import com.friple.wiarch.R
import com.friple.wiarch.ui.base.WidgetViewHolder
import com.friple.wiarch.util.inflate
import com.friple.widgetlibrary.data.base.BaseWidget

class StatsWidgetViewHolder(view: View): WidgetViewHolder(view) {

    override fun bind(widget: BaseWidget) {

    }

    companion object {
        fun create(parent: ViewGroup): StatsWidgetViewHolder {
            val view = parent.inflate(R.layout.stats_widget)
            return StatsWidgetViewHolder(view)
        }
    }
}