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
            /* var sHash = this.oRouter.getHashChanger().hash;
           
            if (sHash) {
                var oControl = this.byId("PatientDetailsTable");
                oControl.bindElement(sHash);
            } */

        },
        _onObjectMatched: function(oEvent) {
            this.patIndex = oEvent.getParameter("arguments").patIndex;
			//var oContext = this.getOwnerComponent().getModel("Patients").getContext('/patients/' + this.patIndex);

			var oPatientData = this.getOwnerComponent().getModel("Patients").getProperty('/patients/' + this.patIndex);
			
			var oSelectedPatient = new JSONModel(oPatientData);

			
            this.getView().setModel(oSelectedPatient, "selectedPatient");
            //this.getView().setBindingContext(oContext, 'patients');
		},
		
		// _bindView : function (sObjectPath) {
		// 	// Set busy indicator during view binding
		// 	var oViewModel = this.getModel("detailView");

		// 	// If the view was not bound yet its not busy, only if the binding requests data it is set to busy again
		// 	oViewModel.setProperty("/busy", false);

		// 	this.getView().bindElement({
		// 		path : sObjectPath,
		// 		events: {
		// 			change : this._onBindingChange.bind(this),
		// 			dataRequested : function () {
		// 				oViewModel.setProperty("/busy", true);
		// 			},
		// 			dataReceived: function () {
		// 				oViewModel.setProperty("/busy", false);
		// 			}
		// 		}
		// 	});
		// },

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