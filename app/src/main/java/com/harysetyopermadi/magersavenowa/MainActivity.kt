package com.harysetyopermadi.magersavenowa

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.hbb20.CountryCodePicker

class MainActivity : AppCompatActivity() {
    lateinit var sub: MaterialButton
    lateinit var notelp: EditText
    lateinit var kd_ngr: CountryCodePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val window=this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor= ContextCompat.getColor(this,R.color.white)

//inisialisasi
        sub=findViewById(R.id.submit)
        notelp=findViewById(R.id.no_telp)
        kd_ngr=findViewById(R.id.kode_negara)
        kd_ngr.registerCarrierNumberEditText(notelp)
        sub.setOnClickListener {
            if(checkValidity(kd_ngr,notelp))
            {
            }else{
                Toast.makeText(this, "Nomor Telphone Salah", Toast.LENGTH_SHORT).show()
            }


        }


    }

    private fun checkValidity(ccp: CountryCodePicker, edtPhoneNumber: EditText): Boolean {
        //val numberString = edtPhoneNumber.text.toString()
        val hasil:String="+"+ccp.fullNumber
        return if(kd_ngr.isValidFullNumber) {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("http://api.whatsapp.com/send?phone="+hasil))
            startActivity(i)
            //Toast.makeText(this, hasil, Toast.LENGTH_SHORT).show()
            true
        } else {
            false
        }
    }
}