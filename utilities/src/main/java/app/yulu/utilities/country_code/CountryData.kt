package app.yulu.utilities.country_code

import android.content.Context
import android.telephony.TelephonyManager
import android.util.Log
import app.yulu.utilities.R
import app.yulu.utilities.background_task.AsyncT
import app.yulu.utilities.background_task.DoBackground
import app.yulu.utilities.single_live.SingleLiveEvent

/**
 *  Created by saurabhtripathi on 23/06/20
 */
object CountryData {

    private val countryCodeDataModel: ArrayList<CountryCodeDataModel>
            = ArrayList()
    private val countryCodeDataModelLiveData : SingleLiveEvent<ArrayList<CountryCodeDataModel>>
            = SingleLiveEvent()
    private val filterCountryCodeDataModelLiveData : SingleLiveEvent<ArrayList<CountryCodeDataModel>>
            = SingleLiveEvent()

    private val currentAndAllCountryCodeDataModelLiveData : SingleLiveEvent<ArrayList<CountryCodeDataModel>>
            = SingleLiveEvent()

    private val currentCountryCodeDataModelLiveData: SingleLiveEvent<CountryCodeDataModel>
            = SingleLiveEvent()

    private fun populateCountryData(){

        AsyncT(object : DoBackground {

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

    private fun populateCountryDataFilter(context: Context, filterList: ArrayList<String>){

        val filterCountryCodeData : ArrayList<CountryCodeDataModel> = ArrayList()

        AsyncT(object : DoBackground {


            override fun onStart() {
                super.onStart()
                filterCountryCodeData.clear()
            }

            override fun onBackground() {
                super.onBackground()

                val countryCodeListData = populateCountryDataRaw()


                filterList.forEach {filterList->
                    filterCountryCodeData.addAll(countryCodeListData.filter { it.codeName == filterList})
                }

                val tm =
                    context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
                val countryCodeValue = tm.networkCountryIso



                val indexSearchedElement = filterCountryCodeData.indexOfFirst { countryCodeDataModel -> countryCodeDataModel.codeName == countryCodeValue }

                val toSearch = filterCountryCodeData[indexSearchedElement].also { it.isSelected = true }

                Log.i("APPDATA", toSearch.isSelected.toString())

                filterCountryCodeData.removeAt(indexSearchedElement)

                filterCountryCodeData.add(0, toSearch)


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
                R.drawable.flag_brunei
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "bo",
                591,
                "Bolivia, Plurinational State Of",
                R.drawable.flag_bolivia
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "br",
                55,
                "Brazil",
                R.drawable.flag_brazil
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "bs",
                1,
                "Bahamas",
                R.drawable.flag_bahamas
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "bt",
                975,
                "Bhutan",
                R.drawable.flag_bhutan
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "bw",
                267,
                "Botswana",
                R.drawable.flag_botswana
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("by", 375, "Belarus", R.drawable.flag_belarus))
        countryCodeDataModel.add(CountryCodeDataModel("bz", 501, "Belize", R.drawable.flag_belize))
        countryCodeDataModel.add(CountryCodeDataModel("ca", 1, "Canada", R.drawable.flag_canada))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "cc",
                61,
                "Cocos (keeling) Islands",
                R.drawable.flag_cocos
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "cd",
                243,
                "Congo, The Democratic Republic Of The",
                R.drawable.flag_democratic_republic_of_the_congo
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "cf",
                236,
                "Central African Republic",
                R.drawable.flag_central_african_republic
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("cg", 242, "Congo", R.drawable.flag_republic_of_the_congo))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ch",
                41,
                "Switzerland",
                R.drawable.flag_swaziland
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ci",
                225,
                "Côte D'ivoire",
                R.drawable.flag_cote_divoire
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ck",
                682,
                "Cook Islands",
                R.drawable.flag_cook_islands
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("cl", 56, "Chile", R.drawable.flag_chile))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "cm",
                237,
                "Cameroon",
                R.drawable.flag_cameroon
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("cn", 86, "China", R.drawable.flag_china))
        countryCodeDataModel.add(CountryCodeDataModel("co", 57, "Colombia", R.drawable.flag_colombia))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "cr",
                506,
                "Costa Rica",
                R.drawable.flag_costa_rica
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("cu", 53, "Cuba", R.drawable.flag_cuba))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "cv",
                238,
                "Cape Verde",
                R.drawable.flag_cape_verde
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("cw", 599, "Curaçao", R.drawable.flag_curacao))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "cx",
                61,
                "Christmas Island",
                R.drawable.flag_christmas_island
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("cy", 357, "Cyprus", R.drawable.flag_cyprus))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "cz",
                420,
                "Czech Republic",
                R.drawable.flag_czech_republic
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("de", 49, "Germany", R.drawable.flag_germany))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "dj",
                253,
                "Djibouti",
                R.drawable.flag_djibouti
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("dk", 45, "Denmark", R.drawable.flag_denmark))
        countryCodeDataModel.add(CountryCodeDataModel("dm", 1, "Dominica", R.drawable.flag_dominica))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "do",
                1,
                "Dominican Republic",
                R.drawable.flag_dominican_republic
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("dz", 213, "Algeria", R.drawable.flag_algeria))
        countryCodeDataModel.add(CountryCodeDataModel("ec", 593, "Ecuador", R.drawable.flag_ecuador))
        countryCodeDataModel.add(CountryCodeDataModel("ee", 372, "Estonia", R.drawable.flag_estonia))
        countryCodeDataModel.add(CountryCodeDataModel("eg", 20, "Egypt", R.drawable.flag_egypt))
        countryCodeDataModel.add(CountryCodeDataModel("er", 291, "Eritrea", R.drawable.flag_eritrea))
        countryCodeDataModel.add(CountryCodeDataModel("es", 34, "Spain", R.drawable.flag_spain))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "et",
                251,
                "Ethiopia",
                R.drawable.flag_ethiopia
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("fi", 358, "Finland", R.drawable.flag_finland))
        countryCodeDataModel.add(CountryCodeDataModel("fj", 679, "Fiji", R.drawable.flag_fiji))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "fk",
                500,
                "Falkland Islands (malvinas)",
                R.drawable.flag_falkland_islands
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "fm",
                691,
                "Micronesia, Federated States Of",
                R.drawable.flag_micronesia
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "fo",
                298,
                "Faroe Islands",
                R.drawable.flag_faroe_islands
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("fr", 33, "France", R.drawable.flag_france))
        countryCodeDataModel.add(CountryCodeDataModel("ga", 241, "Gabon", R.drawable.flag_gabon))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "gb",
                44,
                "United Kingdom",
                R.drawable.flag_united_kingdom
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("gd", 1, "Grenada", R.drawable.flag_grenada))
        countryCodeDataModel.add(CountryCodeDataModel("ge", 995, "Georgia", R.drawable.flag_georgia))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "gf",
                594,
                "French Guyana",
                R.drawable.flag_guyana
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("gh", 233, "Ghana", R.drawable.flag_ghana))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "gi",
                350,
                "Gibraltar",
                R.drawable.flag_gibraltar
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "gl",
                299,
                "Greenland",
                R.drawable.flag_greenland
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("gm", 220, "Gambia", R.drawable.flag_gambia))
        countryCodeDataModel.add(CountryCodeDataModel("gn", 224, "Guinea", R.drawable.flag_guinea))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "gp",
                450,
                "Guadeloupe",
                R.drawable.flag_guadeloupe
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "gq",
                240,
                "Equatorial Guinea",
                R.drawable.flag_equatorial_guinea
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("gr", 30, "Greece", R.drawable.flag_greece))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "gt",
                502,
                "Guatemala",
                R.drawable.flag_guatemala
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("gu", 1, "Guam", R.drawable.flag_guam))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "gw",
                245,
                "Guinea-bissau",
                R.drawable.flag_guinea_bissau
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("gy", 592, "Guyana", R.drawable.flag_guyana))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "hk",
                852,
                "Hong Kong",
                R.drawable.flag_hong_kong
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "hn",
                504,
                "Honduras",
                R.drawable.flag_honduras
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("hr", 385, "Croatia", R.drawable.flag_croatia))
        countryCodeDataModel.add(CountryCodeDataModel("ht", 509, "Haiti", R.drawable.flag_haiti))
        countryCodeDataModel.add(CountryCodeDataModel("hu", 36, "Hungary", R.drawable.flag_hungary))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "id",
                62,
                "Indonesia",
                R.drawable.flag_indonesia
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("ie", 353, "Ireland", R.drawable.flag_ireland))
        countryCodeDataModel.add(CountryCodeDataModel("il", 972, "Israel", R.drawable.flag_israel))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "im",
                44,
                "Isle Of Man",
                R.drawable.flag_isleof_man
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("is", 354, "Iceland", R.drawable.flag_iceland))
        countryCodeDataModel.add(CountryCodeDataModel("in", 91, "India", R.drawable.flag_india))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "io",
                246,
                "British Indian Ocean Territory",
                R.drawable.flag_british_indian_ocean_territory
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("iq", 964, "Iraq", R.drawable.flag_iraq))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ir",
                98,
                "Iran, Islamic Republic Of",
                R.drawable.flag_iran
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("it", 39, "Italy", R.drawable.flag_italy))
        countryCodeDataModel.add(CountryCodeDataModel("je", 44, "Jersey ", R.drawable.flag_jersey))
        countryCodeDataModel.add(CountryCodeDataModel("jm", 1, "Jamaica", R.drawable.flag_jamaica))
        countryCodeDataModel.add(CountryCodeDataModel("jo", 962, "Jordan", R.drawable.flag_jordan))
        countryCodeDataModel.add(CountryCodeDataModel("jp", 81, "Japan", R.drawable.flag_japan))
        countryCodeDataModel.add(CountryCodeDataModel("ke", 254, "Kenya", R.drawable.flag_kenya))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "kg",
                996,
                "Kyrgyzstan",
                R.drawable.flag_kyrgyzstan
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "kh",
                855,
                "Cambodia",
                R.drawable.flag_cambodia
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ki",
                686,
                "Kiribati",
                R.drawable.flag_kiribati
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("km", 269, "Comoros", R.drawable.flag_comoros))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "kn",
                1,
                "Saint Kitts and Nevis",
                R.drawable.flag_saint_kitts_and_nevis
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "kp",
                850,
                "North Korea",
                R.drawable.flag_north_korea
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "kr",
                82,
                "South Korea",
                R.drawable.flag_south_korea
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("kw", 965, "Kuwait", R.drawable.flag_kuwait))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ky",
                1,
                "Cayman Islands",
                R.drawable.flag_cayman_islands
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "kz",
                7,
                "Kazakhstan",
                R.drawable.flag_kazakhstan
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "la",
                856,
                "Lao People's Democratic Republic",
                R.drawable.flag_laos
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("lb", 961, "Lebanon", R.drawable.flag_lebanon))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "lc",
                1,
                "Saint Lucia",
                R.drawable.flag_saint_lucia
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "li",
                423,
                "Liechtenstein",
                R.drawable.flag_liechtenstein
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "lk",
                94,
                "Sri Lanka",
                R.drawable.flag_sri_lanka
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("lr", 231, "Liberia", R.drawable.flag_liberia))
        countryCodeDataModel.add(CountryCodeDataModel("ls", 266, "Lesotho", R.drawable.flag_lesotho))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "lt",
                370,
                "Lithuania",
                R.drawable.flag_lithuania
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "lu",
                352,
                "Luxembourg",
                R.drawable.flag_luxembourg
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("lv", 371, "Latvia", R.drawable.flag_latvia))
        countryCodeDataModel.add(CountryCodeDataModel("ly", 218, "Libya", R.drawable.flag_libya))
        countryCodeDataModel.add(CountryCodeDataModel("ma", 212, "Morocco", R.drawable.flag_morocco))
        countryCodeDataModel.add(CountryCodeDataModel("mc", 377, "Monaco", R.drawable.flag_monaco))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "md",
                373,
                "Moldova, Republic Of",
                R.drawable.flag_moldova
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "me",
                382,
                "Montenegro",
                R.drawable.flag_of_montenegro
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "mf",
                590,
                "Saint Martin",
                R.drawable.flag_saint_martin
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "mg",
                261,
                "Madagascar",
                R.drawable.flag_madagascar
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "mh",
                692,
                "Marshall Islands",
                R.drawable.flag_marshall_islands
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "mk",
                389,
                "Macedonia (FYROM)",
                R.drawable.flag_macedonia
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("ml", 223, "Mali", R.drawable.flag_mali))
        countryCodeDataModel.add(CountryCodeDataModel("mm", 95, "Myanmar", R.drawable.flag_myanmar))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "mn",
                976,
                "Mongolia",
                R.drawable.flag_mongolia
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("mo", 853, "Macau", R.drawable.flag_macao))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "mp",
                1,
                "Northern Mariana Islands",
                R.drawable.flag_northern_mariana_islands
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "mq",
                596,
                "Martinique",
                R.drawable.flag_martinique
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "mr",
                222,
                "Mauritania",
                R.drawable.flag_mauritania
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ms",
                1,
                "Montserrat",
                R.drawable.flag_montserrat
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("mt", 356, "Malta", R.drawable.flag_malta))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "mu",
                230,
                "Mauritius",
                R.drawable.flag_mauritius
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "mv",
                960,
                "Maldives",
                R.drawable.flag_maldives
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("mw", 265, "Malawi", R.drawable.flag_malawi))
        countryCodeDataModel.add(CountryCodeDataModel("mx", 52, "Mexico", R.drawable.flag_mexico))
        countryCodeDataModel.add(CountryCodeDataModel("my", 60, "Malaysia", R.drawable.flag_malaysia))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "mz",
                258,
                "Mozambique",
                R.drawable.flag_mozambique
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("na", 264, "Namibia", 1))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "nc",
                687,
                "New Caledonia",
                R.drawable.flag_new_caledonia
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("ne", 227, "Niger", R.drawable.flag_niger))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "nf",
                672,
                "Norfolk Islands",
                R.drawable.flag_norfolk_island
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("ng", 234, "Nigeria", R.drawable.flag_nigeria))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ni",
                505,
                "Nicaragua",
                R.drawable.flag_nicaragua
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "nl",
                31,
                "Netherlands",
                R.drawable.flag_netherlands
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("no", 47, "Norway", R.drawable.flag_norway))
        countryCodeDataModel.add(CountryCodeDataModel("np", 977, "Nepal", R.drawable.flag_nepal))
        countryCodeDataModel.add(CountryCodeDataModel("nr", 674, "Nauru", R.drawable.flag_nauru))
        countryCodeDataModel.add(CountryCodeDataModel("nu", 683, "Niue", R.drawable.flag_niue))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "nz",
                64,
                "New Zealand",
                R.drawable.flag_new_zealand
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("om", 968, "Oman", R.drawable.flag_oman))
        countryCodeDataModel.add(CountryCodeDataModel("pa", 507, "Panama", R.drawable.flag_panama))
        countryCodeDataModel.add(CountryCodeDataModel("pe", 51, "Peru", R.drawable.flag_peru))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "pf",
                689,
                "French Polynesia",
                R.drawable.flag_french_polynesia
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "pg",
                675,
                "Papua New Guinea",
                R.drawable.flag_papua_new_guinea
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ph",
                63,
                "Philippines",
                R.drawable.flag_philippines
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("pk", 92, "Pakistan", R.drawable.flag_pakistan))
        countryCodeDataModel.add(CountryCodeDataModel("pl", 48, "Poland", R.drawable.flag_poland))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "pm",
                508,
                "Saint Pierre And Miquelon",
                R.drawable.flag_saint_pierre
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "pn",
                870,
                "Pitcairn Islands",
                R.drawable.flag_pitcairn_islands
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "pr",
                1,
                "Puerto Rico",
                R.drawable.flag_puerto_rico
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ps",
                970,
                "Palestine",
                R.drawable.flag_palestine
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "pt",
                351,
                "Portugal",
                R.drawable.flag_portugal
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("pw", 680, "Palau", R.drawable.flag_palau))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "py",
                595,
                "Paraguay",
                R.drawable.flag_paraguay
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("qa", 974, "Qatar", R.drawable.flag_qatar))
        countryCodeDataModel.add(CountryCodeDataModel("re", 262, "Réunion", R.drawable.flag_martinique)) //  no exact flag found
        countryCodeDataModel.add(CountryCodeDataModel("ro", 40, "Romania", R.drawable.flag_romania))
        countryCodeDataModel.add(CountryCodeDataModel("rs", 381, "Serbia", R.drawable.flag_serbia ))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ru",
                7,
                "Russian Federation",
                R.drawable.flag_russian_federation
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("rw", 250, "Rwanda", R.drawable.flag_rwanda))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sa",
                966,
                "Saudi Arabia",
                R.drawable.flag_saudi_arabia
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sb",
                677,
                "Solomon Islands",
                R.drawable.flag_soloman_islands
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sc",
                248,
                "Seychelles",
                R.drawable.flag_seychelles
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("sd", 249, "Sudan", R.drawable.flag_sudan))
        countryCodeDataModel.add(CountryCodeDataModel("se", 46, "Sweden", R.drawable.flag_sweden))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sg",
                65,
                "Singapore",
                R.drawable.flag_singapore
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sh",
                290,
                "Saint Helena, Ascension And Tristan Da Cunha",
                R.drawable.flag_saint_helena
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "si",
                386,
                "Slovenia",
                R.drawable.flag_slovenia
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sk",
                421,
                "Slovakia",
                R.drawable.flag_slovakia
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sl",
                232,
                "Sierra Leone",
                R.drawable.flag_sierra_leone
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sm",
                378,
                "San Marino",
                R.drawable.flag_san_marino
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("sn", 221, "Senegal", R.drawable.flag_senegal))
        countryCodeDataModel.add(CountryCodeDataModel("so", 252, "Somalia", R.drawable.flag_somalia))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sr",
                597,
                "Suriname",
                R.drawable.flag_suriname
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ss",
                211,
                "South Sudan",
                R.drawable.flag_south_sudan
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "st",
                239,
                "Sao Tome And Principe",
                R.drawable.flag_sao_tome_and_principe
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sv",
                503,
                "El Salvador",
                R.drawable.flag_el_salvador
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sx",
                1,
                "Sint Maarten",
                R.drawable.flag_sint_maarten
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sy",
                963,
                "Syrian Arab Republic",
                R.drawable.flag_syria
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "sz",
                268,
                "Swaziland",
                R.drawable.flag_swaziland
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "tc",
                1,
                "Turks and Caicos Islands",
                R.drawable.flag_turks_and_caicos_islands
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("td", 235, "Chad", R.drawable.flag_chad))
        countryCodeDataModel.add(CountryCodeDataModel("tg", 228, "Togo", R.drawable.flag_togo))
        countryCodeDataModel.add(CountryCodeDataModel("th", 66, "Thailand", R.drawable.flag_thailand))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "tj",
                992,
                "Tajikistan",
                R.drawable.flag_tajikistan
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("tk", 690, "Tokelau", R.drawable.flag_tokelau))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "tl",
                670,
                "Timor-leste",
                R.drawable.flag_timor_leste
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "tm",
                993,
                "Turkmenistan",
                R.drawable.flag_turkmenistan
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("tn", 216, "Tunisia", R.drawable.flag_tunisia))
        countryCodeDataModel.add(CountryCodeDataModel("to", 676, "Tonga", R.drawable.flag_tonga))
        countryCodeDataModel.add(CountryCodeDataModel("tr", 90, "Turkey", R.drawable.flag_turkey))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "tt",
                1,
                "Trinidad &amp; Tobago",
                R.drawable.flag_trinidad_and_tobago
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("tv", 688, "Tuvalu", R.drawable.flag_tuvalu))
        countryCodeDataModel.add(CountryCodeDataModel("tw", 886, "Taiwan", R.drawable.flag_taiwan))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "tz",
                255,
                "Tanzania, United Republic Of",
                R.drawable.flag_tanzania
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("ua", 380, "Ukraine", R.drawable.flag_ukraine))
        countryCodeDataModel.add(CountryCodeDataModel("ug", 256, "Uganda", R.drawable.flag_uganda))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "us",
                1,
                "United States",
                R.drawable.flag_united_kingdom
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("uy", 598, "Uruguay", R.drawable.flag_uruguay))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "uz",
                998,
                "Uzbekistan",
                R.drawable.flag_uzbekistan
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "va",
                379,
                "Holy See (vatican City State)",
                R.drawable.flag_vatican_city
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "vc",
                1,
                "Saint Vincent &amp; The Grenadines",
                R.drawable.flag_saint_vicent_and_the_grenadines
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "ve",
                58,
                "Venezuela, Bolivarian Republic Of",
                R.drawable.flag_venezuela
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "vg",
                1,
                "British Virgin Islands",
                R.drawable.flag_british_virgin_islands
            )
        )
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "vi",
                1,
                "US Virgin Islands",
                R.drawable.flag_us_virgin_islands
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("vn", 84, "Vietnam", R.drawable.flag_vietnam))
        countryCodeDataModel.add(CountryCodeDataModel("vu", 678, "Vanuatu", R.drawable.flag_vanuatu))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "wf",
                681,
                "Wallis And Futuna",
                R.drawable.flag_wallis_and_futuna
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("ws", 685, "Samoa", R.drawable.flag_samoa))
        countryCodeDataModel.add(CountryCodeDataModel("xk", 383, "Kosovo", R.drawable.flag_kosovo))
        countryCodeDataModel.add(CountryCodeDataModel("ye", 967, "Yemen", R.drawable.flag_yemen))
        countryCodeDataModel.add(CountryCodeDataModel("yt", 262, "Mayotte", R.drawable.flag_martinique)) // no exact flag found
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "za",
                27,
                "South Africa",
                R.drawable.flag_south_africa
            )
        )
        countryCodeDataModel.add(CountryCodeDataModel("zm", 260, "Zambia", R.drawable.flag_zambia))
        countryCodeDataModel.add(
            CountryCodeDataModel(
                "zw",
                263,
                "Zimbabwe",
                R.drawable.flag_zimbabwe
            )
        )

        return countryCodeDataModel
    }

    private fun populateCurrentAndAllCountryData(context: Context){

        val currentAndAllCountryCodeData : ArrayList<CountryCodeDataModel> = ArrayList()

        AsyncT(object : DoBackground {

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

                currentAndAllCountryCodeData.addAll(data)

                val indexSearchedElement = currentAndAllCountryCodeData.indexOfFirst { countryCodeDataModel -> countryCodeDataModel.codeName == countryCodeValue }

                val toSearch = currentAndAllCountryCodeData[indexSearchedElement].also { it.isSelected = true }

                currentAndAllCountryCodeData.removeAt(indexSearchedElement)

                currentAndAllCountryCodeData.add(0, toSearch)


            }

            override fun onFinished() {
                currentAndAllCountryCodeDataModelLiveData.postValue(currentAndAllCountryCodeData)
            }
        }).execute()
    }

    private fun populateCurrentCountryData(context: Context){

        var currentCountryCodeData : CountryCodeDataModel? = null

        AsyncT(object : DoBackground {

            override fun onBackground() {
                super.onBackground()

                val tm =
                    context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
                val countryCodeValue = tm.networkCountryIso

                val data = populateCountryDataRaw()



                currentCountryCodeData = data.last { countryCodeDataModel -> countryCodeDataModel.codeName == countryCodeValue }
            }

            override fun onFinished() {
                currentCountryCodeDataModelLiveData.postValue(currentCountryCodeData)
            }
        }).execute()
    }
}