package com.friple.wiarch.ui.home.adapters

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.friple.wiarch.ui.base.WidgetViewHolder
import com.friple.wiarch.ui.home.widgets.StatsWidgetViewHolder
import com.friple.wiarch.ui.home.widgets.TitleWidgetViewHolder
import com.friple.wiarch.ui.home.widgets.TopBarWidgetViewHolder
import com.friple.widgetlibrary.data.base.BaseWidget
import com.friple.widgetlibrary.data.base.Ids
import com.friple.widgetlibrary.data.entities.StatsWidget
import com.friple.widgetlibrary.data.entities.TitleWidget
import com.friple.widgetlibrary.data.entities.TopBarWidget

class HomeWidgetFactory(context: Context) {

    fun getViewTypeForWidget(widget: BaseWidget): Int {
        return when(widget) {
            is TopBarWidget -> {
                Ids.TOP_BAR_WIDGET_ID
            }
            is TitleWidget -> {
                Ids.TITLE_WIDGET_ID
            }
            is StatsWidget -> {
                Ids.STATS_WIDGET_ID
            }
            else -> error("Error widget for viewType!")
        }
    }

    fun createViewHolder(
        parent: ViewGroup,
        viewType: Int,
        viewPool: RecyclerView.RecycledViewPool
    ): WidgetViewHolder {
        val context = parent.context

        return when(viewType) {
            Ids.TOP_BAR_WIDGET_ID -> {
                TopBarWidgetViewHolder.create(parent)
            }
            Ids.TITLE_WIDGET_ID -> {
                TitleWidgetViewHolder.create(parent)
            }
            Ids.STATS_WIDGET_ID -> {
                StatsWidgetViewHolder.create(parent)
            }
            else -> error("Error viewType for create viewHolder!")
        }
    }
}