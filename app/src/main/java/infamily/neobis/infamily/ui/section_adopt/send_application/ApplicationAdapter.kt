package infamily.neobis.infamily.ui.section_adopt

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import infamily.neobis.infamily.R
import infamily.neobis.infamily.model.Category
import kotlinx.android.synthetic.main.item_category.view.*
import kotlinx.android.synthetic.main.item_document.view.*


class ApplicationAdapter(context:Context):
        RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private val documentList = context.resources.getStringArray(R.array.documents_list)
    private val documnetDescriptoins = context.resources.getStringArray(R.array.documents_description_list)
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_document,p0,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return documentList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ViewHolder)?.bind(position)
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
      fun bind(positon: Int){
          itemView.tvDocumentName.text = documentList.get(positon)
          itemView.tvDocumentDescription.text = documnetDescriptoins.get(positon)
            }

        }

    }
    interface Listener{
        fun onItemSelectedAt(positon:Int)
    }

