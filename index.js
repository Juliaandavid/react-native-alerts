import React from 'react';
import { NativeModules } from 'react-native';

class Alerts {

  static inputTypes = {
    TEXT: NativeModules.RNAlerts.INPUT_TEXT,
    EMAIL: NativeModules.RNAlerts.INPUT_EMAIL,
    NUMBER: NativeModules.RNAlerts.INPUT_NUMBER,
    PASSWORD: NativeModules.RNAlerts.INPUT_PASSWORD,
    PHONE: NativeModules.RNAlerts.INPUT_PHONE
  }

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
  static confirm (options, cb) {
	  NativeModules.RNAlerts.confirm(options, cb);
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
  static prompt (options, cb) {
	  NativeModules.RNAlerts.prompt(options, cb);
  }

  /**
   * Allows to show native alert confirm
   * Props: {
   *    title (optional)
   *    message (optional)
   *    userInputType
   *    userPlaceholder
   *    passwordInputType
   *    passwordPlaceholder
   *    accept (optional)
   *    cancel (optional)
   * }
   */
  static login (options, cb) {
	  NativeModules.RNAlerts.login(options, cb);
  }

}

module.exports = Alerts;