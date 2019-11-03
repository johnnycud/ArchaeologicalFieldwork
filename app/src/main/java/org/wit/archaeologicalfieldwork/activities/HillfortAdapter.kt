package org.wit.archaeologicalfieldwork.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.wit.archaeologicalfieldwork.R
import org.wit.archaeologicalfieldwork.models.HillfortModel
import org.wit.hillfort.R
import org.wit.hillfort.models.HillfortModel

interface HillfortListener {
  fun onhillfortClick(hillfort: HillfortModel)
}

class HillfortAdapter constructor(private var hillforts: List<HillfortModel>,
                                   private val listener: HillfortListener) : RecyclerView.Adapter<HillfortAdapter.MainHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
    return MainHolder(LayoutInflater.from(parent?.context).inflate(R.layout.card_hillfort, parent, false))
  }

  override fun onBindViewHolder(holder: MainHolder, position: Int) {
    val hillfort = hillforts[holder.adapterPosition]
    holder.bind(hillfort, listener)
  }

  override fun getItemCount(): Int = hillforts.size

  class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(hillfort: HillfortModel, listener: HillfortListener) {
      itemView.placemarkTitle.text = hillfort.title
      itemView.description.text = hillfort.description
      itemView.setOnClickListener { listener.onhillfortClick(hillfort) }
    }
  }
}