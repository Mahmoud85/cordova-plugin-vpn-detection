var exec = require("cordova/exec");

var VPNdetection = function () {
    this.name = "VPNdetection";
};

VPNdetection.prototype.detectActiveVPN = function (successCallback, failureCallback) {
    exec(successCallback, failureCallback, "VPNdetection", "detectActiveVPN", []);
};

module.exports = new VPNdetection();
 