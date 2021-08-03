package com.friple.widgetlibrary.domain.usecases

import com.friple.widgetlibrary.data.entities.TitleWidget
import com.friple.widgetlibrary.domain.api.WidgetConfig

class TitleUseCase(
    listener: OnUseCaseResultListener
) : BaseUseCase<TitleWidget, WidgetConfig>(listener) {

    override suspend fun run(params: WidgetConfig): TitleWidget {
        return TitleWidget(
            id = params.id,
            position = params.position,
            type = params.type,
            "Stats"
        )
    }
}