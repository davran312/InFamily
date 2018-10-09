package infamily.neobis.infamily.ui.article

import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init
import infamily.neobis.infamily.R
import infamily.neobis.infamily.model.Category
import infamily.neobis.infamily.ui.BaseActivity
import infamily.neobis.infamily.utils.Const
import kotlinx.android.synthetic.main.activity_article.*
import kotlinx.android.synthetic.main.activity_result.*

class ArticleActivity:BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        init()
    }

    private fun init() {
        initViews()
    }

    private fun initViews() {
        val category:Category = intent.extras.getSerializable(Const.EXTRA_ARTICLE) as Category
        collapsingToolbar.title = category.title
        Glide.with(this).load(category.image).into(toolbarImage)
        tvTitle.text = category.title
        tvDesciption.text = category.content
    }



}