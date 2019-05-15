package org.sopt24.dshyun0226.soptcomics.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import org.sopt24.dshyun0226.soptcomics.R
import org.sopt24.dshyun0226.soptcomics.data.WebToonData
import khronos.toString
import org.jetbrains.anko.startActivity
import org.sopt24.dshyun0226.soptcomics.activity.WebtoonActivity

class WebtoonListAdapter(private val ctx: Context, var data: ArrayList<WebToonData>): RecyclerView.Adapter<WebtoonListAdapter.Holder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view  = LayoutInflater.from(ctx).inflate(R.layout.rv_item_webtoon_list, viewGroup, false)
        return Holder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: Holder, pos: Int) {
        // loading thumbnail
        Glide.with(ctx)
            .load(data[pos].thumbnail_url)
            .into(holder.img_thumbnail)

        holder.txt_title.text = data[pos].title
        holder.txt_viewcount.text = "조회수 ${data[pos].view_count}회"
        holder.txt_uploaddate.text = data[pos].upload_date.toString("yyyy.MM.dd")

        holder.container.setOnClickListener {
            ctx.startActivity<WebtoonActivity>(
                "webtoon_id" to data[pos].webtoon_id,
                "title" to data[pos].title
            )
        }
    }

    inner class Holder(view: View): RecyclerView.ViewHolder(view) {
        val container = view.findViewById<LinearLayout>(R.id.ll_rv_item_webtoon_list_container)
        val img_thumbnail = view.findViewById<ImageView>(R.id.img_rv_item_webtoon_thumbnail)
        val txt_title = view.findViewById<TextView>(R.id.txt_rv_item_webtoon_title)
        val txt_viewcount = view.findViewById<TextView>(R.id.txt_rv_item_webtoon_view_count)
        val txt_uploaddate = view.findViewById<TextView>(R.id.txt_rv_item_webtoon_upload_date)
    }
}