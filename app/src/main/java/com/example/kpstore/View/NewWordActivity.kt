
package com.example.kpstore.View

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import com.example.kpstore.R

/**
 * Activity for entering a word.
 */

class NewWordActivity : AppCompatActivity() {

    private lateinit var editWordView: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_word_layout)
        editWordView = findViewById(R.id.word_edittext)

        val saveNoteBtn = findViewById<Button>(R.id.button_save_word)
        saveNoteBtn.setOnClickListener {
            checkAndSave()
        }
    }


    fun checkAndSave(){
        val replyIntent = Intent()
        val word = editWordView.text.toString()

        if (TextUtils.isEmpty(word)) {
            setResult(Activity.RESULT_CANCELED, replyIntent)
        } else {

            replyIntent.putExtra(EXTRA_REPLY, word)
            setResult(Activity.RESULT_OK, replyIntent)
        }
        finish()

    }



    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}