import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.example.googlemapsintegration.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem
import com.google.maps.android.clustering.ClusterManager

class MapsActivity : FragmentActivity(), OnMapReadyCallback {

    private lateinit var clusterManager: ClusterManager<MyItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        clusterManager = ClusterManager(this, googleMap)

        googleMap.setOnCameraIdleListener(clusterManager)
        googleMap.setOnMarkerClickListener(clusterManager)

        addMarkers()

        val initialLatLng = LatLng(37.7749, -122.4194)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(initialLatLng, 10f))
    }

    private fun addMarkers() {
        val markerCoordinates = listOf(
            LatLng(40.37575419227409, 49.85099884637812),
            LatLng(40.37593759350822, 49.842804226202944),
            LatLng(40.38254784812336, 49.847037132906145),
            LatLng(40.371826010461916, 49.84407409821391),
            LatLng(40.37138258946073, 49.83814802882943),

            // ... Diğer koordinatlar
        )

        for (coordinate in markerCoordinates) {
            val item = MyItem(coordinate)
            clusterManager.addItem(item)
        }
    }

    inner class MyItem(private val position: LatLng) : ClusterItem {
        override fun getPosition(): LatLng {
            return position
        }

        override fun getTitle(): String? {
            return null
        }

        override fun getSnippet(): String? {
            return null
        }
    }
}
