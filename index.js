import { NativeModules } from 'react-native';

const NativeARView = NativeModules.ARView;

export default class ARView {
    /** Download natively and Display the AR using Android Scene Viewer
     * @param {*} remoteURL URL of the 3D Model File
     */
    static instantGo(remoteURL){
      NativeARView.instantGo(remoteURL);
    }

    /** Method to set allowsContentScaling
     * @param {*} bool True of False
     */
    static allowsContentScaling(bool){
        NativeARView.allowsContentScaling(bool);
    }
}
