package com.raywenderlich.shemajamebel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.shemajamebel.databinding.NumberItemBinding
import com.raywenderlich.shemajamebel.databinding.SpaceItemBinding

class Myadapter(private val clickListener: clickListener):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var data = mutableListOf(0,1,2,3,4,5,6,7,8)


    var twoD = mutableListOf(mutableListOf(0,1,2), mutableListOf(3,4,5), mutableListOf(6,7,8))





    override fun getItemViewType(position: Int): Int {
        if (data[position] == 0){
            return 0
        }else{
            return 1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            0 -> {
                SpaceViewHolder(SpaceItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            }else -> {
                NumberViewHolder(NumberItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is SpaceViewHolder){
            holder.bind()
        }else if (holder is NumberViewHolder){
            holder.bind()
        }
    }

    override fun getItemCount()=data.size

    inner class SpaceViewHolder(private val binding: SpaceItemBinding):RecyclerView.ViewHolder(binding.root){


        fun bind(){

        }
    }

    inner class NumberViewHolder(private val binding: NumberItemBinding):RecyclerView.ViewHolder(binding.root),View.OnClickListener{


        fun bind(){

            var  currentItem = data[adapterPosition]
            if (!checkPosition(currentItem)){
                binding.root.setBackgroundResource(R.color.teal_200)
            }
            binding.txt.text = currentItem.toString()
            binding.txt.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

            clickListener.clcikEvent(adapterPosition)
        }
    }


    private fun checkPosition(crnt: Int):Boolean{
        return data[crnt] == data[crnt]+1
    }






}