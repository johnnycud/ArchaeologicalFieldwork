package org.wit.archaeologicalfieldwork.main

import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.archaeologicalfieldwork.models.HillfortMemStore


class MainApp : Application(), AnkoLogger {

  val hillforts = HillfortMemStore()

  override fun onCreate() {
    super.onCreate()
    info("Hillfort App started")
  }
}