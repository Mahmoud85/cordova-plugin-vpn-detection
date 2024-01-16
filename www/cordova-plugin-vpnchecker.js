var exec = require('cordova/exec');


module.exports = {
    checkVPN: function (success, error) {
        return exec(success, error, "vpnchecker", "checkvpn", []);
    }
}
 