var networkinterface = function() {
};

networkinterface.getIPAddress = function(success, fail) {
    cordova.exec(success, fail, "networkinterface", "getIPAddress", []);
};

networkinterface.getRouterAddress = function(success, fail) {
    cordova.exec(success, fail, "networkinterface", "getRouterAddress", []);
};

module.exports = networkinterface;
