package com.friple.widgetlibrary.domain.usecases

import com.friple.widgetlibrary.R
import com.friple.widgetlibrary.data.entities.TopBarWidget
import com.friple.widgetlibrary.domain.api.WidgetConfig

class TopBarUseCase(
    listener: OnUseCaseResultListener
) : BaseUseCase<TopBarWidget, WidgetConfig>(listener) {

    override suspend fun run(params: WidgetConfig): TopBarWidget {
        return TopBarWidget(
            id = params.id,
            position = params.position,
            type = params.type,
            leftDrawableRes = R.drawable.ic_baseline_menu_24,
            rightDrawableRes = R.drawable.ic_baseline_settings_24,
            "Home"
        )
    }
}