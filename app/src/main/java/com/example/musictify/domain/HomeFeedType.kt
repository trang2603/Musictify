package com.example.musictify.domain

import java.util.Objects

sealed class HomeFeedType(val title: String? = null) {
    object Music: HomeFeedType("Music")
    object Podcast: HomeFeedType("Podcasts & Shows")
    object None: HomeFeedType()
}