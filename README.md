# flutter_msa_sdk

OAID SDK for Flutter.

### Usage

Add flutter_msa_sdk as a dependency in your pubspec.yaml file.

### API

```dart
    // Determine whether the device supports getting OAID
    bool isSupport = await FlutterMsaSdk.isSupport();
    // get OAID
    String oaid = await FlutterMsaSdk.getOAID();
```
