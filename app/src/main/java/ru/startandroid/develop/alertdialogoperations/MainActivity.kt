package ru.startandroid.develop.alertdialogoperations

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View

const val LOG_TAG = "myLogs"
const val DIALOG = 1

class MainActivity : AppCompatActivity() {

    var dialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateDialog(id: Int): Dialog? {
        if (id == DIALOG) {
            Log.d(LOG_TAG, "Create")
            val adb = AlertDialog.Builder(this)
            adb.setTitle("Title")
            adb.setMessage("Message")
            adb.setPositiveButton("OK", null)
            dialog = adb.create()

            dialog!!.setOnShowListener { dialog ->
                Log.d(LOG_TAG, "show")
            }

            dialog!!.setOnCancelListener { dialog ->
                Log.d(LOG_TAG, "Cancel")
            }


            dialog!!.setOnDismissListener { dialog ->
                Log.d(LOG_TAG, "Dismiss")
            }
            return dialog
        }
    return super.onCreateDialog(id)
    }

    fun method1() {
        //dialog!!.dismiss()
        //dialog!!.cancel()
        //dialog!!.hide()
        //dismissDialog(DIALOG)
        removeDialog(DIALOG)
    }
    fun method2() {
        showDialog(DIALOG)
    }

    fun onClick(v: View?) {
        showDialog(DIALOG)

        val h = Handler()
        h.postDelayed(kotlinx.coroutines.Runnable { method1()},  2000)

        h.postDelayed(kotlinx.coroutines.Runnable { method2()},  2000)
    }
}