package org.wit.archaeologicalfieldwork.models

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

var lastId = 0L

internal fun getId(): Long {
  return lastId++
}

class HillfortMemStore : HillfortStore, AnkoLogger {

  val placemarks = ArrayList<HillfortModel>()

  override fun findAll(): List<HillfortModel> {
    return placemarks
  }

  override fun create(hillfort: HillfortModel) {
    hillfort.id = getId()
    placemarks.add(hillfort)
    logAll()
  }

  override fun update(hillfort: HillfortModel) {
    var foundHillfort: HillfortModel? = placemarks.find { p -> p.id == hillfort.id }
    if (foundHillfort != null) {
      foundHillfort.title = hillfort.title
      foundHillfort.description = hillfort.description
    }
  }

  internal fun logAll() {
    placemarks.forEach { info("${it}") }
  }
}