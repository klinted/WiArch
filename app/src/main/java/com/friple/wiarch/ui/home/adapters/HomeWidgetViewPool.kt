package com.friple.wiarch.ui.home.adapters

import androidx.recyclerview.widget.RecyclerView
import com.friple.widgetlibrary.data.base.Ids

class HomeWidgetViewPool : RecyclerView.RecycledViewPool() {

    init {

        setMaxRecycledViews(
            Ids.TOP_BAR_WIDGET_ID,
            1
        )
        setMaxRecycledViews(
            Ids.TITLE_WIDGET_ID,
            5
        )
        setMaxRecycledViews(
            Ids.STATS_WIDGET_ID,
            1
        )
    }
}