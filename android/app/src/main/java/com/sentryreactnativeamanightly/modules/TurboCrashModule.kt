package com.sentryreactnativeamanightly.modules;

import com.facebook.fbreact.specs.NativeTurboCrashModuleSpec
import com.facebook.react.bridge.ReactApplicationContext

class TurboCrashModule(reactContext: ReactApplicationContext) : NativeTurboCrashModuleSpec(reactContext) {

    override fun getName() = NAME
    override fun getDataCrash(): String {
        throw RuntimeException("The operation failed.")
    }

    companion object {
        const val NAME = "TurboCrashModule"
    }
}
