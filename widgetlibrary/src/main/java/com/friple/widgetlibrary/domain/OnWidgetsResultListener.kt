package com.friple.widgetlibrary.domain

import com.friple.widgetlibrary.data.base.BaseWidget
import com.friple.widgetlibrary.domain.usecases.BaseUseCase

interface OnWidgetsResultListener {

    fun onWidgetsResult(result: List<BaseWidget>)
}