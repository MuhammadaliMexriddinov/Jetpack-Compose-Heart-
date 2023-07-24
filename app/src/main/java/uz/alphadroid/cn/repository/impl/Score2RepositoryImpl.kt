package uz.alphadroid.cn.repository.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withTimeoutOrNull
import uz.alphadroid.cn.data.remote.api.ApiClient
import uz.alphadroid.cn.data.remote.response.Score2Response
import uz.alphadroid.cn.repository.Score2Repository

class Score2RepositoryImpl :Score2Repository{


    private val api1 = ApiClient.getExternal()
    private val api2 = ApiClient.getInternal()


    override fun sendData(
        age_user: String,
        gender_user: String,
        smoke: String,
        total_cholesterol: String,
        Diabetes: String,
        S_Blood_P: String,
        HDL_cholesterol: String,
        T_hypertension: String,
        country_user: String,
    ): Flow<Result<Score2Response>> = flow<Result<Score2Response>> {
        val response = withTimeoutOrNull(1500) {
            val response = api1.registerScore2(
                age_user,
                gender_user,
                smoke,
                total_cholesterol,
                Diabetes,
                S_Blood_P,
                HDL_cholesterol,
                T_hypertension,
                country_user,
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
            val response2 = api2.registerScore2(
                age_user,
                gender_user,
                smoke,
                total_cholesterol,
                Diabetes,
                S_Blood_P,
                HDL_cholesterol,
                T_hypertension,
                country_user,
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