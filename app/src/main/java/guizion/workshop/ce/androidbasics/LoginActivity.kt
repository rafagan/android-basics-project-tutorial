package guizion.workshop.ce.androidbasics

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.view.View


class LoginActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun navigateToForgotPassword(view: View) {
        val myIntent = Intent(this, PasswordRecoveryActivity::class.java)
        startActivity(myIntent)
    }
}