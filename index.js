import React from 'react';
import { NativeModules } from 'react-native';

console.log(NativeModules.RNAlerts);

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
   *    accept (optional)
   *    cancel (optional)
   * }
   */
  static confirm (options, successCB, failureCB) {
	  NativeModules.RNAlerts.confirm(options, successCB, failureCB);
  }

  /**
   * Allows to show native alert confirm
   * Props: {
   *    title (optional)
   *    message (optional)
   *    inputtype (optional)
   *    placeholder (optional)
   *    accept (optional)
   *    cancel (optional)
   * }
   */
  static prompt (options, successCB, failureCB) {
	  NativeModules.RNAlerts.prompt(options, cb);
  }

  /**
   * Allows to show native alert confirm
   * Props: {
   *    title (optional)
   *    message (optional)
   *    placeholder (optional)
   *    type (optional)
   *    accept (optional)
   *    cancel (optional)
   * }
   */
  static login (options, successCB, failureCB) {
	  NativeModules.RNAlerts.login(options, cb);
  }

}

module.exports = Alerts;