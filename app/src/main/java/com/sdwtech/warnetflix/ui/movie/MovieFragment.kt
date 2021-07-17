package com.sdwtech.warnetflix.ui.movie

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdwtech.warnetflix.core.data.Resource
import com.sdwtech.warnetflix.core.domain.model.Movie
import com.sdwtech.warnetflix.databinding.FragmentMovieBinding
import com.sdwtech.warnetflix.ui.detail.DetailActivity
import com.sdwtech.warnetflix.ui.detail.DetailViewModel.Companion.MOVIE
import org.koin.android.viewmodel.ext.android.viewModel

class MovieFragment : Fragment(), MovieAdapter.OnItemClickCallback {

    private val viewModel : MovieViewModel by viewModel()
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
//            val factory = ViewModelFactory.getInstance(requireActivity())
//            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

            val movieAdapter = MovieAdapter()

            viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
                if (movies != null) {
                    when (movies) {
                        is com.sdwtech.warnetflix.core.data.Resource.Loading -> fragmentMovieBinding.progressBar.visibility = View.VISIBLE
                        is com.sdwtech.warnetflix.core.data.Resource.Success -> {
                            fragmentMovieBinding.progressBar.visibility = View.GONE
                            movieAdapter.setOnItemClickCallBack(this)
                            movieAdapter.setData(movies.data)
                        }
                        is com.sdwtech.warnetflix.core.data.Resource.Error -> {
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

    override fun onItemClicked(movie: Movie) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_ID, movie.id)
        intent.putExtra(DetailActivity.EXTRA_TYPE, MOVIE)

        Log.d("movie fragment", "intent movie fragment: ${movie.id}")
        context?.startActivity(intent)
    }
}