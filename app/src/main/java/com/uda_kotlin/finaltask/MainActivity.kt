package com.uda_kotlin.finaltask

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.uda_kotlin.finaltask.adapter.RVPetListAdapter
import com.uda_kotlin.finaltask.config.NetworkModule
import com.uda_kotlin.finaltask.model.action.ResponseAction
import com.uda_kotlin.finaltask.model.getdata.DataItem
import com.uda_kotlin.finaltask.ui.InputActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cvCat1 = cv_cat_1
        val cvCat2 = cv_cat_2
        val cvCat3 = cv_cat_3
        val cvCat4 = cv_cat_4


        home_fab.setOnClickListener {
            val intent = Intent(this, InputActivity::class.java)
            startActivity(intent)
        }

        operateCategorySelection(1)

        cvCat1.setOnClickListener { operateCategorySelection(1) }
        cvCat2.setOnClickListener { operateCategorySelection(2) }
        cvCat3.setOnClickListener { operateCategorySelection(3) }
        cvCat4.setOnClickListener { operateCategorySelection(4) }

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

                            //Update
                            val intent = Intent(applicationContext, InputActivity::class.java)
                            intent.putExtra("data", item)
                            startActivity(intent)
                        }

                        override fun hapus(item: DataItem?) {

                            //Delete
                            AlertDialog.Builder(this@MainActivity).apply {
                                setTitle("Hapus data")
                                setMessage("Yakin mau hapus data?")
                                setPositiveButton("Hapus") { dialog, which ->
                                    hapusData(item?.id)
                                    dialog.dismiss()
                                }
                                setNegativeButton("Batal") { dialog, which ->
                                    dialog.dismiss()
                                }
                            }.show()

                        }
                    })

                    rv_pet_list.adapter = adapter
                }
            }

            override fun onFailure(
                call: Call<com.uda_kotlin.finaltask.model.getdata.Response>,
                t: Throwable
            ) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun showDataCat() {

        //getData
        val petList = NetworkModule.service().getDataByCategory("Cat")
        petList.enqueue(object : Callback<com.uda_kotlin.finaltask.model.getdata.Response> {
            override fun onResponse(
                call: Call<com.uda_kotlin.finaltask.model.getdata.Response>,
                response: Response<com.uda_kotlin.finaltask.model.getdata.Response>
            ) {
                if (response.isSuccessful) {

                    val item = response.body()?.data

                    val adapter = RVPetListAdapter(item, object : RVPetListAdapter.OnClickListener {
                        override fun detail(item: DataItem?) {

                            //Update
                            val intent = Intent(applicationContext, InputActivity::class.java)
                            intent.putExtra("data", item)
                            startActivity(intent)
                        }

                        override fun hapus(item: DataItem?) {

                            //Delete
                            AlertDialog.Builder(this@MainActivity).apply {
                                setTitle("Hapus data")
                                setMessage("Yakin mau hapus data?")
                                setPositiveButton("Hapus") { dialog, which ->
                                    hapusData(item?.id)
                                    dialog.dismiss()
                                }
                                setNegativeButton("Batal") { dialog, which ->
                                    dialog.dismiss()
                                }
                            }.show()

                        }
                    })

                    rv_pet_list.adapter = adapter
                }
            }

            override fun onFailure(
                call: Call<com.uda_kotlin.finaltask.model.getdata.Response>,
                t: Throwable
            ) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun showDataDog() {

        //getData
        val petList = NetworkModule.service().getDataByCategory("Dog")
        petList.enqueue(object : Callback<com.uda_kotlin.finaltask.model.getdata.Response> {
            override fun onResponse(
                call: Call<com.uda_kotlin.finaltask.model.getdata.Response>,
                response: Response<com.uda_kotlin.finaltask.model.getdata.Response>
            ) {
                if (response.isSuccessful) {

                    val item = response.body()?.data

                    val adapter = RVPetListAdapter(item, object : RVPetListAdapter.OnClickListener {
                        override fun detail(item: DataItem?) {

                            //Update
                            val intent = Intent(applicationContext, InputActivity::class.java)
                            intent.putExtra("data", item)
                            startActivity(intent)
                        }

                        override fun hapus(item: DataItem?) {

                            //Delete
                            AlertDialog.Builder(this@MainActivity).apply {
                                setTitle("Hapus data")
                                setMessage("Yakin mau hapus data?")
                                setPositiveButton("Hapus") { dialog, which ->
                                    hapusData(item?.id)
                                    dialog.dismiss()
                                }
                                setNegativeButton("Batal") { dialog, which ->
                                    dialog.dismiss()
                                }
                            }.show()

                        }
                    })

                    rv_pet_list.adapter = adapter
                }
            }

            override fun onFailure(
                call: Call<com.uda_kotlin.finaltask.model.getdata.Response>,
                t: Throwable
            ) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun showDataBird() {

        //getData
        val petList = NetworkModule.service().getDataByCategory("Bird")
        petList.enqueue(object : Callback<com.uda_kotlin.finaltask.model.getdata.Response> {
            override fun onResponse(
                call: Call<com.uda_kotlin.finaltask.model.getdata.Response>,
                response: Response<com.uda_kotlin.finaltask.model.getdata.Response>
            ) {
                if (response.isSuccessful) {

                    val item = response.body()?.data

                    val adapter = RVPetListAdapter(item, object : RVPetListAdapter.OnClickListener {
                        override fun detail(item: DataItem?) {

                            //Update
                            val intent = Intent(applicationContext, InputActivity::class.java)
                            intent.putExtra("data", item)
                            startActivity(intent)
                        }

                        override fun hapus(item: DataItem?) {

                            //Delete
                            AlertDialog.Builder(this@MainActivity).apply {
                                setTitle("Hapus data")
                                setMessage("Yakin mau hapus data?")
                                setPositiveButton("Hapus") { dialog, which ->
                                    hapusData(item?.id)
                                    dialog.dismiss()
                                }
                                setNegativeButton("Batal") { dialog, which ->
                                    dialog.dismiss()
                                }
                            }.show()

                        }
                    })

                    rv_pet_list.adapter = adapter
                }
            }

            override fun onFailure(
                call: Call<com.uda_kotlin.finaltask.model.getdata.Response>,
                t: Throwable
            ) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun hapusData(id: String?) {

        val hapus = NetworkModule.service().deleteData(id ?: "")
        hapus.enqueue(object : Callback<ResponseAction> {
            override fun onResponse(
                call: Call<ResponseAction>,
                response: Response<ResponseAction>
            ) {
                Toast.makeText(applicationContext, "Data Berhasil dihapus", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onFailure(call: Call<ResponseAction>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }

    //resume Main activity
    override fun onResume() {
        super.onResume()
        showData()
    }


    private fun operateCategorySelection(position: Int) {
        val cvCat1 = cv_cat_1
        val cvCat2 = cv_cat_2
        val cvCat3 = cv_cat_3
        val cvCat4 = cv_cat_4


        val tvCat1 = tv_cat_1
        val tvCat2 = tv_cat_2
        val tvCat3 = tv_cat_3
        val tvCat4 = tv_cat_4


        tvCat1?.setTextColor(Color.BLACK)
        tvCat2?.setTextColor(Color.BLACK)
        tvCat3?.setTextColor(Color.BLACK)
        tvCat4?.setTextColor(Color.BLACK)

        cvCat1?.setCardBackgroundColor(Color.WHITE)
        cvCat2?.setCardBackgroundColor(Color.WHITE)
        cvCat3?.setCardBackgroundColor(Color.WHITE)
        cvCat4?.setCardBackgroundColor(Color.WHITE)


        when (position) {
            1 -> {
                Log.d("Working", "1")
                cvCat1?.setCardBackgroundColor(Color.parseColor("#00BCD4"))
                tvCat1?.setTextColor(Color.WHITE)
                showData()
            }
            2 -> {
                Log.d("Working", "2")
                cvCat2?.setCardBackgroundColor(Color.parseColor("#00BCD4"))
                tvCat2?.setTextColor(Color.WHITE)
                showDataCat()
            }
            3 -> {
                Log.d("Working", "3")
                cvCat3?.setCardBackgroundColor(Color.parseColor("#00BCD4"))
                tvCat3?.setTextColor(Color.WHITE)
                showDataDog()
            }
            4 -> {
                Log.d("Working", "4")
                cvCat4?.setCardBackgroundColor(Color.parseColor("#00BCD4"))
                tvCat4?.setTextColor(Color.WHITE)
                showDataBird()
            }
        }
    }
}