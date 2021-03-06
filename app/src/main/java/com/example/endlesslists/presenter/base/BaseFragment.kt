package com.example.endlesslists.presenter.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.example.endlesslists.domain.AppState
import org.koin.core.scope.Scope

abstract class BaseFragment<T>(@LayoutRes id: Int): Fragment(id) {
    abstract val scope: Scope
    abstract val viewBinding: T
    abstract val viewModel: BaseViewModel
    override fun onStart() {
        viewModel.getLiveData().observe(viewLifecycleOwner){renderData(it as AppState)}
        super.onStart()
    }
    abstract fun renderData(appState: AppState)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        setMenuVisibility(true)
    }
}