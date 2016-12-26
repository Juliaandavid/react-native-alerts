
# react-native-alerts

# Comming soon (This is in development)

## Getting started

`$ npm install react-native-alerts --save`

### Mostly automatic installation

`$ react-native link react-native-alerts`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-alerts` and add `RNAlerts.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNAlerts.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNAlertsPackage;` to the imports at the top of the file
  - Add `new RNAlertsPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-alerts'
  	project(':react-native-alerts').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-alerts/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-alerts')
  	```

## Usage

After install the library, you can import it to use.

```javascript
import Alerts from 'react-native-alerts';
```

## Methods

### Alert

Open single alert. (All parameters are optionals)

| Name  | Type     | Description |
| :---- | :------: | :--- |
| title | string | Title of alert |
| message | string | Message of alert |
| button | string | Alert button text |

```javascript
Alerts.alert({
	title: 'Title',
	message: 'This is a message',
	button: 'Sure!'
}, () => {
	//Event fired when user click on button
});

Alerts;
```

### Confirm

Open single confirm alert. (All parameters are optionals)

| Name  | Type     | Description |
| :---- | :------: | :--- |
| title | string | Title of alert |
| message | string | Message of alert |
| accept | string | Alert button accept text |
| cancel | string | Alert button cancel text |

```javascript
Alerts.confirm({
	title: 'Title',
	message: 'Are you sure?',
	accept: 'YES',
	cancel: 'NO'
}, (res) => {
	// res: return true if accept button is preset, else return false
});
```