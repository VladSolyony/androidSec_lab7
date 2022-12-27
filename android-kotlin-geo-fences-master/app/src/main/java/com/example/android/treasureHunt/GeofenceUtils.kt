/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.treasureHunt

import android.content.Context
import com.google.android.gms.location.GeofenceStatusCodes
import com.google.android.gms.maps.model.LatLng
import com.google.gson.annotations.SerializedName
import java.util.concurrent.TimeUnit

/**
 * Returns the error string for a geofencing error code.
 */
fun errorMessage(context: Context, errorCode: Int): String {
    val resources = context.resources
    return when (errorCode) {
        GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE -> resources.getString(
            R.string.geofence_not_available
        )
        GeofenceStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES -> resources.getString(
            R.string.geofence_too_many_geofences
        )
        GeofenceStatusCodes.GEOFENCE_TOO_MANY_PENDING_INTENTS -> resources.getString(
            R.string.geofence_too_many_pending_intents
        )
        else -> resources.getString(R.string.unknown_geofence_error)
    }
}

/**
 * Stores latitude and longitude information along with a hint to help user find the location.
 */
data class LandmarkDataObject(val id: String, val hint: String, val name: String, @SerializedName("location")val latLong: LatLng)

internal object GeofencingConstants {


    /**
     * Used to set an expiration time for a geofence. After this amount of time, Location services
     * stops tracking the geofence. For this sample, geofences expire after one hour.
     */
    val GEOFENCE_EXPIRATION_IN_MILLISECONDS: Long = TimeUnit.HOURS.toMillis(1)
    val LANDMARK_DATA by lazy {
        GetData.readJson(HuntMainActivity._context)
    }
//    val LANDMARK_DATA = arrayOf(

        // A
//        LandmarkDataObject(
//            "enter",
//            R.string.golden_gate_bridge_hint,
//            R.string.golden_gate_bridge_location,
//            LatLng(47.216916060575144, 39.628686010837555)),

        // C
//        LandmarkDataObject(
//            "corner",
//            R.string.ferry_building_hint,
//            R.string.ferry_building_location,
//            LatLng(47.21708, 39.62862)),

        // E
//        LandmarkDataObject(
//            "parking",
//            R.string.pier_39_hint,
//            R.string.pier_39_location,
//            LatLng(47.21678, 39.62797)),

        // I
//        LandmarkDataObject(
//            "bicycle",
//            R.string.union_square_hint,
//            R.string.union_square_location,
//            LatLng(47.21625, 39.62922)),

        // J
//        LandmarkDataObject(
//            "smoking",
//            R.string.union_square_hint_2,
//            R.string.union_square_location_2,
//            LatLng(47.21627, 39.62952)),





//    )

    val NUM_LANDMARKS = LANDMARK_DATA.size
    const val GEOFENCE_RADIUS_IN_METERS = 20f
    const val EXTRA_GEOFENCE_INDEX = "GEOFENCE_INDEX"
}
