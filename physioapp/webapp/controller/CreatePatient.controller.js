sap.ui.define([
	"sap/ui/core/mvc/Controller"
], function (Controller) {
	"use strict";

	return Controller.extend("sapcp.cf.strongpeople.physioapp.controller.CreatePatient", {
		onInit: function () {
			this.oRouter = sap.ui.core.UIComponent.getRouterFor(this);
		},
		
		onLiveChangeCreatePatientID: function(oEvent) {
			
		},
		
		onLiveChangeCreatePatientName: function(oEvent) {
			
		},
		
		onLiveChangeCreatePatientAddress: function(oEvent) {
			
		},
		
		onLiveChangeCreatePatientPhone: function(oEvent) {
			
		},
		
		onLiveChangeCreatePatientEmail: function(oEvent) {
			
		},
		
		createNewPatientDetails: function() {
			
		},
		
		cancelNewPatientDetails: function() {
			this.oRouter.navTo("patientsMasterList", {
				patIdx: "0"
			});
		}
		
	});

});