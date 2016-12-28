
#import "RNAlerts.h"

@interface RCT_EXTERN_MODULE(RNAlerts, NSObject)

//RCT_EXTERN_METHOD(addEvent:(NSString *)name location:(NSString *)location date:(nonnull NSNumber *)date)

RCT_EXTERN_METHOD(alert:(NSString *)name, findEvents:(RCTResponseSenderBlock)callback )

@end
