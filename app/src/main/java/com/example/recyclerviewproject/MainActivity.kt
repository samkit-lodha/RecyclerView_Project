package com.example.recyclerviewproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler =  findViewById<RecyclerView>(R.id.recycler_view)

        val iAL = listOf<Int>(
            R.drawable.awa,
            R.drawable.awb,
            R.drawable.awc,
            R.drawable.cpa,
            R.drawable.cpb,
            R.drawable.cpc,
            R.drawable.doa,
            R.drawable.edsa,
            R.drawable.edsb,
            R.drawable.ida,
            R.drawable.idb,
            R.drawable.idc,
            R.drawable.lpa,
            R.drawable.lpb,
            R.drawable.lpc,
            R.drawable.ora,
            R.drawable.orb,
            R.drawable.orc,
            R.drawable.sga,
            R.drawable.sma,
            R.drawable.smb
        )

        val tAL = listOf<String>(
            "Faded","Alone","Darkside","Attention","Boy","We Don't Talk Anymore","Danze Kuduro","Castle On The Hill",
            "Perfect","Demons","Bad Liar","Thunder","Numb","Battle Symphony","Heavy","Start Again","Connection","Counting Stars","Wolves","Senorita","Treat You Better"
        )

        val bAL = listOf<String>(
            "Alan Walker","Alan Walker","Alan Walker","Charlie Puth","Charlie Puth","Charlie Puth","Don Omar","Ed Sheeran","Ed Sheeran",
            "Imagine Dragons","Imagine Dragons","Imagine Dragons","Linkin Park","Linkin Park","Linkin Park","One Republic","One Republic","One Republic","Selena Gomez",
            "Shawn Mendes","Shawn Mendes"
        )

        val yAL = listOf<Int>(
            2007,2015,2013,2016,2017,2011,2012,2006,2009,2016,2020,2001,2012,2018,2013,2006,2021,2015,2018,2019,2021
        )

        val sAL : MutableList<Songs> = mutableListOf()

        for(key in iAL.indices){
            val temp = Songs(iAL[key],tAL[key],bAL[key],yAL[key])
            sAL.add(temp)
        }

        val adapter = MyAdapter(sAL)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)

        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClicked(position: Int) {
                Toast.makeText(this@MainActivity,"Playing song $position",Toast.LENGTH_SHORT).show()
            }
        })
    }
}