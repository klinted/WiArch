package com.friple.widgetlibrary.domain.api

import com.friple.widgetlibrary.data.base.Ids
import com.friple.widgetlibrary.data.base.WidgetType

data class WidgetConfig(
    var id: Int,
    var position: Int,
    var type: WidgetType,
) {
    
    companion object {
        fun getInstance(): List<WidgetConfig> {
            return listOf(
                WidgetConfig(Ids.TOP_BAR_WIDGET_ID, 0, WidgetType.USUAL),
                WidgetConfig(Ids.TITLE_WIDGET_ID, 1, WidgetType.USUAL),
                WidgetConfig(Ids.STATS_WIDGET_ID, 2, WidgetType.USUAL),
                WidgetConfig(Ids.TITLE_WIDGET_ID, 3, WidgetType.USUAL),
                WidgetConfig(Ids.STATS_WIDGET_ID, 4, WidgetType.USUAL),
                WidgetConfig(Ids.TITLE_WIDGET_ID, 5, WidgetType.USUAL),
                WidgetConfig(Ids.STATS_WIDGET_ID, 6, WidgetType.USUAL),
                WidgetConfig(Ids.TITLE_WIDGET_ID, 7, WidgetType.USUAL),
                WidgetConfig(Ids.STATS_WIDGET_ID, 8, WidgetType.USUAL),
                WidgetConfig(Ids.TITLE_WIDGET_ID, 9, WidgetType.USUAL),
                WidgetConfig(Ids.STATS_WIDGET_ID, 10, WidgetType.USUAL),
                WidgetConfig(Ids.TITLE_WIDGET_ID, 11, WidgetType.USUAL),
                WidgetConfig(Ids.STATS_WIDGET_ID, 12, WidgetType.USUAL),
            )
        }
    }
}