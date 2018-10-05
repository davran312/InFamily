package infamily.neobis.infamily.data

import android.content.Context
import infamily.neobis.infamily.R
import infamily.neobis.infamily.model.Category
import java.util.*

object Data {

     fun getMainCategories(context: Context): MutableList<Category> {
        val array:MutableList<Category> = mutableListOf()
        array.add(Category(context.getString(R.string.main_category1), R.color.main_color_first, R.drawable.rod))
        array.add(Category(context.getString(R.string.main_category2),R.color.main_color_first , R.drawable.det))
        array.add(Category(context.getString(R.string.main_category3), R.color.main_color_first, R.drawable.fam))
        array.add(Category(context.getString(R.string.main_category4), R.color.main_color_first, R.drawable.order))

        return array
    }
     fun getAdoptCategories(context: Context): MutableList<Category> {
        val array:MutableList<Category> = mutableListOf()
        array.add(Category(context.getString(R.string.adopt_category1), R.color.main_color_first, R.drawable.info_sign))
        array.add(Category(context.getString(R.string.adopt_category2), R.color.main_color_first, R.drawable.copy))
        array.add(Category(context.getString(R.string.adopt_category3), R.color.main_color_first, R.drawable.test))

        return array
    }
}