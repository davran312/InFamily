package infamily.neobis.infamily.ui.section_adopt.adopt_information
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.text.Html
import infamily.neobis.infamily.R
import infamily.neobis.infamily.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_information.*

class InformationActivity : BaseActivity() {
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)
        supportActionBar?.title = Html.fromHtml("<font color=\"#ffffff\">" + getString(R.string.app_name) + "</font>")
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        mViewPager?.adapter = mSectionsPagerAdapter
        mViewPager?.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(mViewPager))

    }
}