package infamily.neobis.infamily.ui.main

import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import infamily.neobis.infamily.R
import infamily.neobis.infamily.model.Category
import kotlinx.android.synthetic.main.item_category.view.*

class MainActivityAdapter(private var list:List<Category>,var listener:Listener):
RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_category,p0,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ViewHolder)?.bind(position)
    }
    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(position:Int){
            val carView = itemView.findViewById<CardView>(R.id.rootView)
            carView.setCardBackgroundColor(ContextCompat.getColor(itemView.context, list[position].backgroundColor))
            itemView.tvTitle.text = list[position].title
            itemView.iwImage.setBackgroundResource(list[position].imageId)
            itemView.tag = position
            itemView.setOnClickListener {
                val index = it.tag as Int
                listener.onItemSelectedAt(index)
        }

    }
    }
    interface Listener{
        fun onItemSelectedAt(position:Int)
    }

}