
// VPN detection Class
// By Mahmoud Bakhit 19/1/2024

package cordova.plugin.vpn.detection;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;

import org.json.JSONArray;
import org.json.JSONException;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.content.Context;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;


/**
 * This class Pass to Cordova result of VPN detection check.
 */
public class vpndetection extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("detectActiveVPN")) {
            detectActiveVPN(callbackContext);
            return true;
        }
        return false;
    }

    ConnectivityManager sockMan;

       private boolean isVPNActive(){
        try {

            //this method doesn't work below API 21
            if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                return false;
            }

            boolean vpnInUse = false;
            this.sockMan = (ConnectivityManager) cordova.getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);


            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {

                Network activeNetwork = this.sockMan.getActiveNetwork();
                NetworkCapabilities caps = this.sockMan.getNetworkCapabilities(activeNetwork);
                vpnInUse =  caps.hasTransport(NetworkCapabilities.TRANSPORT_VPN) || !caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_NOT_VPN);
            }

            Network[] networks = this.sockMan.getAllNetworks();

            for (int i = 0; i < networks.length; i++) {

                NetworkCapabilities caps = this.sockMan.getNetworkCapabilities(networks[i]);
                if (caps.hasTransport(NetworkCapabilities.TRANSPORT_VPN)) {
                    vpnInUse = true;
                    break;
                }
            }

             List<NetworkInterface> networksFaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface networkInterface : networksFaces) {
                if (networkInterface.isUp()) {
                    String iFace = networkInterface.getName();
                    if (iFace != null) {
                        if (iFace.contains("tun") || iFace.contains("ppp") || iFace.contains("pptp")|| iFace.contains("tap")|| iFace.contains("ipsec")) {
                            vpnInUse = true;
                            break;
                        }
                    }
                }
            }

            return vpnInUse;
        }
        catch (Exception e){
            return true;
        }
    }

     private void detectActiveVPN(CallbackContext callbackContext) {
       if (isVPNActive()) {
            callbackContext.success("ACTIVEVPN");
        } else {
            callbackContext.error("INACTIVEVPN");
        }
    }

 
}



