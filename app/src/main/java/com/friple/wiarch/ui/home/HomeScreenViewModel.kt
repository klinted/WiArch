package com.friple.wiarch.ui.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.friple.widgetlibrary.data.base.BaseWidget
import com.friple.widgetlibrary.domain.OnWidgetsResultListener
import com.friple.widgetlibrary.domain.WidgetFactory

class HomeScreenViewModel(
    application: Application
) : ViewModel(), OnWidgetsResultListener {

    private val widgetFactory = WidgetFactory(this)


    private val _widgets = MutableLiveData<List<BaseWidget>>()


    val widgets: LiveData<List<BaseWidget>>
        get() {
            return _widgets
        }


    fun updateWidgets() {
        widgetFactory.updateWidgets()
    }

    override fun onWidgetsResult(result: List<BaseWidget>) {
        _widgets.postValue(result)
    }


    class Factory(
        private val application: Application,
//        private val callbackManager: MainScreenCallbackManager,
//        private val config: MainScreenConfig
    ) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return HomeScreenViewModel(application) as T
        }
    }
}