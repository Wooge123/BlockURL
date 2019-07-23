package me.wooge.blockurl

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.DataOutputStream

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val etUrl = findViewById<EditText>(R.id.etUrl)

        btnAdd.setOnClickListener { _ ->
            val p = Runtime.getRuntime().exec("su")

            val dos = DataOutputStream(p.outputStream)

            dos.writeBytes("mount -o rw,remount /system\n")

            dos.writeBytes("echo \"\n127.0.0.1 " + etUrl.text.trim() + "\"" + " >> /etc/hosts")
            dos.flush()
            dos.close()
        }
    }
}
