package com.sentryreactnativeamanightly.modules;

import com.facebook.fbreact.specs.NativeTurboCrashModuleSpec
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReadableMap;

class TurboCrashModule(reactContext: ReactApplicationContext) : NativeTurboCrashModuleSpec(reactContext) {

    override fun getName() = NAME
    override fun getDataCrash(query: ReadableMap?): String {
        crash()
        return "data"
    }

    fun crash() {
        throw RuntimeException("The operation failed.")
    }

    companion object {
        const val NAME = "TurboCrashModule"
    }
}
