package com.example.tap_payment_task.features.tap_payment_bottomSheet.presentation.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tap_payment_task.R


class PaymentsTypesAdapter :
    ListAdapter<PaymentTypeData, PaymentsTypesAdapter.ViewHolder>(PaymentTypesComparator) {
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


    object PaymentTypesComparator : DiffUtil.ItemCallback<PaymentTypeData>() {
        override fun areItemsTheSame(
            oldItem: PaymentTypeData,
            newItem: PaymentTypeData
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: PaymentTypeData,
            newItem: PaymentTypeData
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val paymentType = getItem(position)
        with(paymentType) {
            //holder.itemView.findViewById<ImageView>(R.id.iv_payment_type).setImageURI(image)
        }

    }


}

data class PaymentTypeData(var id: Int? = null)