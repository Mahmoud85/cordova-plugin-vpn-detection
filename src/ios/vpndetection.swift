//
//  VpnDetection.swift
//
//  Created by Mahmoud Bakhit 17-01-2024.

import Foundation


@objc(vpndetection)
class vpndetection: CDVPlugin {
  
 func isVpnActive() -> Bool {
   let vpnProtocolsKeysIdentifiers = [
          "tap", "tun", "ppp", "ipsec", "utun"
      ]

   guard let cfDict = CFNetworkCopySystemProxySettings() else { return false }
          let nsDict = cfDict.takeRetainedValue() as NSDictionary
          guard let keys = nsDict["__SCOPED__"] as? NSDictionary,
              let allKeys = keys.allKeys as? [String] else { return false }

          // Checking for tunneling protocols in the keys
          for key in allKeys {
              for protocolId in vpnProtocolsKeysIdentifiers
                  where key.starts(with: protocolId) {
                  return true
              }
          }
          return false
   
   }

 @objc(detectActiveVPN:)
    func detectActiveVPN(_ command: CDVInvokedUrlCommand){
        guard let callbackId = command.callbackId else { return }
        var pluginResult: CDVPluginResult
        if(isVpnActive()){
            pluginResult = CDVPluginResult(status: CDVCommandStatus_OK, messageAs: "ACTIVEVPN")
        }else{
            pluginResult = CDVPluginResult(status: CDVCommandStatus_ERROR, messageAs: "INACTIVEVPN")
        }
        commandDelegate.send(pluginResult, callbackId: callbackId)
    }

  }
  

