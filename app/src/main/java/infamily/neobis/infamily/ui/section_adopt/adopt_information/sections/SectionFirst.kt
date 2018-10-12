package infamily.neobis.infamily.ui.section_adopt.adopt_information.sections

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import infamily.neobis.infamily.R
import kotlinx.android.synthetic.main.tab_layout.*

class SectionFirst : Fragment(){
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,
                              savedInstanceState: Bundle?): View?{
        return inflater.inflate(R.layout.tab_layout,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvTitle.text = getString(R.string.adoption)
        textView.text = getString(R.string.text_adopt)
    }
}