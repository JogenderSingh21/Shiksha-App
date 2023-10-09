package com.example.exmpl

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exmpl.Model.Experiment

class ExperimentAdapter(private val list: List<Experiment>): RecyclerView.Adapter<ExperimentAdapter.ExpViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.experiment_item, parent, false)
        return ExpViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpViewHolder, position: Int) {
        val experiment = list[position]
        holder.bind(experiment)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, VideoActivity::class.java)
            intent.putExtra("video", experiment.vid)
            holder.itemView.context.startActivity(intent)
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ExpViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val expName: TextView = itemView.findViewById(R.id.expName)
        private val expImg: ImageView = itemView.findViewById(R.id.expImg)
        fun bind(experiment: Experiment) {
            expName.text = experiment.expName
            expImg.setImageResource(experiment.img)
        }
    }
}