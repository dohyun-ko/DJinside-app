package com.ex.mylearnfb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val email_register = findViewById<EditText>(R.id.email_register)
        val register_password = findViewById<EditText>(R.id.register_password)
        val password_re = findViewById<EditText>(R.id.password_re)
        val button_register = findViewById<Button>(R.id.button_register)
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
