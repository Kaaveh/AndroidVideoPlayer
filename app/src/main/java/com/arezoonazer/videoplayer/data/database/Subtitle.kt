package com.arezoonazer.videoplayer.data.database

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "subtitle",
    foreignKeys = [ForeignKey(
        entity = Video::class,
        parentColumns = ["id"],
        childColumns = ["videoId"],
        onDelete = CASCADE
    )]
)

class Subtitle(
    var videoId: Int = 0,
    var title: String? = null,
    var subtitleUrl: String? = null
) : Parcelable {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
        id = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(videoId)
        parcel.writeString(title)
        parcel.writeString(subtitleUrl)
        parcel.writeInt(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Subtitle> {
        override fun createFromParcel(parcel: Parcel): Subtitle {
            return Subtitle(parcel)
        }

        override fun newArray(size: Int): Array<Subtitle?> {
            return arrayOfNulls(size)
        }
    }

}
