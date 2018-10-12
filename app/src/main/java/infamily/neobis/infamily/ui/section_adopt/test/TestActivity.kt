package infamily.neobis.infamily.ui.section_adopt.test

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.LinearLayout
import infamily.neobis.infamily.R
import infamily.neobis.infamily.ui.BaseActivity
import infamily.neobis.infamily.ui.section_adopt.test_result.TestResultActivity
import infamily.neobis.infamily.utils.Const
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity: BaseActivity() {

    private  lateinit var adapter :TestAdapter
    private lateinit var linearLayout:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        linearLayout = findViewById(R.id.rootView)
        initRecyclerView()
        initButtonListeners()
    }

    private fun initButtonListeners() {
        btn_finish.setOnClickListener {
            val result = adapter.getTestCorrectnessPercentage()
            if(result== -1.0)
                Snackbar.make(linearLayout
                        ,"Ответьте на все вопросы",Snackbar.LENGTH_SHORT).show()
            else{
                openResultActivity(result)
            }
        }
    }

    private fun openResultActivity(result:Double) {
        val intent = Intent(this,TestResultActivity::class.java)
        intent.putExtra(Const.TEST_RESULT,result)
        startActivity(intent)
        finish()

    }

    private fun initRecyclerView() {
        val array:Array<String> = resources.getStringArray(R.array.questions_array)
        adapter = TestAdapter(array)
        recyclerView.adapter = adapter
    }


}