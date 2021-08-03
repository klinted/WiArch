package com.friple.widgetlibrary.domain.usecases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseUseCase<Result, in Params>(
    private val listener : OnUseCaseResultListener
) {

    protected abstract suspend fun run(params: Params): Result?

    suspend fun use(params: Params) {
        val result = getResult(params)
        postResult(result)
    }

    private suspend fun getResult(
        params: Params
    ): Result? = withContext(Dispatchers.Default) {
        return@withContext run(params)
    }

    protected suspend fun postResult(
        result: Result?
    ) = withContext(Dispatchers.Main) {
        listener.onUseCaseResult(this@BaseUseCase, result)
    }

    class None
}