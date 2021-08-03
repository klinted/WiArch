package com.friple.widgetlibrary.data.entities

import com.friple.widgetlibrary.data.base.BaseWidget
import com.friple.widgetlibrary.data.base.WidgetType


data class TopBarWidget(
    override var id: Int,
    override var position: Int,
    override var type: WidgetType,
    val leftDrawableRes: Int,
    val rightDrawableRes: Int,
    val title: String
) : BaseWidget() {

    override fun isSame(other: BaseWidget): Boolean {
        return if (other is TopBarWidget) {
            this.id == other.id
        } else {
            false
        }
    }

    override fun isSameContent(other: BaseWidget): Boolean {
        return if (other is TopBarWidget) {
            this.position == other.position
                    && this.type == other.type
                    && this.leftDrawableRes == other.leftDrawableRes
                    && this.rightDrawableRes == other.rightDrawableRes
                    && this.title == other.title
        } else {
            false
        }
    }
}