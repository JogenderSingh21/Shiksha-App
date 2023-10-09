package com.example.exmpl

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exmpl.Model.Chapter
import com.example.exmpl.Model.Experiment

class ChapterAdapter(private var list: List<Chapter>): RecyclerView.Adapter<ChapterAdapter.ChapterViewHolder>(){
    private var originalList: List<Chapter> = list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chapter_details, parent, false)
        return ChapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        val chapter = list[position]

        holder.bind(chapter)

        holder.itemView.setOnClickListener {
            val expanded = chapter.expanded
            chapter.expanded = !expanded
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ChapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val chNum: TextView = itemView.findViewById(R.id.ch_num)
        private val chName: TextView = itemView.findViewById(R.id.ch_name)
        private val subItem: RecyclerView = itemView.findViewById(R.id.expRecyclerView)

        fun bind(chapter: Chapter) {
            val expanded = chapter.expanded
            val experimentList = mutableListOf(
                Experiment(R.drawable.dummyimg,R.raw.vid3,"Experiment ${chNum.text}A"),
                Experiment(R.drawable.dummyimg2,R.raw.vid2,"Experiment ${chNum.text}B"),
                Experiment(R.drawable.dummyimg3,R.raw.vid1,"Experiment ${chNum.text}C")
            )

            val expAdapter = ExperimentAdapter(experimentList)
            subItem.layoutManager = LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
            subItem.adapter = expAdapter
            subItem.setHasFixedSize(true)

            subItem.visibility = if (expanded) View.VISIBLE else View.GONE

            chNum.text = "Chapter ${chapter.chNumber} : "
            chName.text = chapter.chName
        }
    }

    fun filter(query: String) {
        val filteredList = if (query.isBlank()) {
            originalList // Use the original list if the query is empty
        } else {
            originalList.filter { chapter ->
                chapter.chName.contains(query, ignoreCase = true)
            }
        }
        list = filteredList
        notifyDataSetChanged()

    }
}