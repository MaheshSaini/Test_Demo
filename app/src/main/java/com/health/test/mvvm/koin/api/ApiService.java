package com.health.test.mvvm.koin.api;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;

import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by MAHESH on 24-May-18.
 */

interface ApiService {
    @Multipart
    @POST("/api/upload/postfile/MUTHOOT_IMAGES")
    Call<ResponseBody> uploadFile(@Part("file") RequestBody description, @Part MultipartBody.Part file);

    @Multipart
    @POST("/api/upload/postfile/MUTHOOT_SIGNATURE")
    Call<ResponseBody> uploadFileSignature(@Part("file") RequestBody description, @Part MultipartBody.Part file);

    @Multipart
    @POST("/api/upload/postfile/MUTHOOT_PROFILE_IMAGES")
    Call<ResponseBody> uploadFileProfileImages(@Part("file") RequestBody description, @Part MultipartBody.Part file);

    @Multipart
    @POST("/api/upload/postfile/CrashReport")
    Call<ResponseBody> uploadCrashLogFiles(@Part("file") RequestBody description, @Part MultipartBody.Part file);

}