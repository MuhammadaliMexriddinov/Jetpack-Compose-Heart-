package uz.alphadroid.cn.repository

import kotlinx.coroutines.flow.Flow
import uz.alphadroid.cn.data.remote.response.ScoreResponse

interface ScoreRepository {

    fun sendData(
        gender: String,
        age: String,
        cholesterol: String,
        blood_pressure: String,
        smoke: String,
    ): Flow<Result<ScoreResponse>>

}