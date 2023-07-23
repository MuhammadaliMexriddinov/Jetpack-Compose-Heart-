package uz.alphadroid.cn.repository

import kotlinx.coroutines.flow.Flow

interface YurakRepository {
    fun sendData(
        age: String,
        sex: String,
        cp: String,
        trestbps: String,
        chol: String,
        fbs: String,
        restcg: String,
        thalach: String,
        exang: String,
        oldpeak: String,
        slope: String,
        ca: String,
        tha: String,
    ): Flow<Result<String>>

}