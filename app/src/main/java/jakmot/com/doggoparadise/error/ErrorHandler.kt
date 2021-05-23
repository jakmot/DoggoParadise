package jakmot.com.doggoparadise.error

import jakmot.com.doggoparadise.BuildConfig

class ErrorHandler {

    fun error(throwable: Throwable) {
        if (BuildConfig.DEBUG) {
            throwable.printStackTrace()
        }
    }
}