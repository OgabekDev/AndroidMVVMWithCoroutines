package dev.ogabek.mvvmpractice.repository.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.ogabek.mvvmpractice.repository.PostRepository
import dev.ogabek.mvvmpractice.ui.post.PostViewModel

class PostViewModelFactory(private val repository: PostRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostViewModel::class.java)) {
            return PostViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}