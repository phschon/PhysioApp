/* global QUnit */
QUnit.config.autostart = false;

sap.ui.getCore().attachInit(function () {
	"use strict";

	sap.ui.require([
		"sapcp/cf/strongpeople/physioapp/test/unit/AllTests"
	], function () {
		QUnit.start();
	});
});