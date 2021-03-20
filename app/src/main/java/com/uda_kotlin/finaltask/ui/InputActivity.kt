package com.uda_kotlin.finaltask.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.uda_kotlin.finaltask.R
import com.uda_kotlin.finaltask.config.NetworkModule
import com.uda_kotlin.finaltask.model.action.ResponseAction
import kotlinx.android.synthetic.main.activity_input.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        populateCategorySpinner()

        //onClickListener
        btn_simpan.setOnClickListener {
            inputData(
                et_pet_name.text.toString(),
                et_pet_imageUrl.text.toString(),
                spinner_pet_category.selectedItem.toString()
            )
        }

        btn_batal.setOnClickListener {
            finish()
        }
    }

    private fun inputData(nama: String?, category: String?, photo: String?) {

        //inputData
        val input = NetworkModule.service().insertData(nama ?: "", category ?: "", photo ?: "")
        input.enqueue(object : Callback<ResponseAction> {
            override fun onResponse(
                call: Call<ResponseAction>,
                response: Response<ResponseAction>
            ) {
                Toast.makeText(applicationContext, "Data Berhasil disimpan", Toast.LENGTH_SHORT)
                    .show()
                finish()
            }

            override fun onFailure(call: Call<ResponseAction>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun populateCategorySpinner() {
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.category_array,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_pet_category.adapter = adapter
    }

}