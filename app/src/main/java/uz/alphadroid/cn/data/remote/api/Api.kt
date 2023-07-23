package uz.alphadroid.cn.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import uz.alphadroid.cn.data.remote.response.ScoreResponse
import uz.alphadroid.cn.data.remote.response.YurakResponse

interface Api {

    @GET("/defheartdis")
    suspend fun register(
        @Query("age") age: String,
        @Query("sex") sex: String,
        @Query("cp") cp: String,
        @Query("trestbps") trestbps: String,
        @Query("chol") chol: String,
        @Query("fbs") fbs: String,
        @Query("restcg") restcg: String,
        @Query("thalach") thalach: String,
        @Query("exang") exang: String,
        @Query("oldpeak") oldpeak: String,
        @Query("slope") slope: String,
        @Query("ca") ca: String,
        @Query("tha") tha: String,
    ): Response<YurakResponse>

    @GET("/defheartdis")
    suspend fun registerScore(
        @Query("gender") gender: String,
        @Query("age") age: String,
        @Query("cholesterol") cholesterol: String,
        @Query("blood_pressure") blood_pressure: String,
        @Query("smoke") smoke: String,
    ): Response<ScoreResponse>



}