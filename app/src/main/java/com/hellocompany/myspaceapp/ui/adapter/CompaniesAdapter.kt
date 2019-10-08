package com.hellocompany.myspaceapp.ui.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.hellocompany.myspaceapp.R
import com.hellocompany.myspaceapp.service.model.Companies
import com.hellocompany.myspaceapp.service.model.Data
import com.hellocompany.myspaceapp.ui.navigation.CompaniesFragmentDirections
import com.hellocompany.myspaceapp.ui.navigation.PayFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view.view.*

class CompaniesAdapter(private val item: Array<Companies>, private val context: Context):
    RecyclerView.Adapter<CompaniesAdapter.ViewHolder>() {

    private var bundleValues = Bundle()
    private var bundledFragment = PayFragment()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).
                inflate(R.layout.item_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemName.text = item[position].name
        Picasso.get().load(item[position].picture!!.thumbnailUrl).into(holder.itemIcon)

        holder.itemView.item_id.setOnClickListener { view ->
            val itemName = item[position].name
            val pictureLink = item[position].picture!!.originalUrl
            view.findNavController().navigate(CompaniesFragmentDirections.actionCompaniesFragmentToPayFragment(itemName!!, pictureLink!!))
        }
    }
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val itemName = view.item_name!!
        val itemIcon = view.item_icon!!
        val itemId = view.item_id!!
    }
}