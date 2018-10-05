package infamily.neobis.infamily.ui.section_adopt.test

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import infamily.neobis.infamily.R
import kotlinx.android.synthetic.main.item_test.view.*

class TestAdapter (private var list: Array<String>
                  ): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private  var map:HashMap<Int,Boolean> = HashMap()
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_test,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong();
    }

    override fun getItemViewType(position: Int): Int {
       return position
    }

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(position:Int){
            itemView.tvTitle.text = list.get(position)
            itemView.btn_yes.tag = position
            itemView.btn_yes.setOnClickListener {
                val index = it.tag as Int
                itemView.btn_yes.setBackgroundResource(
                R.drawable.grenn_rectangle)
                itemView.btn_no.setBackgroundResource(R.drawable.blue_rectangle)
                map[index] = true
            }
            itemView.btn_no.tag = position
            itemView.btn_no.setOnClickListener {
                val index = it.tag as Int
                itemView.btn_yes.setBackgroundResource(
                        R.drawable.blue_rectangle)
                itemView.btn_no.setBackgroundResource(R.drawable.grenn_rectangle)
                map[index] = false
            }


            }

        }
     fun getTestCorrectnessPercentage():Double{
         var counter :Int = 0
       if(map.size < 24)
           return -1.0

       else{
            for(i in 0 until map.size){
                if(map[i] == true)
                    counter++
                }
                return counter * 4.166
            }
     }
}



