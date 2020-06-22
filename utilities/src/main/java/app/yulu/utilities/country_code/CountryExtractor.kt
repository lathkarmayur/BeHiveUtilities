package app.yulu.utilities.country_code

import android.content.Context
import android.os.AsyncTask
import android.telephony.TelephonyManager
import android.util.Log
import androidx.lifecycle.MutableLiveData
import app.yulu.utilities.R
import app.yulu.utilities.background_task.AsyncT
import app.yulu.utilities.background_task.DoBackground
import app.yulu.utilities.single_live.SingleLiveEvent

/**
 *  Created by saurabhtripathi on 22/06/20
 */
open class CountryExtractor {

    companion object{
        fun instance() = CountryExtractor()
    }

    private val countryCodeDataModel: ArrayList<CountryCodeDataModel>
            = ArrayList()
    private val countryCodeDataModelLiveData : SingleLiveEvent<ArrayList<CountryCodeDataModel>>
            = SingleLiveEvent()
    private val filterCountryCodeDataModelLiveData : SingleLiveEvent<ArrayList<CountryCodeDataModel>>
            = SingleLiveEvent()

    private val currentAndAllCountryCodeDataModelLiveData : SingleLiveEvent<ArrayList<CountryCodeDataModel>>
            = SingleLiveEvent()

    private fun populateCountryData(){

        AsyncT(object : DoBackground{

            override fun onStart() {
                super.onStart()
                countryCodeDataModel.clear()
            }

            override fun onBackground() {
                super.onBackground()
                countryCodeDataModel.addAll(populateCountryDataRaw())
            }

            override fun onFinished() {
                super.onFinished()
                countryCodeDataModelLiveData.postValue(countryCodeDataModel)
            }

        }).execute()
    }

    private fun populateCountryDataFilter(filterList: ArrayList<String>){

        val filterCountryCodeData : ArrayList<CountryCodeDataModel> = ArrayList()

        AsyncT(object : DoBackground{


            override fun onBackground() {
                super.onBackground()

                val countryCodeListData = populateCountryDataRaw()

                filterList.forEach {filterList->
                   filterCountryCodeData.addAll(countryCodeListData.filter { it.codeName == filterList})
                }
            }

            override fun onFinished() {
                filterCountryCodeDataModelLiveData.postValue(filterCountryCodeData)
            }
        }).execute()
    }

