package com.adtalos.flutter.msa.sdk;

import android.content.Context;
import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/**
 * FlutterMsaSdkPlugin
 */
public class FlutterMsaSdkPlugin implements FlutterPlugin, MethodCallHandler {
    private final static FlutterMsaSdkPlugin plugin = new FlutterMsaSdkPlugin();
    private final static MsaHelper helper = new MsaHelper();
    private MethodChannel channel;

    /**
     * Registers a plugin with the v1 embedding api {@code io.flutter.plugin.common}.
     *
     * <p>Calling this will register the plugin with the passed registrar. However, plugins
     * initialized this way won't react to changes in activity or context.
     *
     * @param registrar connects this plugin's {@link
     *                  io.flutter.plugin.common.MethodChannel.MethodCallHandler} to its {@link
     *                  io.flutter.plugin.common.BinaryMessenger}.
     */
    public static void registerWith(Registrar registrar) {
        plugin.initializePlugin(registrar.context(), registrar.messenger());
    }


    private void initializePlugin(Context context, BinaryMessenger messenger) {
        this.channel = new MethodChannel(messenger, "flutter_msa_sdk");
        channel.setMethodCallHandler(this);
        try {
            helper.getDeviceIds(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
        initializePlugin(binding.getApplicationContext(), binding.getBinaryMessenger());
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
        switch (call.method) {
            case "isSupport":
                result.success(helper.isSupport());
                return;
            case "getOAID":
                result.success(helper.getOAID());
                return;
            case "getVAID":
                result.success(helper.getVAID());
                return;
            case "getAAID":
                result.success(helper.getAAID());
                return;
            default:
                result.notImplemented();
        }
    }
}
