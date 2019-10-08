package com.hellocompany.myspaceapp.ui.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.hellocompany.myspaceapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_pay.*

class PayFragment : Fragment(R.layout.fragment_pay) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val args = PayFragmentArgs.fromBundle(arguments!!)
        back_button.text = args.itemName
        Picasso.get().load(args.pictureLink).into(item_icon_pay)

        back_button.setOnClickListener { view ->
            view.findNavController().popBackStack()
        }
    }
}
