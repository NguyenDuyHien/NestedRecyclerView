package com.example.nestedrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.R
import com.example.nestedrecyclerview.decoration.MovieItemDecoration
import com.example.nestedrecyclerview.model.MovieCategory
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.movie_category_item.*

interface OnCategoryItemClickListener {
    fun onItemClick(categoryTitle: String)
}

interface OnMovieItemClickListener {
    fun onItemClick(movieTitle: String)
    fun onExpandClick()
}

class MovieCategoryAdapter(private val movieCategories: List<MovieCategory>) : RecyclerView.Adapter<MovieCategoryAdapter.MovieCategoryViewHolder>() {

    private lateinit var onCategoryItemClickListener: OnCategoryItemClickListener
    private lateinit var onMovieItemClickListener: OnMovieItemClickListener
    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCategoryViewHolder {
        val containerView = LayoutInflater.from(parent.context).inflate(R.layout.movie_category_item, parent, false)
        return MovieCategoryViewHolder(containerView)
    }

    override fun onBindViewHolder(holder: MovieCategoryViewHolder, position: Int) {
        val movieCategory = movieCategories[position]
        holder.bind(movieCategory)
    }

    override fun getItemCount() = movieCategories.size

    fun setOnCategoryItemClickListener(listener: (String) -> Unit) {
        onCategoryItemClickListener = object : OnCategoryItemClickListener {
            override fun onItemClick(categoryTitle: String) {
                listener(categoryTitle)
            }
        }
    }

    fun setOnMovieItemClickListener(itemClickListener: (String) -> Unit, expandClickListener: () -> Unit) {
        onMovieItemClickListener = object : OnMovieItemClickListener {
            override fun onItemClick(movieTitle: String) {
                itemClickListener(movieTitle)
            }

            override fun onExpandClick() {
                expandClickListener()
            }
        }
    }

    inner class MovieCategoryViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        private lateinit var movieAdapter: MovieAdapter

        fun bind(movieCategory: MovieCategory) {
            category_title.text = movieCategory.type.name
            category_title.setOnClickListener { onCategoryItemClickListener.onItemClick(movieCategory.type.name) }
            movieAdapter = MovieAdapter(movieCategory.movies)
            movieAdapter.setOnMovieItemClickListener ({
                onMovieItemClickListener.onItemClick(it)
            }, {
                movieAdapter.notifyDataSetChanged()
            })
            movie_rv.apply {
                layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
                adapter = movieAdapter
                setRecycledViewPool(viewPool)
                addItemDecoration(MovieItemDecoration())
            }
        }
    }
}