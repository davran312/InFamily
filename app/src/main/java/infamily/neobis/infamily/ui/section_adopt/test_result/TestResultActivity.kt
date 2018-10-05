package infamily.neobis.infamily.ui.section_adopt.test_result

import android.os.Bundle
import infamily.neobis.infamily.R
import infamily.neobis.infamily.ui.BaseActivity
import infamily.neobis.infamily.utils.Const
import kotlinx.android.synthetic.main.activity_result.*

class TestResultActivity :BaseActivity() {
    private var testResult:Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        testResult = intent.getDoubleExtra(Const.TEST_RESULT,0.0)
        setTestResult()

    }

    private fun setTestResult() {
        tvPercentage.text = testResult.toInt().toString() +"%"
        if(testResult >=99){
            tvDescribe.text = getString(R.string.excellent_result)
            tvCongratulations.text = getString(R.string.congratulations)}
        else if(testResult >= 70 && testResult <= 99){
            tvDescribe.text = getString(R.string.normal_result)
            tvCongratulations.text = getString(R.string.normal)}
        else
            tvDescribe.text = getString(R.string.bad_result)
    }
}