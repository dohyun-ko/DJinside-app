package com.ex.mylearnfb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth = FirebaseAuth.getInstance()

        button_register.setOnClickListener {

            if(register_password.text.toString() == password_re.text.toString())
            {
                auth.createUserWithEmailAndPassword(email_register.text.toString(), register_password.text.toString())
                    .addOnCompleteListener(this) {task ->
                        if(task.isSuccessful) {
                            Toast.makeText(baseContext, "Registering Success", Toast.LENGTH_SHORT).show()


                        } else {
                            Toast.makeText(baseContext, "Registering Failed", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }


}
