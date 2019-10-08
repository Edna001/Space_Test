package com.hellocompany.myspaceapp.ui.navigation

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hellocompany.myspaceapp.R
import com.hellocompany.myspaceapp.service.model.Companies
import com.hellocompany.myspaceapp.ui.adapter.CategoriesAdapter
import com.hellocompany.myspaceapp.viewmodel.PaymentsViewModel
import kotlinx.android.synthetic.main.fragment_categories.*

class CategoriesFragment : Fragment(R.layout.fragment_categories) {

    private lateinit var viewModel: PaymentsViewModel
    private val bundle = Bundle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PaymentsViewModel::class.java)
        viewModel.getResponse().observe(this, Observer { response ->
            recycler_view.apply {
                layoutManager = LinearLayoutManager(context)

                adapter = CategoriesAdapter(response.data, context, itemCallBack = { data ->
                    val companyListFromCategory: MutableList<Companies> = arrayListOf()
                    data.companyIds?.forEach { companyId ->
                        viewModel.getResponse().value?.data?.companies?.filter { it.companyId == companyId && it.parentId == data.categoryId }?.forEach {
                            companyListFromCategory.add(it)
                            viewModel.setCompanies(companyListFromCategory)
                        }
                    }

                    Log.d("Size of array", viewModel.getCompanies().value!!.size.toString())
                    button.setOnClickListener { view ->
                        view.findNavController().navigate(CategoriesFragmentDirections.actionCategoriesFragmentToCompaniesFragment(
                            viewModel.getCompanies().value!!.toTypedArray()
                        ))
                    }
                }, viewModel = viewModel)
            }
        })
    }

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        viewModel = ViewModelProviders.of(this).get(PaymentsViewModel::class.java)
//        return super.onCreateView(inflater, container, savedInstanceState)
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        createCategories()
//    }
//
//    private fun createCategories(){
//        findNavController().popBackStack(R.id.splashFragment, true)
//        viewModel.getResponse().observe(this, Observer { categoriesResponse ->
//            recycler_view.apply {
//                layoutManager = LinearLayoutManager(context)
//                adapter = CategoriesAdapter(categoriesResponse.data, context)
//            }
//        })
//    }
}
