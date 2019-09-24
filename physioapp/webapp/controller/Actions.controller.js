sap.ui.define([
	"sap/ui/core/mvc/Controller"
], function (Controller) {
	"use strict";

	return Controller.extend("sapcp.cf.strongpeople.physioapp.controller.Actions", {
		onInit: function () {
			this.oRouter = sap.ui.core.UIComponent.getRouterFor(this);
		},
		
		patientsPress: function(oEvent) {
			this.oRouter.navTo("patientDetails");
		},
		
		createPatientPress: function(oEvent) {
			this.oRouter.navTo("createPatient");
		},
		
		goBack: function(oEvent) {
			this.oRouter.navTo("default");
		}
	});

});