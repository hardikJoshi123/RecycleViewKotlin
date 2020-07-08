package com.arc.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val options = RequestOptions()
            .placeholder(R.drawable.loader)
            .error(R.mipmap.ic_launcher_round)
        Glide.with(this@DetailActivity)
            .setDefaultRequestOptions(options)
            .load(intent.extras!!.getString("url"))
            .into(myZoomageView)

    }
}