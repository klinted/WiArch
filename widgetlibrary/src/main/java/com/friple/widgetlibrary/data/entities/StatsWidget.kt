package com.friple.widgetlibrary.data.entities

import com.friple.widgetlibrary.data.base.BaseWidget
import com.friple.widgetlibrary.data.base.WidgetType


data class StatsWidget(
    override var id: Int,
    override var position: Int,
    override var type: WidgetType
) : BaseWidget() {


    override fun isSame(other: BaseWidget): Boolean {
        return if (other is StatsWidget) {
            this.id == other.id
        } else {
            false
        }
    }

    override fun isSameContent(other: BaseWidget): Boolean {
        return if (other is StatsWidget) {
            this.position == other.position
                    && this.type == other.type
        } else {
            false
        }
    }
}