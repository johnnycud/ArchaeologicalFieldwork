package org.wit.archaeologicalfieldwork

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by John cuddihy
 */

class DatabaseHelper (context: Context):SQLiteOpenHelper(context,dbname,factory, version){

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table user(id integer primary ket autoincrement,"+
        "name varchar(30)email varchar(100), password varchar(20)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO(reason = "not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertUserData(name: String, email: String, password: String){
        val db:SQLiteDatabase= this.writableDatabase
        val values: ContentValues = ContentValues()
        values.put("name", name)
        values.put("email",email)
        values.put("password",password)

        db.insert("user",null,values)
        db.close()
    }

    fun userPresent(email: String, password: String):Boolean{
        val db = writableDatabase
        val query = "select * from user where email = $email and password = $password"
        val cursor = db.rawQuery(query, null)
        if (cursor.count<=0){
            cursor.close()
            return false
        }
        cursor.close()
            return true

    }
    companion object{
        internal val dbname = "userDB"
        internal val factory = null
        internal val version = 1
    }
}