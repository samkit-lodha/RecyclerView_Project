package com.example.recyclerviewproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val songsList : List<Songs>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClicked( position: Int)
    }

    fun setOnItemClickListener(listener : onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.list_view,parent,false)
        return MyViewHolder(view,mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.imageId.setImageResource(songsList[position].image)
        holder.titleId.text = songsList[position].title
        holder.bandId.text = songsList[position].band
        holder.yearId.text = String.format("%d",songsList[position].year)
    }

    override fun getItemCount(): Int {
        return songsList.size
    }

    class MyViewHolder(itemView : View,listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        var imageId = itemView.findViewById<ImageView>(R.id.songImage)
        var titleId = itemView.findViewById<TextView>(R.id.songTitle)
        var bandId = itemView.findViewById<TextView>(R.id.songBand)
        var yearId = itemView.findViewById<TextView>(R.id.songYear)

        init {
            itemView.setOnClickListener {
                listener.onItemClicked(adapterPosition)
            }
        }
    }

}