package com.example.googlemapsintegration.concrete

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem

class MyItem(private val position: LatLng) : ClusterItem {
    override fun getPosition(): LatLng {
        return position
    }

    override fun getTitle(): String? {
        return null // Başlık değerini döndürün (isteğe bağlı olarak)
    }

    override fun getSnippet(): String? {
        return null // Özet değerini döndürün (isteğe bağlı olarak)
    }
}