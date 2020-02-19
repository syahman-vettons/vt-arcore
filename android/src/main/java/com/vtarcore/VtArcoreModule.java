package com.vtarcore;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import java.net.URL;

public class VtArcoreModule extends ReactContextBaseJavaModule {

    String mode;
    Boolean assetResizable;
    String resizable;
    String url;
    String modelURL;

    private final ReactApplicationContext reactContext;

    public VtArcoreModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "ARView";
    }

    @ReactMethod
    public void instantGo(String remoteURL){
        setURL(remoteURL);
        goToAR();
        getCurrentActivity().finish();
    }

    @ReactMethod
    public void allowsContentScaling(Boolean bool) {
        assetResizable = bool;
    }

    private void setURL(String remoteURL) {
        assetResizable = true;
        resizable = "&resizable=" + assetResizable;
//        url = "https://27b0dad5.ngrok.io/KudaRotan.gltf";
        mode = "?mode=ar_preferred";
        modelURL = remoteURL + mode + resizable;
        Log.d("vt-arcore", "setURL: " + modelURL );
    }

    private void goToAR(){
        Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
        sceneViewerIntent.setData(Uri.parse(modelURL));
        sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");
        getCurrentActivity().startActivity(sceneViewerIntent);
    }

    @ReactMethod
    public void sampleMethod(String stringArgument, int numberArgument, Callback callback) {
        // TODO: Implement some actually useful functionality
        callback.invoke("Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument);
    }
}
