var exec = require("cordova/exec");

function vpndetection() {
}

vpndetection.prototype.detectActiveVPN = function (successCallback, errorCallback) {
  exec(
    successCallback,
    errorCallback,
    "vpndetection",
    "detectActiveVPN",
    [{}]
  );
};

module.exports = new vpndetection();
 