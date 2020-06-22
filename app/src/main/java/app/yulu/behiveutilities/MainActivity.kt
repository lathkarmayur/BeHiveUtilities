package app.yulu.behiveutilities

import android.content.Context
import android.os.Bundle
import android.telephony.TelephonyManager
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import app.yulu.utilities.country_code.CountryExtractor


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        CountryExtractor.instance().getCountryData().observe(this, Observer {
            Log.i("APPDATA", it[5].countryName)
        })


        CountryExtractor.instance().getFilterByCountryCode(arrayListOf("in", "ad")).observe(this, Observer {
            Log.i("APPDATA", it[0].countryName)
            Log.i("APPDATA", it[1].countryName)
        })

        CountryExtractor.instance().getCurrentAndAllCountryData(this).observe(this, Observer {
            Log.i("APPDATA", it.last { it.isSelected }.countryName)
        })

    }
}
