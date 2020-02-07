import 'dart:async';

import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

class FlutterMsaSdk {
  static const MethodChannel _channel = const MethodChannel('flutter_msa_sdk');

  static Future<String> getOAID() {
    if (defaultTargetPlatform == TargetPlatform.android) {
      return _channel.invokeMethod<String>('getOAID');
    }
    return Future.value('');
  }

  static Future<String> getVAID() {
    if (defaultTargetPlatform == TargetPlatform.android) {
      return _channel.invokeMethod<String>('getVAID');
    }
    return Future.value('');
  }

  static Future<String> getAAID() {
    if (defaultTargetPlatform == TargetPlatform.android) {
      return _channel.invokeMethod<String>('getAAID');
    }
    return Future.value('');
  }

  static Future<bool> isSupport() {
    if (defaultTargetPlatform == TargetPlatform.android) {
      return _channel.invokeMethod<bool>('isSupport');
    }
    return Future.value(false);
  }
}
