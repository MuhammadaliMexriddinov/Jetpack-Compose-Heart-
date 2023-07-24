package uz.alphadroid.cn.repository.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withTimeoutOrNull
import uz.alphadroid.cn.data.remote.api.ApiClient
import uz.alphadroid.cn.data.remote.response.FraminghamResponse
import uz.alphadroid.cn.repository.FraminghamRepository

class FraminghamRepositoryImpl : FraminghamRepository {

    private val api1 = ApiClient.getExternal()
    private val api2 = ApiClient.getInternal()


    override fun sendData(
        gender: String,
        age: String,
        t_cholesterol: String,
        LVPV_cholesterol: String,
        blood_pressure: String,
        smoke: String,
        Treatment: String,
    ): Flow<Result<FraminghamResponse>> = flow<Result<FraminghamResponse>> {
        val response = withTimeoutOrNull(1500) {
            val response = api1.registerFramingham(
                gender,
                age,
                t_cholesterol,
                LVPV_cholesterol,
                blood_pressure,
                smoke,
                Treatment,
            )
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(Result.success(it))
                }
            }
        }
        if (response != null) {
            // Handle response
        } else {
            val response2 = api2.registerFramingham(
                gender,
                age,
                t_cholesterol,
                LVPV_cholesterol,
                blood_pressure,
                smoke,
                Treatment,
            )

            if (response2.isSuccessful) {
                response2.body()?.let {
                    emit(Result.success(it))
                }
            }
        }
    }.catch {
        emit(Result.failure(Exception(it.message)))
    }.flowOn(Dispatchers.IO)


}