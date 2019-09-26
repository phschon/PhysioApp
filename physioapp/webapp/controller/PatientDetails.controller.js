sap.ui.define([
	"sap/ui/core/mvc/Controller",
	'sap/ui/model/Filter'
], function (Controller, Filter) {
	"use strict";

	return Controller.extend("sapcp.cf.strongpeople.physioapp.controller.PatientDetails", {
		onInit: function () {
			this.oRouter = sap.ui.core.UIComponent.getRouterFor(this);
		},
		onPatientSearch : function(oEvent) {
			// add filter for search
		},
		showPatientDiagnosis: function(oEvent) {
			
		},
		pressPatientShowDiagnosis: function(oEvent) {
			
		},
		pressPatientShowVideos: function(oEvent) {
			this.oRouter.navTo("patientVideos");
		},
		pressPatientUpdateDetails: function(oEvent) {
			
		},
		pressPatientShowTrainingPrograms: function(oEvent) {
			this.oRouter.navTo("patientPrograms");
		}
	});
});