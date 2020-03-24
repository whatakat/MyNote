package com.example.task.ui.splash

import android.os.Handler
import com.example.task.ui.base.BaseActivity
import com.example.task.ui.main.MainActivity

class SplashActivity : BaseActivity<Boolean?>() {

    companion object {
        private const val START_DELAY = 1000L
    }

    override val model: SplashViewModel by viewModel()

    override val layoutRes: Int? = null

    override fun onResume() {
        super.onResume()
        Handler().postDelayed({ model.requestUser() }, START_DELAY)
    }

    override fun renderData(data: Boolean?) {
        data?.takeIf { it }?.let {
            startMainActivity()
        }
    }

    private fun startMainActivity() {
        MainActivity.start(this)
        finish()
    }
}