package com.friple.widgetlibrary.domain

import com.friple.widgetlibrary.data.base.BaseWidget
import com.friple.widgetlibrary.domain.api.WidgetConfig


class WidgetFactory(
    private val listener: OnWidgetsResultListener
) : OnWidgetsResultListener {

    private var _widgets = emptyList<BaseWidget>()
        set(value) {
            listener.onWidgetsResult(value)
        }


    fun updateWidgets() {
        val configs = WidgetConfig.getInstance()
        val widgetBuilder = WidgetBuilder(this)

        configs.forEach { config ->
            widgetBuilder.build(config)
        }
    }



    override fun onWidgetsResult(result: List<BaseWidget>) {
        collectWidgets(result)
    }


    private fun collectWidgets(result: List<BaseWidget>) {
        var widgets = result

        widgets = filterWidget(widgets)

        _widgets = widgets
    }

    private fun filterWidget(widgets: List<BaseWidget>): List<BaseWidget> {
        return widgets.sortedBy {
            it.position
        }
    }
}