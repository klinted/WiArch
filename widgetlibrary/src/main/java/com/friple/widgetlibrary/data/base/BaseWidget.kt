package com.friple.widgetlibrary.data.base

abstract class BaseWidget() {

    abstract var id: Int
    abstract var position: Int
    abstract var type: WidgetType

    abstract fun isSame(other: BaseWidget): Boolean
    abstract fun isSameContent(other: BaseWidget): Boolean
}