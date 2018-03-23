package guizion.workshop.ce.androidbasics

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class PasswordRecoveryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_recovery)
    }

    fun recoverPassword(view: View) {
        //todo: efetuar recuperação de senha no servidor
        this.navigateToLogin()
    }

    fun navigateToLogin() {
        val myIntent = Intent(this, LoginActivity::class.java)
        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(myIntent)
    }
}
