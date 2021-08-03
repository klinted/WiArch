package com.friple.widgetlibrary.domain.interactor

import com.friple.widgetlibrary.data.base.BaseWidget
import com.friple.widgetlibrary.data.entities.StatsWidget
import com.friple.widgetlibrary.data.entities.TitleWidget
import com.friple.widgetlibrary.data.entities.TopBarWidget
import com.friple.widgetlibrary.domain.OnWidgetsResultListener
import com.friple.widgetlibrary.domain.usecases.*
import kotlinx.coroutines.*

class WidgetInteractor(
    private val listener: OnWidgetsResultListener
) : OnUseCaseResultListener {

    private var _widgets = emptyList<BaseWidget>()
        set(value) {
            listener.onWidgetsResult(value)
        }


    private val scope = CoroutineScope(Job() + Dispatchers.Main)


    private val widgetHolder = WidgetHolder()
    val useCaseHolder = UseCaseHolder(scope, this)


    override fun onUseCaseResult(useCase: BaseUseCase<*, *>, result: Any?) {
        when(useCase) {
            useCaseHolder.topBarUseCase -> {
                result?.let { widgetHolder.topBarWidgets.add(it as TopBarWidget) }
            }
            useCaseHolder.titleUseCase -> {
                result?.let { widgetHolder.titleWidgets.add(it as TitleWidget) }
            }
            useCaseHolder.statsUseCase -> {
                result?.let { widgetHolder.statsWidgets.add(it as StatsWidget) }
            }
        }
        collectWidgetsAsync()
    }


    private fun collectWidgetsAsync() = scope.launch {
        collectWidgets()
    }

    private fun collectWidgets() {
        val widgets = mutableListOf<BaseWidget>()

        widgets.addAll(widgetHolder.topBarWidgets)

        widgets.addAll(widgetHolder.titleWidgets)

        widgets.addAll(widgetHolder.statsWidgets)

        _widgets = widgets
    }
}