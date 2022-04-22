package dev.ogabek.mvvmpractice.ui.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.ogabek.mvvmpractice.model.Post
import dev.ogabek.mvvmpractice.repository.PostRepository
import dev.ogabek.mvvmpractice.utils.UiStateList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PostViewModel(
    private val repository: PostRepository
    // We can add also Database Repository
) : ViewModel() {

    private val _postState = MutableStateFlow<UiStateList<Post>>(UiStateList.EMPTY)
    val post = _postState

    fun getPosts() = viewModelScope.launch {
        _postState.value = UiStateList.LOADING
        try {
            val posts = repository.getPosts()
            _postState.value = UiStateList.SUCCESS(posts)
        } catch (e: Exception) {
            _postState.value = UiStateList.ERROR(e.localizedMessage ?: "No Connection")
        }
    }

}