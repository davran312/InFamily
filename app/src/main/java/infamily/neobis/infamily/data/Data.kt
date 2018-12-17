package infamily.neobis.infamily.data

import android.content.Context
import infamily.neobis.infamily.R
import infamily.neobis.infamily.model.Section

object Data {

     fun getMainCategories(context: Context): MutableList<Section> {
        val array:MutableList<Section> = mutableListOf()
        array.add(Section(context.getString(R.string.main_category1), R.drawable.family))
        array.add(Section(context.getString(R.string.main_category2), R.drawable.couple))
        array.add(Section(context.getString(R.string.main_category3), R.drawable.son))
        array.add(Section(context.getString(R.string.main_category4),  R.drawable.doctor))

        return array
    }
     fun getAdoptCategories(context: Context): MutableList<Section> {
        val array:MutableList<Section> = mutableListOf()
        array.add(Section(context.getString(R.string.adopt_category1), R.drawable.document))
        array.add(Section(context.getString(R.string.adopt_category2), R.drawable.archive))
        array.add(Section(context.getString(R.string.adopt_category3), R.drawable.test))

        return array
    }
}