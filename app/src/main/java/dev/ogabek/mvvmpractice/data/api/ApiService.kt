package dev.ogabek.mvvmpractice.data.api

import dev.ogabek.mvvmpractice.model.Post
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): List<Post>

}