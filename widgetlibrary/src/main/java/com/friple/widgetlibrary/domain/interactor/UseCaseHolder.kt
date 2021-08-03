package com.friple.widgetlibrary.domain.interactor

import com.friple.widgetlibrary.domain.api.WidgetConfig
import com.friple.widgetlibrary.domain.usecases.OnUseCaseResultListener
import com.friple.widgetlibrary.domain.usecases.StatsUseCase
import com.friple.widgetlibrary.domain.usecases.TitleUseCase
import com.friple.widgetlibrary.domain.usecases.TopBarUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

data class UseCaseHolder(
    private val scope: CoroutineScope,
    private val listener: OnUseCaseResultListener,
    val topBarUseCase: TopBarUseCase = TopBarUseCase(listener),
    val titleUseCase: TitleUseCase = TitleUseCase(listener),
    val statsUseCase: StatsUseCase = StatsUseCase(listener),
) {


    fun updateTopBarWidget(config: WidgetConfig) = scope.launch {
        val task = scope.async { topBarUseCase.use(config) }
        task.await()
    }

    fun updateTitleWidget(config: WidgetConfig) = scope.launch {
        val tasks = scope.async { titleUseCase.use(config) }
        tasks.await()
    }

    fun updateStatsWidget(config: WidgetConfig) = scope.launch {
        val tasks = scope.async { statsUseCase.use(config) }
        tasks.await()
    }
}