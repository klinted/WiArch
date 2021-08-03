package com.friple.widgetlibrary.domain.usecases

interface OnUseCaseResultListener {

    fun onUseCaseResult(useCase: BaseUseCase<*, *>, result: Any?)
}