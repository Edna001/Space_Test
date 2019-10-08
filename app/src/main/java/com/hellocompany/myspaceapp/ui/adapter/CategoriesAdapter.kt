package com.hellocompany.myspaceapp.ui.adapter

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.hellocompany.myspaceapp.R
import com.hellocompany.myspaceapp.service.model.Categories
import com.hellocompany.myspaceapp.service.model.Companies
import com.hellocompany.myspaceapp.service.model.Data
import com.hellocompany.myspaceapp.ui.navigation.*
import com.hellocompany.myspaceapp.viewmodel.PaymentsViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view.view.*

class CategoriesAdapter(private val item: Data, private val context: Context,
                        var itemCallBack: ((item: Categories) -> Unit)? = null,
                        var viewModel: PaymentsViewModel) :
                        RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_view,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return item.categories!!.size
//        var currentSize: Int? = null
//        for (i in item.categories?: arrayListOf()){
//            if (i.categoryId == 5) {
//                currentSize = i.companyIds!!.size
//            }
//        }
//        return currentSize!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemName.text = item.categories!![position].name
        Picasso.get().load(item.categories[position].picture!!.thumbnailUrl).into(holder.itemIcon)

        holder.itemView.item_id.setOnClickListener { view ->
            itemCallBack?.invoke(item.categories[position])
            view.findNavController().navigate(CategoriesFragmentDirections.actionCategoriesFragmentToCompaniesFragment(viewModel.getCompanies().value!!.toTypedArray()))
//            view.findNavController().navigate(CategoriesFragmentDirections.actionCategoriesFragmentToCompaniesFragment(CompaniesFragmentArgs.fromBundle(CompaniesFragment().arguments!!).companies))
        }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val itemIcon = view.item_icon!!
        val itemName = view.item_name!!
    }

}