package uz.alphadroid.cn.repository

import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query
import uz.alphadroid.cn.data.remote.response.Score2Response
import uz.alphadroid.cn.data.remote.response.ScoreResponse

interface Score2Repository {

    fun sendData(
        age_user: String,
        gender_user: String,
        smoke: String,
        total_cholesterol: String,
        Diabetes: String,
        S_Blood_P: String,
        HDL_cholesterol: String,
        T_hypertension: String,
        country_user: String,
    ): Flow<Result<Score2Response>>


}