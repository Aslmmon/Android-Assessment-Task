package com.example.tap_payment_task.features.tap_payment_bottomSheet.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tap_payment_task.R
import com.example.tap_payment_task.features.tap_payment_bottomSheet.data.model.PaymentSourcesResponse


class PaymentsTypesAdapter :
    ListAdapter<PaymentSourcesResponse, PaymentsTypesAdapter.ViewHolder>(PaymentTypesComparator) {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.payment_type_item, parent, false)
        )
    }


    object PaymentTypesComparator : DiffUtil.ItemCallback<PaymentSourcesResponse>() {
        override fun areItemsTheSame(
            oldItem: PaymentSourcesResponse,
            newItem: PaymentSourcesResponse
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: PaymentSourcesResponse,
            newItem: PaymentSourcesResponse
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val paymentType = getItem(position)

        /**
         * here we have 2 cases
         * if  isHaveCardData ->> true  view will be of image + card data
         * if isHaveCardData ->> false view will show only other options to pay with
         */
        with(paymentType) {
            when (isHaveCardData) {
                true -> {
                    holder.itemView.findViewById<Group>(R.id.grp_card_data).visibility =
                        View.VISIBLE
                    holder.itemView.findViewById<ImageView>(R.id.iv_payment_type).visibility =
                        View.GONE
                    holder.itemView.findViewById<TextView>(R.id.tv_card_number).text = cardNumber

                }
                false -> {
                    holder.itemView.findViewById<ImageView>(R.id.iv_payment_type).visibility =
                        View.VISIBLE
                    holder.itemView.findViewById<ImageView>(R.id.iv_payment_type).setImageURI(image)

                }
            }
        }

    }


}

