package com.example.ecomarina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.children
import androidx.fragment.app.Fragment
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.ecomarina.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import org.json.JSONException
import org.json.JSONObject
import java.nio.charset.Charset


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Beranda())

        binding.bottomNavigationView.children.forEach {
            (it as? ViewGroup)?.children?.forEach {
                it.setOnLongClickListener { _ -> true }
            }
        }

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){

                R.id.beranda -> replaceFragment(Beranda())
                R.id.peringkat -> replaceFragment(Peringkat())
                R.id.laporan -> replaceFragment(Laporan())
                R.id.profil -> replaceFragment(Profil())

                else ->{}
            }
            true
        }
    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}
