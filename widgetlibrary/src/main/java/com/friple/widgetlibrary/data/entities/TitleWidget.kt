package com.friple.widgetlibrary.data.entities

import com.friple.widgetlibrary.data.base.BaseWidget
import com.friple.widgetlibrary.data.base.WidgetType


data class TitleWidget(
    override var id: Int,
    override var position: Int,
    override var type: WidgetType,
    val title: String
) : BaseWidget() {

    override fun isSame(other: BaseWidget): Boolean {
        return if (other is TitleWidget) {
            this.id == other.id
        } else {
            false
        }
    }

    override fun isSameContent(other: BaseWidget): Boolean {
        return if (other is TitleWidget) {
            this.position == other.position
                    && this.type == other.type
                    && this.title == other.title
        } else {
            false
        }
    }
}