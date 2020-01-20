#import "FlutterMsaSdkPlugin.h"

@implementation FlutterMsaSdkPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
    FlutterMethodChannel* channel = [FlutterMethodChannel
        methodChannelWithName:@"flutter_msa_sdk"
        binaryMessenger:[registrar messenger]];
    FlutterMsaSdkPlugin* instance = [[FlutterMsaSdkPlugin alloc] init];
    [registrar addMethodCallDelegate:instance channel:channel];
}

- (void)handleMethodCall:(FlutterMethodCall*)call result:(FlutterResult)result {
    result(FlutterMethodNotImplemented);
}

@end
