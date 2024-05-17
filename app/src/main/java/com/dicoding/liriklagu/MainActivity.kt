package com.dicoding.liriklagu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.liriklagu.adapter.ListMusikAdapter
import com.dicoding.liriklagu.data.Musik

class MainActivity : AppCompatActivity() {

    private lateinit var rv_penyanyi: RecyclerView
    private val list = ArrayList<Musik>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_penyanyi = findViewById(R.id.rv_penyanyi)
        rv_penyanyi.setHasFixedSize(true)

        list.addAll(getListPenyanyi())
        showRecyclerList()
    }

    private fun getListPenyanyi(): ArrayList<Musik> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listMusik = ArrayList<Musik>()

        for (i in dataName.indices) {
            val musik = Musik(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listMusik.add(musik)
        }
        dataPhoto.recycle()  // Jangan lupa untuk mendaur ulang TypedArray
        return listMusik
    }

    private fun showRecyclerList() {
        rv_penyanyi.layoutManager = LinearLayoutManager(this)
        val listMusikAdapter = ListMusikAdapter(list)
        rv_penyanyi.adapter = listMusikAdapter
    }
}