    private fun populateCountryDataRaw(): ArrayList<CountryCodeDataModel>{

        val countryCodeDataModel: ArrayList<CountryCodeDataModel> = ArrayList()

        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ad",
                376,
                "Andorra",
                R.drawable.flag_andorra))

        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ae",
                971,
                "United Arab Emirates (UAE)",
                R.drawable.flag_uae
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "af",
                93,
                "Afghanistan",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ag",
                1,
                "Antigua and Barbuda",
                R.drawable.flag_antigua_and_barbuda
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("ai",
            1,
            "Anguilla",
            R.drawable.flag_anguilla))

        countryCodeDataModel.add(
            CountryCodeDataModel(
                "al",
                355,
                "Albania",
                R.drawable.flag_albania
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "am",
                374,
                "Armenia",
                R.drawable.flag_armenia
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ao",
                244,
                "Angola",
                R.drawable.flag_angola
            )
        )

        countryCodeDataModel.add(
            CountryCodeDataModel(
                "aq",
                672,
                "Antarctica",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ar",
                54,
                "Argentina",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "as",
                1,
                "American Samoa",
                R.drawable.flag_american_samoa
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "at",
                43,
                "Austria",
                R.drawable.flag_austria
            )
        )

        countryCodeDataModel.add(
            CountryCodeDataModel(
                "au",
                61,
                "Australia",
                R.drawable.flag_australia
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "aw",
                297,
                "Aruba",
                R.drawable.flag_aruba
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ax",
                358,
                "Åland Islands",
                R.drawable.flag_aland
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "az",
                994,
                "Azerbaijan",
                R.drawable.flag_azerbaijan
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ba",
                387,
                "Bosnia And Herzegovina",
                R.drawable.flag_bosnia
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "bb",
                1,
                "Barbados",
                R.drawable.flag_barbados
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "bd",
                880,
                "Bangladesh",
                R.drawable.flag_bangladesh
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "be",
                32,
                "Belgium",
                R.drawable.flag_belgium
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "bf",
                226,
                "Burkina Faso",
                R.drawable.flag_burkina_faso
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "bg",
                359,
                "Bulgaria",
                R.drawable.flag_bulgaria
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "bh",
                973,
                "Bahrain",
                R.drawable.flag_bahrain
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "bi",
                257,
                "Burundi",
                R.drawable.flag_burundi
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "bj",
                229,
                "Benin",
                R.drawable.flag_benin
            )
        )

        countryCodeDataModel.add(
            CountryCodeDataModel(
                "bl",
                590,
                "Saint Barthélemy",
                R.drawable.flag_saint_barthelemy
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "bm",
                1,
                "Bermuda",
                R.drawable.flag_bermuda
            )
        )

        countryCodeDataModel.add(
            CountryCodeDataModel(
                "bn",
                673,
                "Brunei Darussalam",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "bo",
                591,
                "Bolivia, Plurinational State Of",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "br",
                55,
                "Brazil",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "bs",
                1,
                "Bahamas",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "bt",
                975,
                "Bhutan",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "bw",
                267,
                "Botswana",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("by", 375, "Belarus", 1))
        countryCodeDataModel.add(CountryCodeDataModel("bz", 501, "Belize", 1))
        countryCodeDataModel.add(CountryCodeDataModel("ca", 1, "Canada", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "cc",
                61,
                "Cocos (keeling) Islands",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "cd",
                243,
                "Congo, The Democratic Republic Of The",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "cf",
                236,
                "Central African Republic",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("cg", 242, "Congo", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ch",
                41,
                "Switzerland",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ci",
                225,
                "Côte D'ivoire",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ck",
                682,
                "Cook Islands",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("cl", 56, "Chile", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "cm",
                237,
                "Cameroon",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("cn", 86, "China", 1))
        countryCodeDataModel.add(CountryCodeDataModel("co", 57, "Colombia", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "cr",
                506,
                "Costa Rica",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("cu", 53, "Cuba", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "cv",
                238,
                "Cape Verde",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("cw", 599, "Curaçao", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "cx",
                61,
                "Christmas Island",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("cy", 357, "Cyprus", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "cz",
                420,
                "Czech Republic",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("de", 49, "Germany", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "dj",
                253,
                "Djibouti",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("dk", 45, "Denmark", 1))
        countryCodeDataModel.add(CountryCodeDataModel("dm", 1, "Dominica", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "do",
                1,
                "Dominican Republic",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("dz", 213, "Algeria", 1))
        countryCodeDataModel.add(CountryCodeDataModel("ec", 593, "Ecuador", 1))
        countryCodeDataModel.add(CountryCodeDataModel("ee", 372, "Estonia", 1))
        countryCodeDataModel.add(CountryCodeDataModel("eg", 20, "Egypt", 1))
        countryCodeDataModel.add(CountryCodeDataModel("er", 291, "Eritrea", 1))
        countryCodeDataModel.add(CountryCodeDataModel("es", 34, "Spain", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "et",
                251,
                "Ethiopia",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("fi", 358, "Finland", 1))
        countryCodeDataModel.add(CountryCodeDataModel("fj", 679, "Fiji", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "fk",
                500,
                "Falkland Islands (malvinas)",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "fm",
                691,
                "Micronesia, Federated States Of",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "fo",
                298,
                "Faroe Islands",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("fr", 33, "France", 1))
        countryCodeDataModel.add(CountryCodeDataModel("ga", 241, "Gabon", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "gb",
                44,
                "United Kingdom",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("gd", 1, "Grenada", 1))
        countryCodeDataModel.add(CountryCodeDataModel("ge", 995, "Georgia", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "gf",
                594,
                "French Guyana",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("gh", 233, "Ghana", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "gi",
                350,
                "Gibraltar",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "gl",
                299,
                "Greenland",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("gm", 220, "Gambia", 1))
        countryCodeDataModel.add(CountryCodeDataModel("gn", 224, "Guinea", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "gp",
                450,
                "Guadeloupe",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "gq",
                240,
                "Equatorial Guinea",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("gr", 30, "Greece", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "gt",
                502,
                "Guatemala",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("gu", 1, "Guam", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "gw",
                245,
                "Guinea-bissau",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("gy", 592, "Guyana", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "hk",
                852,
                "Hong Kong",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "hn",
                504,
                "Honduras",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("hr", 385, "Croatia", 1))
        countryCodeDataModel.add(CountryCodeDataModel("ht", 509, "Haiti", 1))
        countryCodeDataModel.add(CountryCodeDataModel("hu", 36, "Hungary", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "id",
                62,
                "Indonesia",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("ie", 353, "Ireland", 1))
        countryCodeDataModel.add(CountryCodeDataModel("il", 972, "Israel", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "im",
                44,
                "Isle Of Man",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("is", 354, "Iceland", 1))
        countryCodeDataModel.add(CountryCodeDataModel("in", 91, "India", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "io",
                246,
                "British Indian Ocean Territory",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("iq", 964, "Iraq", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ir",
                98,
                "Iran, Islamic Republic Of",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("it", 39, "Italy", 1))
        countryCodeDataModel.add(CountryCodeDataModel("je", 44, "Jersey ", 1))
        countryCodeDataModel.add(CountryCodeDataModel("jm", 1, "Jamaica", 1))
        countryCodeDataModel.add(CountryCodeDataModel("jo", 962, "Jordan", 1))
        countryCodeDataModel.add(CountryCodeDataModel("jp", 81, "Japan", 1))
        countryCodeDataModel.add(CountryCodeDataModel("ke", 254, "Kenya", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "kg",
                996,
                "Kyrgyzstan",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "kh",
                855,
                "Cambodia",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ki",
                686,
                "Kiribati",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("km", 269, "Comoros", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "kn",
                1,
                "Saint Kitts and Nevis",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "kp",
                850,
                "North Korea",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "kr",
                82,
                "South Korea",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("kw", 965, "Kuwait", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ky",
                1,
                "Cayman Islands",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "kz",
                7,
                "Kazakhstan",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "la",
                856,
                "Lao People's Democratic Republic",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("lb", 961, "Lebanon", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "lc",
                1,
                "Saint Lucia",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "li",
                423,
                "Liechtenstein",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "lk",
                94,
                "Sri Lanka",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("lr", 231, "Liberia", 1))
        countryCodeDataModel.add(CountryCodeDataModel("ls", 266, "Lesotho", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "lt",
                370,
                "Lithuania",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "lu",
                352,
                "Luxembourg",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("lv", 371, "Latvia", 1))
        countryCodeDataModel.add(CountryCodeDataModel("ly", 218, "Libya", 1))
        countryCodeDataModel.add(CountryCodeDataModel("ma", 212, "Morocco", 1))
        countryCodeDataModel.add(CountryCodeDataModel("mc", 377, "Monaco", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "md",
                373,
                "Moldova, Republic Of",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "me",
                382,
                "Montenegro",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "mf",
                590,
                "Saint Martin",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "mg",
                261,
                "Madagascar",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "mh",
                692,
                "Marshall Islands",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "mk",
                389,
                "Macedonia (FYROM)",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("ml", 223, "Mali", 1))
        countryCodeDataModel.add(CountryCodeDataModel("mm", 95, "Myanmar", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "mn",
                976,
                "Mongolia",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("mo", 853, "Macau", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "mp",
                1,
                "Northern Mariana Islands",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "mq",
                596,
                "Martinique",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "mr",
                222,
                "Mauritania",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ms",
                1,
                "Montserrat",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("mt", 356, "Malta", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "mu",
                230,
                "Mauritius",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "mv",
                960,
                "Maldives",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("mw", 265, "Malawi", 1))
        countryCodeDataModel.add(CountryCodeDataModel("mx", 52, "Mexico", 1))
        countryCodeDataModel.add(CountryCodeDataModel("my", 60, "Malaysia", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "mz",
                258,
                "Mozambique",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("na", 264, "Namibia", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "nc",
                687,
                "New Caledonia",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("ne", 227, "Niger", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "nf",
                672,
                "Norfolk Islands",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("ng", 234, "Nigeria", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ni",
                505,
                "Nicaragua",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "nl",
                31,
                "Netherlands",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("no", 47, "Norway", 1))
        countryCodeDataModel.add(CountryCodeDataModel("np", 977, "Nepal", 1))
        countryCodeDataModel.add(CountryCodeDataModel("nr", 674, "Nauru", 1))
        countryCodeDataModel.add(CountryCodeDataModel("nu", 683, "Niue", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "nz",
                64,
                "New Zealand",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("om", 968, "Oman", 1))
        countryCodeDataModel.add(CountryCodeDataModel("pa", 507, "Panama", 1))
        countryCodeDataModel.add(CountryCodeDataModel("pe", 51, "Peru", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "pf",
                689,
                "French Polynesia",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "pg",
                675,
                "Papua New Guinea",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ph",
                63,
                "Philippines",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("pk", 92, "Pakistan", 1))
        countryCodeDataModel.add(CountryCodeDataModel("pl", 48, "Poland", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "pm",
                508,
                "Saint Pierre And Miquelon",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "pn",
                870,
                "Pitcairn Islands",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "pr",
                1,
                "Puerto Rico",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ps",
                970,
                "Palestine",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "pt",
                351,
                "Portugal",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("pw", 680, "Palau", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "py",
                595,
                "Paraguay",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("qa", 974, "Qatar", 1))
        countryCodeDataModel.add(CountryCodeDataModel("re", 262, "Réunion", 1))
        countryCodeDataModel.add(CountryCodeDataModel("ro", 40, "Romania", 1))
        countryCodeDataModel.add(CountryCodeDataModel("rs", 381, "Serbia", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ru",
                7,
                "Russian Federation",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("rw", 250, "Rwanda", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sa",
                966,
                "Saudi Arabia",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sb",
                677,
                "Solomon Islands",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sc",
                248,
                "Seychelles",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("sd", 249, "Sudan", 1))
        countryCodeDataModel.add(CountryCodeDataModel("se", 46, "Sweden", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sg",
                65,
                "Singapore",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sh",
                290,
                "Saint Helena, Ascension And Tristan Da Cunha",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "si",
                386,
                "Slovenia",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sk",
                421,
                "Slovakia",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sl",
                232,
                "Sierra Leone",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sm",
                378,
                "San Marino",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("sn", 221, "Senegal", 1))
        countryCodeDataModel.add(CountryCodeDataModel("so", 252, "Somalia", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sr",
                597,
                "Suriname",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ss",
                211,
                "South Sudan",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "st",
                239,
                "Sao Tome And Principe",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sv",
                503,
                "El Salvador",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sx",
                1,
                "Sint Maarten",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sy",
                963,
                "Syrian Arab Republic",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sz",
                268,
                "Swaziland",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "tc",
                1,
                "Turks and Caicos Islands",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("td", 235, "Chad", 1))
        countryCodeDataModel.add(CountryCodeDataModel("tg", 228, "Togo", 1))
        countryCodeDataModel.add(CountryCodeDataModel("th", 66, "Thailand", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "tj",
                992,
                "Tajikistan",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("tk", 690, "Tokelau", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "tl",
                670,
                "Timor-leste",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "tm",
                993,
                "Turkmenistan",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("tn", 216, "Tunisia", 1))
        countryCodeDataModel.add(CountryCodeDataModel("to", 676, "Tonga", 1))
        countryCodeDataModel.add(CountryCodeDataModel("tr", 90, "Turkey", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "tt",
                1,
                "Trinidad &amp; Tobago",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("tv", 688, "Tuvalu", 1))
        countryCodeDataModel.add(CountryCodeDataModel("tw", 886, "Taiwan", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "tz",
                255,
                "Tanzania, United Republic Of",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("ua", 380, "Ukraine", 1))
        countryCodeDataModel.add(CountryCodeDataModel("ug", 256, "Uganda", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "us",
                1,
                "United States",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("uy", 598, "Uruguay", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "uz",
                998,
                "Uzbekistan",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "va",
                379,
                "Holy See (vatican City State)",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "vc",
                1,
                "Saint Vincent &amp; The Grenadines",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ve",
                58,
                "Venezuela, Bolivarian Republic Of",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "vg",
                1,
                "British Virgin Islands",
                1
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "vi",
                1,
                "US Virgin Islands",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("vn", 84, "Vietnam", 1))
        countryCodeDataModel.add(CountryCodeDataModel("vu", 678, "Vanuatu", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "wf",
                681,
                "Wallis And Futuna",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("ws", 685, "Samoa", 1))
        countryCodeDataModel.add(CountryCodeDataModel("xk", 383, "Kosovo", 1))
        countryCodeDataModel.add(CountryCodeDataModel("ye", 967, "Yemen", 1))
        countryCodeDataModel.add(CountryCodeDataModel("yt", 262, "Mayotte", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "za",
                27,
                "South Africa",
                1
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("zm", 260, "Zambia", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "zw",
                263,
                "Zimbabwe",
                1
            )
        )

        return countryCodeDataModel
    }

    private fun populateCurrentAndAllCountryData(context: Context){

        val currentAndAllCountryCodeData : ArrayList<CountryCodeDataModel> = ArrayList()

        AsyncT(object : DoBackground{

            override fun onStart() {
                super.onStart()
                currentAndAllCountryCodeData.clear()
            }


            override fun onBackground() {
                super.onBackground()

                val tm =
                    context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
                val countryCodeValue = tm.networkCountryIso

                val data = populateCountryDataRaw()

                data.last { countryCodeDataModel -> countryCodeDataModel.codeName == countryCodeValue }.isSelected = true

                currentAndAllCountryCodeData.addAll(data)
            }

            override fun onFinished() {
                currentAndAllCountryCodeDataModelLiveData.postValue(currentAndAllCountryCodeData)
            }
        }).execute()
    }

    fun getCountryData(): SingleLiveEvent<ArrayList<CountryCodeDataModel>>
            = countryCodeDataModelLiveData.also {
        populateCountryData()
    }

    fun getFilterByCountryCode(filterList: ArrayList<String>): SingleLiveEvent<ArrayList<CountryCodeDataModel>>
            = filterCountryCodeDataModelLiveData.also {
        populateCountryDataFilter(filterList)
    }

    fun getCurrentAndAllCountryData(context: Context) : SingleLiveEvent<ArrayList<CountryCodeDataModel>>
    = currentAndAllCountryCodeDataModelLiveData.also {
        populateCurrentAndAllCountryData(context)
    }

}

