package app.yulu.utilities.country_code

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes

/**
 *  Created by saurabhtripathi on 22/06/20
 */
data class CountryCodeDataModel(val codeName: String, val phoneCode: Int,  val countryName: String, val countryFlag: Int, var isSelected: Boolean = false){
    val phoneCodeWithPlus: String = "+$phoneCode"
}