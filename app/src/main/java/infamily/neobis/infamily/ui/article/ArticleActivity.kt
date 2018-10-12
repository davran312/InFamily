package infamily.neobis.infamily.ui.article

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.WindowManager
import com.bumptech.glide.Glide
import infamily.neobis.infamily.R
import infamily.neobis.infamily.model.Category
import infamily.neobis.infamily.ui.BaseActivity
import infamily.neobis.infamily.utils.Const
import kotlinx.android.synthetic.main.activity_article.*

class ArticleActivity:BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        setTransparentStatusBar()
        init()
    }

    private fun setTransparentStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.statusBarColor = Color.TRANSPARENT
        }
    }


    private fun init() {
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()?.setDisplayShowHomeEnabled(true);
        initViews()
    }

    private fun initViews() {
        val category:Category = intent.extras.getSerializable(Const.EXTRA_ARTICLE) as Category
        collapsingToolbar.title = category.title
        Glide.with(this).load(category.image).into(toolbarImage)
        tvDesciption.text = category.content
    }



}