# vt-arcore

### Version 1.0.3
vt-arcore is an Android AR module for VT. Uses Scene Viewer to display the GLTF file in Augmented Reality. This module does handle the downloading of the 3D file.

## Getting started

`$ npm install https://github.com/syahman-vettons/vt-arcore --save`

or

`$ yarn add https://github.com/syahman-vettons/vt-arcore`


### Mostly automatic installation

`$ react-native link vt-arcore`

### Android Install (Manual) 

1. Open up `android/app/src/main/java/[...]/MainApplication.java`
    - Add `import com.vtarcore.VtArcorePackage;` to the imports at the top of the file
    - Add `new VtArcorePackage()` to the list returned by the `getPackages()` method
    
2. Append the following lines to `android/settings.gradle`:
```
include ':vt-arcore'
project(':vt-arcore').projectDir = new File(rootProject.projectDir, '../node_modules/vt-arcore/android')
```

3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
```
implementation project(':vt-arcore')
```

## Usage
```javascript
import ARView from 'vt-arcore';

// URL of the 3D Model File to download
let remoteURL = 'https://raw.githubusercontent.com/KhronosGroup/glTF-Sample-Models/master/2.0/DamagedHelmet/glTF/DamagedHelmet.gltf'

/** Download natively and Display the AR
 * @param {*} remoteURL URL of the 3D Model File
 */
ARView.instantGo(remoteURL);
```

