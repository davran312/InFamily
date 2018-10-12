package infamily.neobis.infamily.ui.section_adopt

import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import infamily.neobis.infamily.R
import infamily.neobis.infamily.model.Section
import kotlinx.android.synthetic.main.item_category.view.*


class AdoptAdapter(private var list:List<Section>, var listener:Listener):
        RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_category,p0,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ViewHolder)?.bind(position)
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(position:Int){
            val cardView = itemView.findViewById<CardView>(R.id.rootView)
            val layoutParams = cardView.getLayoutParams() as ViewGroup.MarginLayoutParams
            layoutParams.bottomMargin = 8
            cardView.requestLayout()
            cardView.setBackgroundResource(R.drawable.main_rectangle)
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
        fun onItemSelectedAt(positon:Int)
    }

}