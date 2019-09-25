sap.ui.define([
	"sap/ui/core/mvc/Controller"
], function (Controller) {
	"use strict";

	return Controller.extend("sapcp.cf.strongpeople.physioapp.controller.PatientVideos", {
		onInit: function () {
			var oModel = this.getView().getModel("Videos");            
		}
	});
});