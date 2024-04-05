package com.yamanf.iconchanger

import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Init Views
        val btnDefault = findViewById<Button>(R.id.btn_default)
        val btnSmile = findViewById<Button>(R.id.btn_smile)
        val btnTongue = findViewById<Button>(R.id.btn_tongue)
        val btnSad = findViewById<Button>(R.id.btn_sad)

        btnDefault.setOnClickListener { setAppIcon("default") }
        btnSmile.setOnClickListener { setAppIcon("smile") }
        btnTongue.setOnClickListener { setAppIcon("tongue") }
        btnSad.setOnClickListener { setAppIcon("sad") }

    }

    private fun setAppIcon(iconId: String) {
        val icon = appIcons.find { it.id == iconId } ?: return
        val context = baseContext
        val packageManager = context.packageManager

        appIcons.filterNot { it.id == iconId }.forEach {
            packageManager.setComponentEnabledSetting(
                ComponentName(context, it.component),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP
            )
        }

        packageManager.setComponentEnabledSetting(
            ComponentName(context, icon.component),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
    }
}