package dev.ogabek.mvvmpractice.ui.post

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import dev.ogabek.mvvmpractice.R
import dev.ogabek.mvvmpractice.data.api.ApiClient
import dev.ogabek.mvvmpractice.data.api.ApiService
import dev.ogabek.mvvmpractice.repository.PostRepository
import dev.ogabek.mvvmpractice.repository.viewmodelfactory.PostViewModelFactory
import dev.ogabek.mvvmpractice.utils.UiStateList

class PostFragment : Fragment(R.layout.fragment_post) {

    private lateinit var viewModel: PostViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
//        viewModel = ViewModelProvider(this).get(PostViewModel::class.java)
        /**
         * Line 25 require if ViewModel has not constructor
         */

        viewModel.getPosts()
        setupUI()

    }

    private fun setupUI() {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {

            viewModel.post.collect {
                when (it) {
                    is UiStateList.LOADING -> {
                        // Show Progress
                    }
                    is UiStateList.SUCCESS -> {
                        Log.d("TAG", "setupUI: ${it.data}")
                    }
                    is UiStateList.ERROR -> {
                        Log.d("TAG", "setupUI: ${it.message}")
                    }
                    else -> Unit
                }
            }

        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            PostViewModelFactory(PostRepository(ApiClient.createService(ApiService::class.java)))
        ).get(PostViewModel::class.java)
    }

}