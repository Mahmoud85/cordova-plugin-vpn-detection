var exec = require('cordova/exec');


module.exports = {
    checkVPN: function (success, error) {
        exec(success, error, "VPNCheaker", "checkVPN", []);
    }
}
 