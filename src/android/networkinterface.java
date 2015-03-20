package com.albahra.plugin.networkinterface;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;

public class networkinterface extends CordovaPlugin {
	public static final String GET_IP_ADDRESS="getIPAddress";
	public static final String GET_ROUTER_ADDRESS="getRouterAddress";
	public static final String OPEN_WIFI_SETTINGS ="showNetworkSettings";

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		try {
			String fail = "0.0.0.0";

		
			if (GET_IP_ADDRESS.equals(action)) {
				String ip = getIPAddress();				
				if (ip.equals(fail)) {
					callbackContext.error("Got no valid IP address");
					return false;
				}
				callbackContext.success(ip);
				return true;
			}
			
			if (GET_ROUTER_ADDRESS.equals(action)) {
				String ip = getRouterAddress();
				if (ip.equals(fail)) {
					callbackContext.error("Got no valid IP address");
					return false;
				}
				callbackContext.success(ip);
				return true;
			}	

			if (OPEN_WIFI_SETTINGS.equals(action)) {
				showNetworkSettings();
				callbackContext.success();
				return true;
			}			

			
			callbackContext.error("Error no such method '" + action + "'");
			return false;
		} catch(Exception e) {
			callbackContext.error("Error while retrieving the IP address. " + e.getMessage());
			return false;
		}
	}

	private String formatIP(int ip){
		return String.format(
			"%d.%d.%d.%d",
			(ip & 0xff),
			(ip >> 8 & 0xff),
			(ip >> 16 & 0xff),
			(ip >> 24 & 0xff)
			);
	}

	private String getIPAddress() {
		WifiManager wifiManager = (WifiManager) cordova.getActivity().getSystemService(Context.WIFI_SERVICE);
		WifiInfo wifiInfo = wifiManager.getConnectionInfo();
		int ip = wifiInfo.getIpAddress();
		return formatIP(ip);
	}
	
	private String getRouterAddress() {
		WifiManager wifiManager = (WifiManager) cordova.getActivity().getSystemService(Context.WIFI_SERVICE);
		DhcpInfo dhcp = wifiManager.getDhcpInfo();
		int ip = dhcp.gateway;
		return formatIP(ip);
	}	

	private static void showNetworkSettings(){
		Context.startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
	}
	
}
