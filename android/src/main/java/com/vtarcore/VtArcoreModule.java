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
    String intentURL;

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
    }

    @ReactMethod
    public void allowsContentScaling(Boolean bool) {
        assetResizable = bool;
    }

    private void setURL(String remoteURL) {
        assetResizable = true;
        resizable = "&resizable=" + assetResizable;
        mode = "&mode=ar_preferred";
        intentURL = "https://arvr.google.com/scene-viewer/1.0?file=";
        modelURL = intentURL + remoteURL + mode + resizable;
        Log.d("vt-arcore", "setURL: " + modelURL );
    }

    private void goToAR(){
        Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
        sceneViewerIntent.setData(Uri.parse(modelURL));
        sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");
        getCurrentActivity().startActivity(sceneViewerIntent);
    }
}
