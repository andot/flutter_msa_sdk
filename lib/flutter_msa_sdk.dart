import 'dart:async';

import 'package:flutter/services.dart';

class FlutterMsaSdk {
  static const MethodChannel _channel =
      const MethodChannel('flutter_msa_sdk');

  static Future<String> getOAID() {
    return _channel.invokeMethod<String>('getOAID');
  }

  static Future<String> getVAID() {
    return _channel.invokeMethod<String>('getVAID');
  }

  static Future<String> getAAID() {
    return _channel.invokeMethod<String>('getAAID');
  }

  static Future<bool> isSupport() {
    return _channel.invokeMethod<bool>('isSupport');
  }
}
