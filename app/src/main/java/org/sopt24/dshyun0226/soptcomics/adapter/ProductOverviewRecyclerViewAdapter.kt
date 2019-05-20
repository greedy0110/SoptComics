package org.sopt24.dshyun0226.soptcomics.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.startActivity
import org.sopt24.dshyun0226.soptcomics.R
import org.sopt24.dshyun0226.soptcomics.activity.ProductActivity
import org.sopt24.dshyun0226.soptcomics.data.ProductOverviewData

class ProductOverviewRecyclerViewAdapter(val ctx: Context, var dataList: ArrayList<ProductOverviewData>):
    androidx.recyclerview.widget.RecyclerView.Adapter<ProductOverviewRecyclerViewAdapter.Holder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view  = LayoutInflater.from(ctx).inflate(R.layout.rv_item_product_overview, viewGroup, false)
        return Holder(view)
    }

    // 실제로 화면에 띄워주는 코드!
    override fun onBindViewHolder(holder: Holder, pos: Int) {
        Glide.with(ctx)
            .load(dataList[pos].thumnail)
            .into(holder.img_thumbnail)
        holder.title.text = dataList[pos].title
        holder.num_like.text = "♥${dataList[pos].likes}"
        holder.author.text = dataList[pos].name

        holder.container.setOnClickListener {
            ctx.startActivity<ProductActivity>(
                "idx" to dataList[pos].idx,
                "title" to dataList[pos].title
            )
        }
    }

    override fun getItemCount() = dataList.size

    inner class Holder(itemView: View): androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        var container = itemView.findViewById(R.id.ll_rv_item_product_overview_container) as LinearLayout
        var img_thumbnail = itemView.findViewById(R.id.img_rv_item_product_overview_thumbnail) as ImageView
        var title = itemView.findViewById(R.id.txt_rv_item_product_overview_title) as TextView
        var num_like = itemView.findViewById(R.id.txt_rv_item_product_overview_numlike) as TextView
        var author = itemView.findViewById(R.id.txt_rv_item_product_overview_author) as TextView
    }
}