#import "TurboCrashModule.h"
#import <React/RCTAssert.h>

@implementation TurboCrashModule

RCT_EXPORT_MODULE();

- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:(const facebook::react::ObjCTurboModule::InitParams &)params {
  return std::make_shared<facebook::react::NativeTurboCrashModuleSpecJSI>(params);
}

- (NSString*)getDataCrash {
  @throw [NSException exceptionWithName:@"SomethingIsWrongException"
                                 reason:@"The operation failed."
                               userInfo:nil];
}

@end
