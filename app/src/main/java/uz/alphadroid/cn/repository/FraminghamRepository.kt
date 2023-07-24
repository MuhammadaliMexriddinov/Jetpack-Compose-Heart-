package uz.alphadroid.cn.repository

import kotlinx.coroutines.flow.Flow
import uz.alphadroid.cn.data.remote.response.FraminghamResponse
import uz.alphadroid.cn.data.remote.response.Score2Response

interface FraminghamRepository {


    fun sendData(
        gender: String,
        age: String,
        t_cholesterol: String,
        LVPV_cholesterol: String,
        blood_pressure: String,
        smoke: String,
        Treatment: String,
    ): Flow<Result<FraminghamResponse>>

}