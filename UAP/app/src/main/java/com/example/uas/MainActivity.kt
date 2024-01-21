package com.example.uas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edNama: TextView
    lateinit var edJK: TextView
    lateinit var edEmail: TextView
    lateinit var edTelp: TextView
    lateinit var edAlamat: TextView
    lateinit var btnEditAll: Button

    companion object {
        const val EDIT_ALL_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edNama = findViewById(R.id.ed_nama)
        edJK = findViewById(R.id.ed_jk)
        edEmail = findViewById(R.id.ed_email)
        edTelp = findViewById(R.id.ed_telp)
        edAlamat = findViewById(R.id.ed_alamat)
        btnEditAll = findViewById(R.id.btn_ed_all)

        btnEditAll.setOnClickListener{
            val nama = edNama.text.toString()
            val jk = edJK.text.toString()
            val email = edEmail.text.toString()
            val telp = edTelp.text.toString()
            val alamat = edAlamat.text.toString()

            if (nama.isNotEmpty() && jk.isNotEmpty() && email.isNotEmpty() && telp.isNotEmpty() && alamat.isNotEmpty()) {
                val intent = Intent(this, EditAllActivity::class.java)
                intent.putExtra("Nama", nama)
                intent.putExtra("JenisKelamin", jk)
                intent.putExtra("Email", email)
                intent.putExtra("Telepon", telp)
                intent.putExtra("Alamat", alamat)
                startActivityForResult(intent, EDIT_ALL_REQUEST_CODE)
            } else {
                Log.d("MainActivity", "Nilai Intent null karena ada field yang kosong")
                // Menangani kasus ketika nilai Intent null
                // (misalnya, jika ada field yang kosong)
                // Tambahkan log atau tindakan lain sesuai kebutuhan Anda.
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == EDIT_ALL_REQUEST_CODE && resultCode == RESULT_OK) {
            val nNama = data?.getStringExtra("Nama")
            val nJK = data?.getStringExtra("JenisKelamin")
            val nEmail = data?.getStringExtra("Email")
            val nTelp = data?.getStringExtra("Telepon")
            val nAlamat = data?.getStringExtra("Alamat")

            edNama.text = nNama
            edJK.text = nJK
            edEmail.text = nEmail
            edTelp.text = nTelp
            edAlamat.text = nAlamat
        }
    }
}