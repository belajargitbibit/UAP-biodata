package com.example.uas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class EditAllActivity : AppCompatActivity() {

    lateinit var edNama: EditText
    lateinit var edJK: Spinner
    lateinit var edEmail: EditText
    lateinit var edTelp: EditText
    lateinit var edAlamat: EditText
    lateinit var btnSimpan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_all)

        edNama = findViewById(R.id.ed_nama)
        edJK = findViewById(R.id.ed_jk)
        edEmail = findViewById(R.id.ed_email)
        edTelp = findViewById(R.id.ed_telp)
        edAlamat = findViewById(R.id.ed_alamat)
        btnSimpan = findViewById(R.id.btn_simpan)

        val intent = intent
        val nama = intent.getStringExtra("Nama")
        val jk = intent.getStringExtra("JenisKelamin")
        val email = intent.getStringExtra("Email")
        val telp = intent.getStringExtra("Telepon")
        val alamat = intent.getStringExtra("Alamat")

        edNama.setText(nama)
        if (jk != null) {
            val position = if (jk == "Laki-Laki") 0 else 1
            edJK.setSelection(position)
        }
        edEmail.setText(email)
        edTelp.setText(telp)
        edAlamat.setText(alamat)

        val mList = arrayOf("Laki-Laki", "Perempuan")
        val mArrayAdapter = ArrayAdapter<Any?>(this, R.layout.spinner_list, mList)
        mArrayAdapter.setDropDownViewResource(R.layout.spinner_list)
        edJK.adapter = mArrayAdapter

        btnSimpan.setOnClickListener{
            val nNama = edNama.text.toString()
            val nJK = edJK.getSelectedItem().toString()
            val nEmail = edEmail.text.toString()
            val nTelp = edTelp.text.toString()
            val nAlamat = edAlamat.text.toString()

            val intent = Intent()
            intent.putExtra("Nama", nNama)
            intent.putExtra("JenisKelamin", nJK)
            intent.putExtra("Email", nEmail)
            intent.putExtra("Telepon", nTelp)
            intent.putExtra("Alamat", nAlamat)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}