package com.hellocompany.myspaceapp.ui.navigation


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hellocompany.myspaceapp.R

class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Handler().postDelayed({
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToPaymentsFragment())
        }, 6000)
    }
}
