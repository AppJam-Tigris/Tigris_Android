package com.saehyun.trigris_android.feature.find

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.saehyun.trigris_android.R
import com.saehyun.trigris_android.feature.document.DocumentActivity
import com.saehyun.trigris_android.feature.find.model.ClinicResponseItem

class ClinicAdapter(val context: Context, val productData: List<ClinicResponseItem>):
    RecyclerView.Adapter<ClinicAdapter.Holder>() {

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val tvFindTitle = itemView?.findViewById<TextView>(R.id.tvFindTitle)
        val tvFindAddress = itemView?.findViewById<TextView>(R.id.tvFindAddress)
        val tvFindPost = itemView?.findViewById<TextView>(R.id.tvFindPost)
        val tvFindPhone = itemView?.findViewById<TextView>(R.id.tvFindPhone)
        val cl = itemView?.findViewById<ConstraintLayout>(R.id.cl)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.find_view, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        var data: ClinicResponseItem = productData.get(position)

        holder.tvFindTitle?.text = data.name
        holder.tvFindAddress?.text = data.address
        holder.tvFindPost?.text = data.city
        holder.tvFindPhone?.text = data.managerPhoneNumber

        holder.cl?.setOnClickListener {
            var intent = Intent(holder.itemView.context, DocumentActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int {
        return productData.size
    }
}