package uz.alphadroid.cn.repository.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withTimeoutOrNull
import uz.alphadroid.cn.data.remote.api.ApiClient
import uz.alphadroid.cn.repository.YurakRepository

class YurakRepositoryImpl : YurakRepository {

    private val api1 = ApiClient.getExternal()
    private val api2 = ApiClient.getInternal()


    override fun sendData(
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
    ): Flow<Result<String>> = flow<Result<String>> {
        val response = withTimeoutOrNull(1500) {
            val response = api1.register(
                age,
                sex,
                cp,
                trestbps,
                chol,
                fbs,
                restcg,
                thalach,
                exang,
                oldpeak,
                slope,
                ca,
                tha
            )
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(Result.success(it.result))
                }
            }
        }
        if (response != null) {
            // Handle response
        } else {
            val response2 = api2.register(
                age,
                sex,
                cp,
                trestbps,
                chol,
                fbs,
                restcg,
                thalach,
                exang,
                oldpeak,
                slope,
                ca,
                tha
            )

            if (response2.isSuccessful) {
                response2.body()?.let {
                    emit(Result.success(it.result))
                }
            }
        }
    }.catch {
        emit(Result.failure(Exception(it.message)))
    }.flowOn(Dispatchers.IO)

}