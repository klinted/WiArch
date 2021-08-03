package com.friple.wiarch.ui.base

import androidx.recyclerview.widget.DiffUtil
import com.friple.widgetlibrary.data.base.BaseWidget

class WidgetDiffUtilCallback(
    private val oldItems: List<BaseWidget>,
    private val newItems: List<BaseWidget>
) : DiffUtil.Callback() {


    override fun getOldListSize(): Int = oldItems.size

    override fun getNewListSize(): Int = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldItems[oldItemPosition]
        val newItem = newItems[newItemPosition]
        return oldItem.isSameContent(newItem)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldItems[oldItemPosition]
        val newItem = newItems[newItemPosition]
        return oldItem.isSame(newItem)
    }
}