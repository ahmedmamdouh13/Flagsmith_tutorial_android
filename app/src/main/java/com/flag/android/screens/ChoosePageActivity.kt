package com.flag.android.screens

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.flag.android.R
import com.flag.android.helper.Helper
import com.flag.android.library.FlagsmithSDK
import com.flag.android.screens.flag.FeatureSearchActivity
import com.flag.android.screens.flag.FlagListActivity
import com.flag.android.screens.trait.TraitsActivity

class ChoosePageActivity : AppCompatActivity() {

    lateinit var activity: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_page)
        activity = this;

        setup_bt_flags();
        setup_bt_feature()
        setup_bt_trait()

        //test
//        var sdk = FlagsmithSDK()

//        var builderSDK : FlagsmithSDK.Builder = FlagsmithSDK.Builder()
//        builderSDK.setAPIKey( Helper.tokenApiKey)
    }

    private fun setup_bt_flags() {
        var bt_flags : Button = findViewById(R.id.bt_flags)
        bt_flags.setOnClickListener{
            Log.i( "abdo","setup_bt_flags() - click ")

            val i = Intent( activity, FlagListActivity::class.java);
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(i)
        }
    }

    private fun setup_bt_feature() {
        var bt_feature : Button = findViewById(R.id.bt_feature)
        bt_feature.setOnClickListener{
            val i = Intent( activity, FeatureSearchActivity::class.java);
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(i)
        }
    }

    private fun setup_bt_trait() {
        var bt_trait : Button = findViewById(R.id.bt_trait)
        bt_trait.setOnClickListener{

            val i = Intent( activity, TraitsActivity::class.java);
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(i)

        }
    }

}