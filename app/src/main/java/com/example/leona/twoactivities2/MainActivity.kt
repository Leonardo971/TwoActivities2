package com.example.leona.twoactivities2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun launchSecondActivity (v:View)
    {
       Toast.makeText(this@MainActivity,"BOTON ENVIAR",Toast.LENGTH_SHORT).show()

        val intent=Intent(this,SecondActivity::class.java)
        val editText_main=findViewById<EditText>(R.id.editText_main)
        val message=editText_main!!.text.toString()
        intent.putExtra(EXTRA_MESSAGE,message)
        startActivity(intent)


    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==TEXT_REQUEST)
        {
            if(resultCode==Activity.RESULT_OK)
            {
                val reply = data?.getStringExtra(SecondActivity.EXTRA_REPLY)
                      val  text_message_reply=findViewById<TextView>(R.id.text_message_reply)
                text_message_reply.text=reply


            }
        }
    }


    companion object {
        val EXTRA_MESSAGE="com.example.leona.twoactivities2.extra.MESSAGE"

        val TEXT_REQUEST=1
    }
}
