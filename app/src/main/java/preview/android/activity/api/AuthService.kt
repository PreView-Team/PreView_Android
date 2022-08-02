package preview.android.activity.api

import preview.android.activity.api.dto.*
import preview.android.model.Account
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface AuthService {
    @POST("/api/user/kakao/signup")
    suspend fun signUp(@Body account: Account): Response<SignUpResponse>

    @POST("/api/login")
    suspend fun login(@Body kakaoAccessToken: LoginData): Response<LoginResponse>

    @GET("/api/user/nickname/{nickname}")
    suspend fun nickname(@Path("nickname") nickname: String): Response<NicknameResponse>

    @PUT("/api/user/nickname")
    suspend fun editNickname(
        @Header("Authorization") token: String,
        @Body nickname: EditNickname
    ): Response<EditNicknameResponse>


    @PUT("/api/user")
    suspend fun editUser(
        @Header("Authorization") token: String,
        @Body jobDtoSet: EditUserData
    ): Response<EditNicknameResponse>

    @DELETE("/api/user")
    suspend fun signOut(
        @Header("Authorization") token: String
    ): Response<SignUpResponse>

}