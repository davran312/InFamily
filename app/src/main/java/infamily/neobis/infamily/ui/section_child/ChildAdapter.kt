package infamily.neobis.infamily.ui.section_child

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import infamily.neobis.infamily.R
import infamily.neobis.infamily.model.Category
import kotlinx.android.synthetic.main.activity_result.view.*
import kotlinx.android.synthetic.main.item_category.view.*
import kotlinx.android.synthetic.main.item_section.view.*
import kotlinx.android.synthetic.main.item_timeline.view.*

class ChildAdapter(private var list:List<Category>,val listener:Listener) :RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_section,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder)?.bind(position)
    }

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(position: Int){
            itemView.tv_title.text = list.get(position).title
            Glide.with(itemView).load(list.get(position).image).into(itemView.iwCategory)
            itemView.tag = position
            itemView.setOnClickListener {
                val index= it.tag as Int
                listener.setOnItemClick(index)
            }
        }
    }
    interface Listener{
        fun setOnItemClick(position: Int)

    }


}