Network Interface
=================

This work is based on the excellent work from: https://github.com/salbahra/NetworkInterfacePlugin and extends the original plugin by adding functionality to retrieve the router address.

Currently getRouterAddress is only supported on Android devices.

Network interface information plugin for Cordova/PhoneGap that supports Android, Blackberry 10, iOS, and Windows Phone 8.

## PhoneGap Build

To include the Network Interface plugin in your PhoneGap Build application, add this to your config.xml:

    <gap:plugin name="com.aculocity.plugin.networkinterface" version="1.0.8" />

## Command Line Install

    phonegap plugin add https://github.com/tribe84/NetworkInterfacePlugin

## Usage

The plugin creates the object `networkinterface` with the methods `getIPAddress(onSuccess, onError)` and `getRouterAddress(onSuccess, onError)`.

Example:

	networkinterface.getIPAddress(function (ip) { alert(ip); });
	networkinterface.getRouterAddress(function (ip) { alert(ip); });

Note:
	networkinterface.getRouterAddress is currently only available for Android, iOs coming soon.

## License

The MIT License (MIT)

Copyright (c) 2013 Albahra.com

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
