package com.example.task.ui.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.task.R
import com.example.task.data.errors.NoAuthException
import com.firebase.ui.auth.AuthUI
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.channels.consumeEach

abstract class BaseActivity<T> : AppCompatActivity(), CoroutineScope {
    companion object {
        private const val RC_SIGN_IN = 42424
    }

    override val coroutineContext: CoroutineContext by lazy { Dispatchers.Main + Job() }

    private lateinit var dataJob: Job
    private lateinit var errorJob: Job

    abstract val model: BaseViewModel<T>
    abstract val layoutRes: Int?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutRes?.let {
            setContentView(it)
        }
    }

    override fun onStart() {
        super.onStart()
        dataJob = launch {
            model.getViewState().consumeEach {
                renderData(it)
            }
        }

        errorJob = launch {
            model.getErrorChannel().consumeEach {
                renderError(it)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        dataJob.cancel()
        errorJob.cancel()
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineContext.cancel()
    }

    abstract fun renderData(data: T)

    protected fun renderError(error: Throwable) {
        when (error) {
            is NoAuthException -> startLogin()
            else -> error.message?.let { showError(it) }
        }
    }

    private fun startLogin() {
        val providers = listOf(
            AuthUI.IdpConfig.GoogleBuilder().build()
        )

        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setLogo(R.drawable.android_robot)
                .setTheme(R.style.LoginStyle)
                .setAvailableProviders(providers)
                .build()
            , RC_SIGN_IN
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == RC_SIGN_IN && resultCode != Activity.RESULT_OK){
            finish()
        }
    }

    protected fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}