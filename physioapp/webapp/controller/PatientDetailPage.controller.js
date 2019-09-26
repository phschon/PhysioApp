sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"sap/ui/model/Filter",
	"sap/ui/model/json/JSONModel"
], function (Controller, Filter, JSONModel) {
	"use strict";

	return Controller.extend("sapcp.cf.strongpeople.physioapp.controller.PatientDetailPage", {
		onInit: function (oEvent) {
            this.oRouter = sap.ui.core.UIComponent.getRouterFor(this);
            this.oRouter.attachRoutePatternMatched(this._onObjectMatched, this);
        },
        _onObjectMatched: function(oEvent) {
            this.patIndex = oEvent.getParameter("arguments").patIndex;
			var oPatientData = this.getOwnerComponent().getModel("Patients").getProperty('/patients/' + this.patIndex);
			var oSelectedPatient = new JSONModel(oPatientData);			
            this.getView().setModel(oSelectedPatient, "selectedPatient");
		},

		onPatientSearch : function(oEvent) {
			// add filter for search
		},
		showPatientDiagnosis: function(oEvent) {
			
		},
		pressPatientShowDiagnosis: function(oEvent) {
			
		},
		pressPatientShowVideos: function(oEvent) {
			this.oRouter.navTo("patientVideos", {
				patIndex: this.patIndex
			});
		},
		pressPatientUpdateDetails: function(oEvent) {
			
		},
		pressPatientShowTrainingPrograms: function(oEvent) {
			this.oRouter.navTo("patientPrograms");
		}
	});
});