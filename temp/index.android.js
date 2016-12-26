/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  Button,
  View
} from 'react-native';
import RNAlerts from 'react-native-alerts'

const buttonTest = () => {
  RNAlerts.testParameters({
    param1: "Parameter"
  }, (res) => {
    console.log(res);
  });
};

const buttonAlert = () => {
  RNAlerts.alert({
    title: "Title",
    message: "This is a testing message",
    button: "Accept"
  }, (res) => {
    console.log(res);
  });
};

export default class testing extends Component {
  render() {
    return (
      <View style={styles.container}>
        <Button
          onPress={buttonTest}
          title="Testing" />
        <Button
          onPress={onButtonPress}
          title="Alert" />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

AppRegistry.registerComponent('testing', () => testing);
