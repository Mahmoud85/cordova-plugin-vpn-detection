# Cordova VPN Dectector
This Plugin is now for iOS only (Android is on the way) and it is intended to be used for legacy Ionic 3 to detect Acttive VPN on mobile device, so it is compitable with
* Node version 10.x
* cordova ">=3.0.0"


# Install cordova-vpn-detection plugin
*  Run `npm i cordova-plugin-vpn-detection`
* Run `ionic cordova plugin add cordova-plugin-vpn-detection`
## TL;DR

# How to sue

```
    window.vpndetection.detectActiveVPN(success={
        // Active VPN detected success result is "ACTIVEVPN"
            console.log(success)
                },failure=>{
            // No Active VPN detected failure result is "INACTIVEVPN"
        console.log(failure)

    }
)
```

[!TIP]
 I would recommend to use the plugin by implementing the check in two different cases as below:
   * Make the check when app is initialized
   * Make the check when app status change from background to foreground, so that vpn check will be done even if    user activated the VPN after launching the app.
   


# @ By:
___  ___      _                               _  
|  \/  |     | |                             | | 
| .  . | __ _| |__  _ __ ___   ___  _   _  __| | 
| |\/| |/ _` | '_ \| '_ ` _ \ / _ \| | | |/ _` | 
| |  | | (_| | | | | | | | | | (_) | |_| | (_| | 
\_|  |_/\__,_|_| |_|_| |_| |_|\___/ \__,_|\__,_| 
                                                 
                                                 
   ______    _   _                               
   |  ___|  | | | |                              
   | |_ __ _| |_| |__  _   _                     
   |  _/ _` | __| '_ \| | | |                    
   | || (_| | |_| | | | |_| |                    
   \_| \__,_|\__|_| |_|\__, |                    
                        __/ |                    
@ Email:
## mahmoudfathy0@gmail.com
