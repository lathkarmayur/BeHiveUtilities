package app.yulu.utilities.background_task

import android.os.AsyncTask

/**
 *  Created by saurabhtripathi on 22/06/20
 */
class AsyncT(private val doBackground: DoBackground) : AsyncTask<Void, Void, Void>() {
    override fun doInBackground(vararg params: Void?): Void?{
        doBackground.onBackground()
        return null
    }

    override fun onPreExecute() {
        super.onPreExecute()
        doBackground.onStart()

    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)
        doBackground.onFinished()

    }
}
interface DoBackground{
    fun onStart(){}
    fun onBackground(){}
    fun onFinished(){}
}