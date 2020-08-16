package com.example.nestedrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nestedrecyclerview.R
import com.example.nestedrecyclerview.model.Movie
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.last_movie_item.*
import kotlinx.android.synthetic.main.movie_item.movie_desc
import kotlinx.android.synthetic.main.movie_item.movie_image
import kotlinx.android.synthetic.main.movie_item.movie_title

class MovieAdapter(movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private lateinit var onMovieItemClickListener: OnMovieItemClickListener
    private var movies = movies.toMutableList()
    private var hiddenMovies = mutableListOf<Movie>()
    private var isExpandable = true
    private var isExpand = true

    init {
        isExpandable = movies.size > VISIBLE_ITEM
        collapse(VISIBLE_ITEM)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return when (viewType) {
            LAST_ITEM -> {
                val containerView = LayoutInflater.from(parent.context).inflate(R.layout.last_movie_item, parent, false)
                MovieViewHolder(containerView)
            }
            else -> {
                val containerView = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
                MovieViewHolder(containerView)
            }
        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        if (isLastItemAndExpandable(position)) {
            holder.bindLast(movie)
        } else {
            holder.bindNormal(movie)
        }
    }

    override fun getItemViewType(position: Int) = if (isLastItemAndExpandable(position)) LAST_ITEM else NORMAL_ITEM

    override fun getItemCount() = movies.size

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

    fun collapse(offset: Int) {
        if (isExpandable) {
            hiddenMovies.clear()
            movies.forEachIndexed { index, movie ->
                if (index >= offset) {
                    hiddenMovies.add(movie)
                }
            }
            movies.removeAll(hiddenMovies)
            isExpand = false
        }
    }

    fun expand() {
        if (isExpandable) {
            movies.addAll(hiddenMovies)
            hiddenMovies.clear()
            isExpand = true
        }
    }

    private fun isLastItemAndExpandable(position: Int) = (isExpandable && position == movies.size - 1)

    inner class MovieViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bindNormal(movie: Movie) {
            movie_title.text = movie.title
            movie_title.setOnClickListener { onMovieItemClickListener.onItemClick(movie.title) }
            movie_desc.text = movie.description
            Glide.with(containerView).load(movie.imageUrl).into(movie_image)
        }

        fun bindLast(movie: Movie) {
            movie_title.text = movie.title
            movie_title.setOnClickListener { onMovieItemClickListener.onItemClick(movie.title) }
            movie_desc.text = movie.description
            Glide.with(containerView).load(movie.imageUrl).into(movie_image)
            if (isExpand) {
                expand_btn.setImageResource(R.drawable.ic_collapse)
            } else {
                expand_btn.setImageResource(R.drawable.ic_expand)
            }
            expand_btn.setOnClickListener {
                if (isExpand) {
                    collapse(VISIBLE_ITEM)
                } else {
                    expand()
                }
                onMovieItemClickListener.onExpandClick()
            }
        }
    }

    companion object {
        private const val NORMAL_ITEM = 1
        private const val LAST_ITEM = 2
        private const val VISIBLE_ITEM = 2
    }
}