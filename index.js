import { NativeModules } from 'react-native';

const NativeARView = NativeModules.ARView;

export default class ARView {
    /** Download natively and Display the AR (Experimental)
     * @param {*} remoteURL URL of the 3D Model File
     */
    static instantGo(remoteURL){
      NativeARView.instantGo(remoteURL);
    }
}
