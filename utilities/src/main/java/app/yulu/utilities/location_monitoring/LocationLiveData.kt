package app.yulu.utilities.location_monitoring

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.IntentSender
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*

/**
 *  Created by saurabhtripathi on 22/06/20
 */


/**
 * Default Values
 */
var INTERVAL = 1000L
var FASTEST_INTERVAL = 500L
var CHECK_OTHER_LOCATION_UPDATE = 5000L
private const val MIN_DISTANCE_CHANGE_FOR_UPDATES = 10L

open class LocationLiveData (private val context: Context) : MutableLiveData<Location>() {

    private var lastLocation: Location? = null
    private var handler : Handler = Handler()
    private var runnable : Runnable? = null

    private var locationManager: LocationManager? = null


    private var fusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)


    /**
     * Sets the value. If there are active observers, the value will be dispatched to them.
     *
     * This method must be called from the main thread. If you need set a value from a background
     * thread, you can use postValue(Object)
     *
     */
    private fun setLocationData(location: Location) {
        value = location
        //postValue(location)
    }



    /**
     * Static object of location request
     */
    companion object {

        const val REQUEST_CHECK_SETTINGS = 2001

        val locationRequest: LocationRequest = LocationRequest.create()
            .apply {
                interval = INTERVAL
                fastestInterval =
                    FASTEST_INTERVAL
                priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            }

    }

    init {

        locationManager = context
            .getSystemService(Context.LOCATION_SERVICE) as LocationManager

        runnableForOtherLocation()

    }
    /**
     * Default time is 1000L
     */

    fun setLocationInterval(interval: Long, fastestInterval: Long) : LocationLiveData {

        if(fastestInterval <=  interval){
            INTERVAL = interval
            FASTEST_INTERVAL = fastestInterval
        }

        return this
    }

    fun setOtherLocationDetails(interval: Long): LocationLiveData {
        CHECK_OTHER_LOCATION_UPDATE = interval

        return this
    }



    fun enablingGps(): LocationLiveData {

        val builder = LocationSettingsRequest.Builder()
            .addLocationRequest(locationRequest)

        // **************************

        // **************************
        builder.setAlwaysShow(true) // this is the key ingredient

        // **************************

        val settingsClient = LocationServices.getSettingsClient(context)
        val task = settingsClient.checkLocationSettings(builder.build())



        task.addOnSuccessListener(context as AppCompatActivity) {
            startLocationUpdates()
        }
        task.addOnFailureListener(context) { e: java.lang.Exception? ->
            if (e is ResolvableApiException) {
                try {
                    e.startResolutionForResult(context,
                        REQUEST_CHECK_SETTINGS
                    )
                } catch (sendEx: IntentSender.SendIntentException) {
                    // Ignore the error.
                }
            }
        }

        return this
    }




    /**
     * Called when the number of active observers change to 1 from 0.
     * This callback can be used to know that this LiveData is being used thus should be kept
     * up to date.
     */
    override fun onInactive() {
        super.onInactive()
        fusedLocationProviderClient.removeLocationUpdates(locationCallback)

        runnable?.let { handler.removeCallbacks(it) }

    }


    /**
     * Called when the number of active observers change from 1 to 0.
     *
     * This does not mean that there are no observers left, there may still be observers but their
     * lifecycle states aren't STARTED or RESUMED
     * (like an Activity in the back stack).
     *
     * You can check if there are observers via hasObservers() method
     */
    override fun onActive() {
        super.onActive()
        fusedLocationProviderClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                location?.let {
                    lastLocation = it
                    setLocationData(it)
                }
            }
            .addOnFailureListener {

            }



        startLocationUpdates()

        handlerForOtherLocation()

    }

    /**
     * Callback that triggers on location updates available
     */
    private val locationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult?) {
            locationResult ?: return
            for (location in locationResult.locations) {
                // TODO: REMOVE ALL COMMENT HE
                setLocationData(location)
                runnable?.let { handler.removeCallbacks(it) }
            }
        }
    }

    /**
     * Initiate Location Updates using Fused Location Provider and
     * attaching callback to listen location updates
     */
    private fun startLocationUpdates() {
        fusedLocationProviderClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            null
        )
    }

    private fun runnableForOtherLocation(){
        runnable = Runnable {
            lastLocation?.let {
                setLocationData(it)
            }?: kotlin.run {
                gpsAndNetworkLocationUpdate()
            }
        }
    }

    private fun handlerForOtherLocation(){
        runnable?.let {
            handler.postDelayed(it,
                CHECK_OTHER_LOCATION_UPDATE
            )
        }
    }
    @SuppressLint("MissingPermission")
    private fun gpsAndNetworkLocationUpdate(){

        // First get location from Network Provider
        // First get location from Network Provider


        locationManager?.let {

            if(isLocationPermissionGranted()){
                var location =
                    it.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                location?.let {locationData->
                    setLocationData(locationData)
                }?: kotlin.run {
                    location = it.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                    location?.let { locationData->
                        setLocationData(locationData)
                    }
                }
            }
        }
    }

    private fun isLocationPermissionGranted(): Boolean{
        return (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED)
    }

}