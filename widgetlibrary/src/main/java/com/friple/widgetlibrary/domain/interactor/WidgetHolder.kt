package com.friple.widgetlibrary.domain.interactor

import com.friple.widgetlibrary.data.entities.StatsWidget
import com.friple.widgetlibrary.data.entities.TitleWidget
import com.friple.widgetlibrary.data.entities.TopBarWidget

data class WidgetHolder(
    var topBarWidgets: MutableList<TopBarWidget> = mutableListOf(),
    var titleWidgets: MutableList<TitleWidget> = mutableListOf(),
    var statsWidgets: MutableList<StatsWidget> = mutableListOf(),
)