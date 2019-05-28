package org.sopt24.dshyun0226.soptcomics.presentation.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import khronos.toString
import org.sopt24.dshyun0226.soptcomics.R
import org.sopt24.dshyun0226.soptcomics.domain.model.CommentData

class CommentAdapter(private val ctx: Context, var data: ArrayList<CommentData>): androidx.recyclerview.widget.RecyclerView.Adapter<CommentAdapter.Holder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.rv_item_comment, viewGroup, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: Holder, pos: Int) {
        val t = data[pos]
        Glide.with(ctx)
            .load(t.thumbnail_url)
            .into(holder.img_thumbnail)

        holder.txt_nickname.text = t.nickname
        holder.txt_write_time.text = t.write_date.toString("yyyy.MM.dd HH:mm:SS")
        holder.txt_content.text = t.content
    }

    inner class Holder(view: View): androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        val container = view.findViewById<LinearLayout>(R.id.ll_rv_item_comment_list_container)
        val img_thumbnail = view.findViewById<ImageView>(R.id.img_rv_item_comment_thumbnail)
        val txt_nickname = view.findViewById<TextView>(R.id.txt_rv_item_comment_nickname)
        val txt_write_time = view.findViewById<TextView>(R.id.txt_rv_item_comment_write_time)
        val txt_content = view.findViewById<TextView>(R.id.txt_rv_item_comment_content)
    }
}