import React from 'react';
import { NativeModules } from 'react-native';

class RNAlerts {
	/**
	 * Allow to show native alert.
	 * options:
	 * 1. message
	 * 2. title, message
	 * 3. title, message, buttonName
	 */
  static alert(options, cb) {
    return new Promise((resolve, reject) => {
      NativeModules.RNAlerts.alert(options.message, () => {
        cb();
      });
    })
  }
}