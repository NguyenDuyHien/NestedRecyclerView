package com.example.nestedrecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.adapter.MovieCategoryAdapter
import com.example.nestedrecyclerview.decoration.MovieCategoryItemDecoration
import com.example.nestedrecyclerview.model.getDummyData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var movieCategoryAdapter: MovieCategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieCategoryAdapter = MovieCategoryAdapter(getDummyData())
        movieCategoryAdapter.setOnCategoryItemClickListener {
            Toast.makeText(this, "$it category clicked", Toast.LENGTH_SHORT).show()
        }
        movieCategoryAdapter.setOnMovieItemClickListener({
            Toast.makeText(this, "$it clicked", Toast.LENGTH_SHORT).show()
        }, {
        })

        category_rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            adapter = movieCategoryAdapter
            addItemDecoration(MovieCategoryItemDecoration())
        }
    }
}
