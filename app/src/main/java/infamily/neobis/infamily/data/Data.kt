package infamily.neobis.infamily.data

import android.content.Context
import infamily.neobis.infamily.R
import infamily.neobis.infamily.model.Section

object Data {

     fun getMainCategories(context: Context): MutableList<Section> {
        val array:MutableList<Section> = mutableListOf()
        array.add(Section(context.getString(R.string.main_category1), R.drawable.rod))
        array.add(Section(context.getString(R.string.main_category2), R.drawable.det))
        array.add(Section(context.getString(R.string.main_category3), R.drawable.fam))
        array.add(Section(context.getString(R.string.main_category4),  R.drawable.order))

        return array
    }
     fun getAdoptCategories(context: Context): MutableList<Section> {
        val array:MutableList<Section> = mutableListOf()
        array.add(Section(context.getString(R.string.adopt_category1),  R.drawable.info_sign))
        array.add(Section(context.getString(R.string.adopt_category2), R.drawable.copy))
        array.add(Section(context.getString(R.string.adopt_category3), R.drawable.test))

        return array
    }
}