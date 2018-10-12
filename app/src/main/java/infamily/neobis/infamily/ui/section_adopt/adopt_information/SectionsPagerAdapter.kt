package infamily.neobis.infamily.ui.section_adopt.adopt_information

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import infamily.neobis.infamily.ui.section_adopt.adopt_information.sections.SectionFirst
import infamily.neobis.infamily.ui.section_adopt.adopt_information.sections.SectionSecond
import infamily.neobis.infamily.ui.section_adopt.adopt_information.sections.SectionThird

internal class SectionsPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm){
    override fun getItem(position:Int): Fragment {
        return when(position){
            1-> SectionSecond()
            2-> SectionThird()
            else -> SectionFirst()
        }
    }
    override fun getCount():Int = 3
}