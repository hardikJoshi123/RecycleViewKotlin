package com.arc.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.arc.test.model.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: ListViewModel
    private val usersAdapter = ImageListAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()
        recyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = usersAdapter
        }
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.images.observe(this, Observer { images ->
            images?.let {
                recyclerview.visibility = View.VISIBLE
                usersAdapter.updateUsers(it)
            }
        })
        viewModel.imageLoadError.observe(this, Observer { isError ->
            isError?.let {
                if (it) Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
            }
        })
        viewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let {

            }
        })
    }
}