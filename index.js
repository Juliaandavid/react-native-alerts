import React from 'react';
import { NativeModules } from 'react-native';

class Alerts {

  /**
   * Allows to show native alert
   * Props: {
   *    title (optional)
   *    message (optional)
   *    button (optional)
   * }
   */
  static alert (options, cb) {
      NativeModules.RNAlerts.alert(options, cb);
  }

  /**
   * Allows to show native alert confirm
   * Props: {
   *    title (optional)
   *    message (optional)
   *    buttonAccept (optional)
   *    buttonCancel (optional)
   * }
   */
  static confirm (options, cb) {
	  NativeModules.RNAlerts.confirm(options, cb);
  }

  static prompt (options, cb) {
	  //NativeModules.RNAlerts.prompt(options, cb);
  }

  static login (options, cb) {
	  //NativeModules.RNAlerts.login(options, cb);
  }

}

module.exports = Alerts;