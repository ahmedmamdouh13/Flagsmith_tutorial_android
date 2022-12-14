package com.flag.android.screens.flag

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.flag.android.R
import com.flag.android.adapter.FlagAdapter
import com.flag.android.adapter.FlagPickerSelect
import com.flag.android.flagsmith.FlagConstants
import com.flag.android.flagsmith.builder.FlagsmithBuilder
import com.flag.android.flagsmith.interfaces.IFeatureFoundChecker
import com.flag.android.flagsmith.interfaces.IFlagSingle
import com.flag.android.flagsmith.response.ResponseFlagElement
import com.flag.android.helper.Helper

class FeatureSearchActivity : AppCompatActivity() {

    lateinit var activity: Activity
    lateinit var ed_search_feature : EditText;
    lateinit var bt_searchFeature : Button;
    lateinit var tv_result_searchFeature : TextView;
    lateinit var prg_pageFeatureSearch : ProgressBar;
    lateinit var rv_featureResult : RecyclerView;


    lateinit var flagBuilder : FlagsmithBuilder


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_search)

        this.activity = this;

        //find by ids
        this.ed_search_feature = findViewById(R.id.ed_search_feature)
        this.bt_searchFeature = findViewById(R.id.bt_searchFeature);
        this.tv_result_searchFeature = findViewById(R.id.tv_result_searchFeature)
        this.prg_pageFeatureSearch = findViewById(R.id.prg_pageFeatureSearch)
        this.rv_featureResult = findViewById(R.id.rv_featureResult)

        initBuilder();

        //buttons
        setupButtonSearch();
    }

    private fun initBuilder() {
        flagBuilder = FlagsmithBuilder.Builder()
            .tokenApi( Helper.tokenApiKey)
            .environmentId(Helper.environmentDevelopmentKey)
            .identifierUser( Helper.identifierUserKey)
            .build();
    }


    private fun setupButtonSearch() {
        bt_searchFeature.setOnClickListener{

            //validate
            val entry = ed_search_feature.text.toString();
            if( entry == null || entry.length == 0) {
                Toast.makeText(this, "Enter Feature Identifier", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //api
            apiSearch( entry );

        }
    }

    private fun apiSearch( searchText : String ) {
        //progress
        prg_pageFeatureSearch.visibility = View.VISIBLE;
        rv_featureResult.visibility = View.GONE

        //keybaord
        Helper.keyboardHidden( activity )

        flagBuilder.getFeatureByIdAPi(   searchText, object  : IFlagSingle{
            override fun success(flag: ResponseFlagElement) {

                Helper.callViewInsideThread( activity) {
                    prg_pageFeatureSearch.visibility = View.GONE;

                    createAdapterFlag( flag )
                }


            }

            override fun failed(str: String) {

                Helper.callViewInsideThread( activity) {
                    prg_pageFeatureSearch.visibility = View.GONE;

                    Toast.makeText(activity, str , Toast.LENGTH_SHORT).show()
                }

            }
        });
    }


    private fun createAdapterFlag( flag: ResponseFlagElement ) {

        val list: ArrayList<ResponseFlagElement> = ArrayList()
        list.add( flag )


        val manager = LinearLayoutManager( activity )
        manager.orientation = LinearLayoutManager.VERTICAL
        rv_featureResult.layoutManager = manager
        val customAdapter = FlagAdapter(  activity , list, object : FlagPickerSelect {
            override fun click(favContact: ResponseFlagElement?) {

            }
        })
        rv_featureResult.adapter = customAdapter

        rv_featureResult.visibility = View.VISIBLE
    }


    override fun onResume() {
        super.onResume()
        //keybaord
        Helper.keyboardHidden( activity )
    }

    ///--------------------------------------------- get the flag single data

    fun getFlagByKeyId( keyFlag : String ) {
        flagBuilder.hasFeatureFlag( keyFlag, object  : IFeatureFoundChecker {
            override fun found() {

            }

            override fun notFound() {

            }
        })
    }
}