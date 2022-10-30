package com.example.curriculumvitae

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
      val etMessage = findViewById<EditText>(R.id.nameEditText)
        val etAge = findViewById<EditText>(R.id.ageEditText)
        val etEmail = findViewById<EditText>(R.id.emailEditText)

        val seekBarANDROID = findViewById<View>(R.id.simpleSeekBar) as SeekBar;
        val seekBarIOS = findViewById<View>(R.id.simpleSeekBar1) as SeekBar;
        val seekBarFlutter= findViewById<View>(R.id.simpleSeekBar2) as SeekBar;
        val btnClick = findViewById(R.id.Next) as Button
        val btnClick1 = findViewById(R.id.Reset) as Button
        btnClick1.setOnClickListener {
            etMessage.setText("");
            etAge.setText("");
            etEmail.setText("");
            seekBarANDROID.setProgress(0);
            seekBarIOS.setProgress(0);
            seekBarFlutter.setProgress(0);

        }
        btnClick.setOnClickListener {

            if (etMessage.text.toString()=="" || etAge.text.toString()=="" || etEmail.text.toString()=="" )
            {
                Toast.makeText(this,"please fill all your data ",Toast.LENGTH_LONG).show();
            }
            else {
                val strg = etEmail.text.toString();
                if (!Patterns.EMAIL_ADDRESS.matcher(strg).matches())
                {
                    Toast.makeText(this,"please write a proper email",Toast.LENGTH_LONG).show();
                }
                else {
                    if (seekBarANDROID.progress>=80 )
                    {
                        Toast.makeText(this,"Vous êtes excellent en\n" + "seekBarANDROID",Toast.LENGTH_LONG).show();
                    }
                    else {
                        if(seekBarANDROID.progress<= 30&&seekBarIOS.progress<=30&&seekBarFlutter.progress<=30)
                            {
                                Toast.makeText(this,"Vous devez\n" +
                                        "travailler vos skills" + "seekBarANDROID et seekBarIOS et seekBarFlutter ",Toast.LENGTH_LONG).show();
                            }
                        else {
                            if(seekBarANDROID.progress>=90&&seekBarIOS.progress>=90&&seekBarFlutter.progress>=90)
                            {Toast.makeText(this,"Vous avez de bons skills" ,Toast.LENGTH_LONG).show();
                            }
                        }

                    }

                }
}
}
}}