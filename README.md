# flutter_msa_sdk

MSA SDK for Flutter.

### Usage

Add flutter_msa_sdk as a dependency in your pubspec.yaml file.

### API

```dart
    // Determine whether the device supports getting OAID，VAID and AAID
    bool isSupport = await FlutterMsaSdk.isSupport();
    // get OAID
    String oaid = await FlutterMsaSdk.getOAID();
    // get VAID
    String vaid = await FlutterMsaSdk.getVAID();
    // get AAID
    String aaid = await FlutterMsaSdk.getAAID();
```
