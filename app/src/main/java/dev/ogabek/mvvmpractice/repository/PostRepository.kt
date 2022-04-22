package dev.ogabek.mvvmpractice.repository

import dev.ogabek.mvvmpractice.data.api.ApiService

class PostRepository(
    private val apiService: ApiService
) {

    suspend fun getPosts() = apiService.getPosts()

}