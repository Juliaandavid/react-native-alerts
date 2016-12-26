import React from 'react';
import { NativeModules } from 'react-native';

class Alerts {

  // Allow to show native alert. {props: title, message, button}
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

module.exports = Alerts;