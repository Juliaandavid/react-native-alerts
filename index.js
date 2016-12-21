import React from 'react';
import { NativeModules } from 'react-native';

class RNAlerts {

  static testParameters (options, cb) {
      NativeModules.RNAlerts.testParameters(options, cb);
  }

  // Allow to show native alert. {options: title, message, button}
  static alert (options, cb) {
      NativeModules.RNAlerts.alert(options, cb);
  }

  // Allow to show native alert. {options: title, message, button}
  static alert (options, cb) {
      NativeModules.RNAlerts.alert(options, cb);
  }

  static confirm (options, cb) {
	  //NativeModules.RNAlerts.confirm(options, cb);
  }

  static prompt (options, cb) {
	  //NativeModules.RNAlerts.prompt(options, cb);
  }

  static login (options, cb) {
	  //NativeModules.RNAlerts.login(options, cb);
  }

}

module.exports = RNAlerts;