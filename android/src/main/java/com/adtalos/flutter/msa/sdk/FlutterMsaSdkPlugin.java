package com.adtalos.flutter.msa.sdk;

import android.content.Context;

import androidx.annotation.NonNull;

import com.github.gzuliyujiang.oaid.DeviceID;
import com.github.gzuliyujiang.oaid.IGetter;

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
    private Context context;
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
        this.context = context;
    }

    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
        initializePlugin(binding.getApplicationContext(), binding.getBinaryMessenger());
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull final Result result) {
        switch (call.method) {
            case "isSupport":
                result.success(DeviceID.supportedOAID(context));
                return;
            case "getOAID":
                DeviceID.getOAID(context, new IGetter() {
                    @Override
                    public void onOAIDGetComplete(@NonNull String oaid) {
                        result.success(oaid);
                    }

                    @Override
                    public void onOAIDGetError(@NonNull Throwable error) {
                        result.success("ooxx");
                    }
                });
                return;
            default:
                result.notImplemented();
        }
    }
}
