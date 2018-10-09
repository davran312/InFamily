package infamily.neobis.infamily.ui.timeline

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import infamily.neobis.infamily.R
import infamily.neobis.infamily.model.Category
import kotlinx.android.synthetic.main.item_timeline.view.*

class TimelineAdapter(private var timelineList:List<Category>,val listener:Listener):RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_timeline,p0,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return timelineList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ViewHolder)?.bind(position)
    }

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(position: Int){
            itemView.tvTitle.text = timelineList.get(position).title
            Glide.with(itemView).load(timelineList.get(position).image).into(itemView.imgPicture)
            itemView.tag = position
            itemView.setOnClickListener {
                val index = it.tag as Int
                listener.onItemSeletedAt(timelineList.get(index))
            }

        }
    }


    interface Listener{
        fun onItemSeletedAt(position: Category)
    }
}
