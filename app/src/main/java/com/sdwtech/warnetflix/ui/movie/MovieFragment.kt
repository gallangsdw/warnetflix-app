package com.sdwtech.warnetflix.ui.movie

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdwtech.warnetflix.data.source.local.entity.MovieEntity
import com.sdwtech.warnetflix.databinding.FragmentMovieBinding
import com.sdwtech.warnetflix.ui.detail.DetailActivity
import com.sdwtech.warnetflix.ui.detail.DetailViewModel.Companion.MOVIE
import com.sdwtech.warnetflix.viewmodel.ViewModelFactory
import com.sdwtech.warnetflix.vo.Status

class MovieFragment : Fragment(), MovieAdapter.OnItemClickCallback {
    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

            val movieAdapter = MovieAdapter()

            viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
                if (movies != null) {
                    when (movies.status) {
                        Status.LOADING -> fragmentMovieBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentMovieBinding.progressBar.visibility = View.GONE
                            movieAdapter.submitList(movies.data)
                            movieAdapter.setOnItemClickCallBack(this)
                            movieAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            fragmentMovieBinding.progressBar.visibility = View.GONE
                            Toast.makeText(context,"terjadi kesalahan",Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
            with(fragmentMovieBinding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(false)
                adapter=movieAdapter
            }
        }
    }

    override fun onItemClicked(movieEntity: MovieEntity) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_MOVIE, movieEntity.id)
        intent.putExtra(DetailActivity.EXTRA_TYPE, MOVIE)

        Log.d("movie fragment", "intent movie fragment: ${movieEntity.id}")
        context?.startActivity(intent)
    }
}