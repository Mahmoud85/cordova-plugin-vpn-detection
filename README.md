# Cordova VPN Dectector
This Plugin works for both Android and iOS platform, and it is intended to be used for legacy Ionic 2,3 and 4 apps to detect Acttive VPN on mobile device, so it is tested tow work with
* Node version 10.x
* cordova ">=3.0.0"


# Install cordova-vpn-detection plugin
*  Run `npm i cordova-plugin-vpn-detection`
* Run `ionic cordova plugin add cordova-plugin-vpn-detection`

# Usage

### Is VPN active on device

```
window.vpndetection.detectActiveVPN(successCallback, errorCallback)
```

* `=> successCallback` is called with true if VPN is active on device and returned param is string `ACTIVEVPN`
* `=> errorCallback` is called if there was an error determining if a VPN is active and returned params is string `INACTIVEVPN`


# Example

```
  let successCallback = function (result) {
    let VPNIsActive = result == "ACTIVEVPN"
  };
  let errorCallback = function (failure) {
    console.log(failure)
  };

```

> [!TIP]
> I would recommend to use the plugin by implementing the check in two different cases as below:  
    Make the check when app is initialized  
    Make the check when app status change from background to foreground, so that vpn check will be done even if user activated the VPN after launching the app.

## Platform Support

iOS and Android.

## License

[MIT License](http://ilee.mit-license.org)




## Mahmoud Bakhit © 2024
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
