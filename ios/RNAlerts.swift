//
//  RNAlerts.swift
//  RNAlerts
//
//  Created by Mocion on 12/27/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

import Foundation

@objc(CalendarManager)
class CalendarManager: NSObject {
    
    /*@objc(addEvent:location:date:)
    func addEvent(name: String, location: String, date: NSNumber) -> Void {
        // Date is ready to use!
    }*/
    
    @objc(alert:callback:)
    func alert(name: String, callback: RCTResponseSenderBlock) -> Void {
        let alert = UIAlertController(title: "Alert", message: "Message", preferredStyle: UIAlertControllerStyle.alert)
        alert.addAction(UIAlertAction( title: "OK", style: .default) { (action) in
            callback("_" + name + "_")
        })
        self.present(alert, animated: true, completion: nil)
    }
    
}
