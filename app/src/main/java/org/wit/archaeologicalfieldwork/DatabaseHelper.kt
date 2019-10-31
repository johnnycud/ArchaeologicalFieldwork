package org.wit.archaeologicalfieldwork

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by John cuddihy
 */

class DatabaseHelper (context: Context):SQLiteOpenHelper(context,){
    companion object{
        internal val dbname = "hillfortDB"
        internal val  factory = nullinternal val version = 1
    }
}