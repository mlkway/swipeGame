package com.raywenderlich.shemajamebel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.raywenderlich.shemajamebel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: Myadapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRec()




    }

    private fun zeroIndex():Int{
        var ret = 0
        for (i in adapter.data){
            if (adapter.data[i] == 0){
                ret = i

            }
        }
        return ret
    }


    private fun setRec(){
        adapter = Myadapter(object : clickListener{
            override fun clcikEvent(position: Int) {
                adapter.data[zeroIndex()] = adapter.data[position]
                adapter.data[position] = 0
                adapter.notifyDataSetChanged()
            }

        })
        binding.recyclerview.layoutManager = GridLayoutManager(this,3)
        binding.recyclerview.adapter = adapter
        adapter.data.shuffle()
        adapter.notifyDataSetChanged()
    }

}