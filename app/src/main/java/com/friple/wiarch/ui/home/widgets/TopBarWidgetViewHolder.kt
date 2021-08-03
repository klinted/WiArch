package com.friple.wiarch.ui.home.widgets

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.friple.wiarch.R
import com.friple.wiarch.ui.base.WidgetViewHolder
import com.friple.wiarch.util.inflate
import com.friple.widgetlibrary.data.base.BaseWidget
import com.friple.widgetlibrary.data.entities.TopBarWidget
import com.google.android.material.textview.MaterialTextView

class TopBarWidgetViewHolder(view: View): WidgetViewHolder(view) {

    private val leftImage: ImageView = view.findViewById(R.id.top_bar_left_image)
    private val title: MaterialTextView = view.findViewById(R.id.top_bar_title)
    private val rightImage: ImageView = view.findViewById(R.id.top_bar_right_image)

    override fun bind(widget: BaseWidget) {
        widget as TopBarWidget

        leftImage.setImageResource(widget.leftDrawableRes)
        title.text = widget.title
        rightImage.setImageResource(widget.rightDrawableRes)
    }

    companion object {
        fun create(parent: ViewGroup): TopBarWidgetViewHolder {
            val view = parent.inflate(R.layout.top_bar_widget)
            return TopBarWidgetViewHolder(view)
        }
    }
}