var networkinterface = function() {
};

networkinterface.getIPAddress = function(success, fail) {
    cordova.exec(success, fail, "networkinterface", "getIPAddress", []);
};

networkinterface.getRouterAddress = function(success, fail) {
    cordova.exec(success, fail, "networkinterface", "getRouterAddress", []);
};

networkinterface.showNetworkSettings = function(success, fail) {
    cordova.exec(success, fail, "networkinterface", "showNetworkSettings", []);
};

module.exports = networkinterface;
