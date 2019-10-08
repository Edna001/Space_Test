package com.hellocompany.myspaceapp.service.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Suppress("UNREACHABLE_CODE")
data class Companies(
    val name: String?,
    val parentId: Int?,
    val order: Int?,
    val picture: Picture?,
    val companyId: Int?,
    val keywords: String,
    val needsAuthorization: Boolean?,
    val popularity: Int?,
    val paymentCount: Int?,
    val priority: Int?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        TODO("picture"),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()!!,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeValue(parentId)
        parcel.writeValue(order)
        parcel.writeValue(companyId)
        parcel.writeString(keywords)
        parcel.writeValue(needsAuthorization)
        parcel.writeValue(popularity)
        parcel.writeValue(paymentCount)
        parcel.writeValue(priority)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Companies> {
        override fun createFromParcel(parcel: Parcel): Companies {
            return Companies(parcel)
        }

        override fun newArray(size: Int): Array<Companies?> {
            return arrayOfNulls(size)
        }
    }
}