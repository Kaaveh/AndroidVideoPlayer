package com.arezoonazer.videoplayer.data.model

import com.arezoonazer.videoplayer.data.database.Subtitle
import java.io.Serializable

data class VideoSource(
    var videos: List<SingleVideo>? = null,
    var selectedSourceIndex: Int = 0
) : Serializable {

    data class SingleVideo(
        var url: String? = null,
        var subtitles: List<Subtitle>? = null,
        var watchedLength: Long? = null
    ) : Serializable
}

