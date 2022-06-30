package com.example.week7day1_mystory

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Color.rgb
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random


class customAdapter (val storyiesList :ArrayList<Story>, val context :Context):RecyclerView.Adapter<customAdapter.DataHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
      val dataholder =DataHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_layout,parent,false))
    return dataholder}

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        val story =storyiesList[position]
        holder.storyTitle.text =story.title
        holder.subTitle.text=story.subtitle
        holder.storyletter.text=story.title.first().toString()
        genratecolores(holder,position)
        holder.itemView.setOnClickListener{
            val i =Intent(context,StoryDetailes ::class.java)

            i.putExtra("title",story.title)
            i.putExtra("desc",story.descrpition)
            context.startActivity(i)
        }
    }
private fun genratecolores(holder:DataHolder ,position: Int){
    val r = java.util.Random()
    val red =r.nextInt(255+position )
    val  green = r.nextInt(255 -position +4)
    val blue = r.nextInt(255-position-1)


   holder.cardview.setCardBackgroundColor(Color.rgb(red,green,blue) )



}
    override fun getItemCount(): Int {
       return storyiesList.count()
    }
    class  DataHolder(item:View):RecyclerView.ViewHolder(item){
        val storyTitle :TextView =item.findViewById(R.id.tvTitle)
        val subTitle :TextView=item.findViewById(R.id.subtitle)
        val storyletter :TextView=item.findViewById(R.id.tletter)

        val cardview :CardView =item.findViewById(R.id.circle)
    }
}