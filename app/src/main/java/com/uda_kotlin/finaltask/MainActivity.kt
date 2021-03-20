package com.uda_kotlin.finaltask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.uda_kotlin.finaltask.adapter.RVPetListAdapter
import com.uda_kotlin.finaltask.config.NetworkModule
import com.uda_kotlin.finaltask.model.action.ResponseAction
import com.uda_kotlin.finaltask.model.getdata.DataItem
import com.uda_kotlin.finaltask.model.getdata.Pet
import com.uda_kotlin.finaltask.model.getdata.ResponseGetData
import com.uda_kotlin.finaltask.ui.InputActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        home_fab.setOnClickListener {
            val intent = Intent(this, InputActivity::class.java)
            startActivity(intent)
        }

        showData()
    }

    private fun showData() {

        //getData
        val petList = NetworkModule.service().getData()
        petList.enqueue(object : Callback<com.uda_kotlin.finaltask.model.getdata.Response> {
            override fun onResponse(
                call: Call<com.uda_kotlin.finaltask.model.getdata.Response>,
                response: Response<com.uda_kotlin.finaltask.model.getdata.Response>
            ) {
                if (response.isSuccessful) {

                    val item = response.body()?.data

                    val adapter = RVPetListAdapter(item, object : RVPetListAdapter.OnClickListener {
                        override fun detail(item: DataItem?) {
                            TODO("Not yet implemented")
                        }
                    })

                    rv_pet_list.adapter = adapter
                }
            }

            override fun onFailure(call: Call<com.uda_kotlin.finaltask.model.getdata.Response>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    //resume Main activity
    override fun onResume(){
        super.onResume()
        showData()
    }
}