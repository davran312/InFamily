package infamily.neobis.infamily.ui.main

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import infamily.neobis.infamily.R
import infamily.neobis.infamily.model.Section
import infamily.neobis.infamily.ui.section_adopt.AdoptActivity
import infamily.neobis.infamily.ui.section_child.ChildActivity
import infamily.neobis.infamily.ui.section_parent.ParentActivity
import infamily.neobis.infamily.ui.section_specialist.SpecialistActivity
import kotlinx.android.synthetic.main.item_category.view.*

class MainActivityAdapter(private var list:List<Section>, var listener:Listener,val context:Context):
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
            carView.setBackgroundResource(R.drawable.main_rectangle)
            itemView.tvTitle.text = list[position].title
            itemView.iwImage.setBackgroundResource(list[position].imageId)
            itemView.tag = position
            itemView.setOnClickListener {
                val index = it.tag as Int
                listener.onItemSelectedAt(index)
            }

        }
    }
    fun startActivity(position: Int){
        var activity:Class<*>? = null
        when(position){
            0 -> activity = AdoptActivity::class.java
            1-> activity = ChildActivity::class.java
            2-> activity = ParentActivity::class.java
            3-> activity = SpecialistActivity::class.java
        }
        val intent  = Intent(context,activity)
        val options = ActivityOptions.makeCustomAnimation(context,R.anim.abc_slide_in_bottom,R.anim.abc_slide_out_bottom)
        context.startActivity(intent,options.toBundle())
    }
    interface Listener{
        fun onItemSelectedAt(position:Int)
    }


}