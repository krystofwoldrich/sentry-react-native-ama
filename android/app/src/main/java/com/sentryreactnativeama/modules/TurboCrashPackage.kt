package com.sentryreactnativeama.modules

import com.facebook.react.TurboReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.model.ReactModuleInfo
import com.facebook.react.module.model.ReactModuleInfoProvider

class TurboCrashPackage : TurboReactPackage() {
    override fun getModule(
        name: String,
        reactApplicationContext: ReactApplicationContext
    ): NativeModule? {
        return if (name == TurboCrashModule.NAME) {
            TurboCrashModule(reactApplicationContext)
        } else {
            null
        }
    }

    override fun getReactModuleInfoProvider(): ReactModuleInfoProvider {
        return ReactModuleInfoProvider {
            val moduleInfos: MutableMap<String, ReactModuleInfo> =
                HashMap()
            moduleInfos[TurboCrashModule.NAME] = ReactModuleInfo(
                TurboCrashModule.NAME,
                TurboCrashModule.NAME,
                false,  // canOverrideExistingModule
                false,  // needsEagerInit
                true,  // hasConstants
                false,  // isCxxModule
                true // isTurboModule
            )
            moduleInfos
        }
    }
}