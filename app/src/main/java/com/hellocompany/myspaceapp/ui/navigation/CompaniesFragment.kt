package com.hellocompany.myspaceapp.ui.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.hellocompany.myspaceapp.R
import com.hellocompany.myspaceapp.ui.adapter.CompaniesAdapter
import com.hellocompany.myspaceapp.viewmodel.PaymentsViewModel
import kotlinx.android.synthetic.main.fragment_companies.*

class CompaniesFragment : Fragment(R.layout.fragment_companies) {

    private lateinit var viewModel: PaymentsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val args = CompaniesFragmentArgs.fromBundle(arguments!!)
        val esim = args.companies

        viewModel = ViewModelProviders.of(this).get(PaymentsViewModel::class.java)
        viewModel.getResponse().observe(this, Observer { response ->
            popular_recycler.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = CompaniesAdapter(esim, context)
            }
        })
    }
}
