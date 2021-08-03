package com.friple.widgetlibrary.domain

import com.friple.widgetlibrary.data.base.Ids
import com.friple.widgetlibrary.domain.api.WidgetConfig
import com.friple.widgetlibrary.domain.interactor.WidgetInteractor

class WidgetBuilder(
    listener: OnWidgetsResultListener
) {

    private val interactor = WidgetInteractor(listener)

    fun build(config: WidgetConfig) {
        when (config.id) {
            Ids.TOP_BAR_WIDGET_ID -> interactor.useCaseHolder.updateTopBarWidget(config)
            Ids.TITLE_WIDGET_ID -> interactor.useCaseHolder.updateTitleWidget(config)
            Ids.STATS_WIDGET_ID -> interactor.useCaseHolder.updateStatsWidget(config)
            else -> error("Error id of main screen widget!")
        }
    }
}