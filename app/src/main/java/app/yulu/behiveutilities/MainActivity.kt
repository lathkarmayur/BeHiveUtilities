package app.yulu.behiveutilities

import android.content.Context
import android.os.Bundle
import android.telephony.TelephonyManager
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import app.yulu.utilities.country_code.CountryExtractor
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       /* CountryExtractor.instance().getCountryData().observe(this, Observer {
            Log.i("APPDATA", it[5].countryName)
        })*/


        /*CountryExtractor.instance().getFilterByCountryCode(arrayListOf("in", "ad")).observe(this, Observer {
            Log.i("APPDATA", it[0].isSelected.toString())
            //Log.i("APPDATA", it[1].countryName)
        })*/


        val countryExtractor = CountryExtractor.instance()

        countryExtractor.filterCountryCodeDataModelLiveEvent.observe(this, Observer {
            it.forEach {
                Log.i("APPDATA", it.countryName)
            }
        })



        text.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                countryExtractor.setFilteredData(null, this@MainActivity, s.toString())
            }

        })

        countryExtractor.setFilteredData(null, this@MainActivity, "")



    }
}
