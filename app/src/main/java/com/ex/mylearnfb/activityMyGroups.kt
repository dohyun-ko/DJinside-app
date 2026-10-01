package com.ex.mylearnfb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class activityMyGroups : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private var uid:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_groups)

        val button_enterMakeGroupActivity = findViewById<Button>(R.id.button_enterMakeGroupActivity)

        if (intent.hasExtra("uid"))
            uid = intent.getStringExtra("uid")

        auth = FirebaseAuth.getInstance()

        button_enterMakeGroupActivity.setOnClickListener {
            var nextIntent = Intent(this, activityMakeGroup::class.java)
            nextIntent.putExtra("uid", uid)
            startActivity(nextIntent)
        }

    }
}
