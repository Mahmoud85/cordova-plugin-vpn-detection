
// VPN detection Class 
// By Mahmoud Bakhit 19/1/2024

package cordova.plugin.vpn.detection;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.util.Log;

/**
 * This class Pass to Cordova result of VPN detection check.
 */
public class vpndetection extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("detectActiveVPN")) {
            this.detectActiveVPN(callbackContext);
            return true;
        }
        return false;
    }

     private void detectActiveVPN(callbackContext) {
       if (isVPNActive()) {
            callbackContext.success("ACTIVEVPN");
        } else {
            callbackContext.error("INACTIVEVPN");
        }
    }

    private boolean isVPNActive(){

        try {

            //this method doesn't work below API 21
            if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                return false;
            }

            boolean vpnInUse = false;

            ConnectivityManager connectivityManager = (ConnectivityManager) reactContext.getSystemService(reactContext.CONNECTIVITY_SERVICE);

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {

                Network activeNetwork = connectivityManager.getActiveNetwork();
                NetworkCapabilities caps = connectivityManager.getNetworkCapabilities(activeNetwork);
                vpnInUse =  caps.hasTransport(NetworkCapabilities.TRANSPORT_VPN) || !caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_NOT_VPN)
            }

            Network[] networks = connectivityManager.getAllNetworks();

            for (int i = 0; i < networks.length; i++) {

                NetworkCapabilities caps = connectivityManager.getNetworkCapabilities(networks[i]);
                if (caps.hasTransport(NetworkCapabilities.TRANSPORT_VPN)) {
                    vpnInUse = true;
                    break;
                }
            }

            return vpnInUse;
        }
        catch (Exception e){
            return true;
        }
    }
}

       

        