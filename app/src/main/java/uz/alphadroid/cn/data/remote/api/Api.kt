package uz.alphadroid.cn.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import uz.alphadroid.cn.data.remote.response.FraminghamResponse
import uz.alphadroid.cn.data.remote.response.Score2Response
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

    @GET("/score")
    suspend fun registerScore(
        @Query("gender") gender: String,
        @Query("age") age: String,
        @Query("cholesterol") cholesterol: String,
        @Query("blood_pressure") blood_pressure: String,
        @Query("smoke") smoke: String,
    ): Response<ScoreResponse>


    @GET("/score2")
    suspend fun registerScore2(
        @Query("age_user") age_user: String,
        @Query("gender_user") gender_user: String,
        @Query("smoke") smoke: String,
        @Query("total_cholesterol") total_cholesterol: String,
        @Query("Diabetes") Diabetes: String,
        @Query("S_Blood_P") S_Blood_P: String,
        @Query("HDL_cholesterol") HDL_cholesterol: String,
        @Query("T_hypertension") T_hypertension: String,
        @Query("country_user") country_user: String,
    ): Response<Score2Response>

    @GET("/frame")
    suspend fun registerFramingham(
        @Query("gender") gender: String,
        @Query("age") age: String,
        @Query("t_cholesterol") t_cholesterol: String,
        @Query("LVPV_cholesterol") LVPV_cholesterol: String,
        @Query("blood_pressure") blood_pressure: String,
        @Query("smoke") smoke: String,
        @Query("Treatment") Treatment: String,
    ): Response<FraminghamResponse>

}