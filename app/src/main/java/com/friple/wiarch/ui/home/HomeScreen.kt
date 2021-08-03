package com.friple.wiarch.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.friple.wiarch.R
import com.friple.wiarch.ui.home.adapters.HomeWidgetAdapter
import com.friple.wiarch.ui.home.adapters.HomeWidgetViewPool

class HomeScreen : Fragment(R.layout.fragment_home_screen) {

    private lateinit var homeScreenAdapter: HomeWidgetAdapter
    private lateinit var homeScreenViewPool: HomeWidgetViewPool

    private val viewModel: HomeScreenViewModel by lazy (LazyThreadSafetyMode.NONE) {
        val application = requireActivity().application
        val factory = HomeScreenViewModel.Factory(
            application
        )
        ViewModelProvider(requireActivity(), factory).get(HomeScreenViewModel::class.java)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        variablesInit()
        widgetInit(view)
        observersInit()

        viewModel.updateWidgets()
    }


    private fun variablesInit() {
        homeScreenViewPool = HomeWidgetViewPool()
        homeScreenAdapter = HomeWidgetAdapter(
            requireContext(),
            homeScreenViewPool
        )
    }

    private fun widgetInit(view: View) {
        val widgetList: RecyclerView = view.findViewById(R.id.widget_list)

        widgetList.adapter = homeScreenAdapter
    }

    private fun observersInit() {
        viewModel.widgets.observe(viewLifecycleOwner, { widgets ->
            homeScreenAdapter.widgetList = widgets
        })
    }
}