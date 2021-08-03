package com.friple.widgetlibrary.domain.usecases

import com.friple.widgetlibrary.data.entities.StatsWidget
import com.friple.widgetlibrary.domain.api.WidgetConfig

class StatsUseCase(
    listener: OnUseCaseResultListener
) : BaseUseCase<StatsWidget, WidgetConfig>(listener) {

    override suspend fun run(params: WidgetConfig): StatsWidget {
        return StatsWidget(
            id = params.id,
            position = params.position,
            type = params.type,
        )
    }
}