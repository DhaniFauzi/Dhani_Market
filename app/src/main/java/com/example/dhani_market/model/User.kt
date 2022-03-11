package com.example.dhani_market.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    @Expose
    @SerializedName("address")
    val address:String,

    @Expose
    @SerializedName("city")
    val city:String,

    @Expose
    @SerializedName("created_at")
    val created_at:Long,

    @Expose
    @SerializedName("current_team_id")
    val current_team_id:Any,

    @Expose
    @SerializedName("email")
    val email:String,

    @Expose
    @SerializedName("email_verified_at")
    val email_verfied_at:Any,

    @Expose
    @SerializedName("houseNumber")
    val houseNumber:String,

    @Expose
    @SerializedName("id")
    val id:Int,

    @Expose
    @SerializedName("name")
    val name:String,

    @Expose
    @SerializedName("phoneNumber")
    val phoneNumber:String,

    @Expose
    @SerializedName("profil_photo_path")
    val profil_photo_path:String,

    @Expose
    @SerializedName("profil_photo_url")
    val profil_photo_url:String,

    @Expose
    @SerializedName("roles")
    val roles:String,

    @Expose
    @SerializedName("update_at")
    val update_at:String,
)
