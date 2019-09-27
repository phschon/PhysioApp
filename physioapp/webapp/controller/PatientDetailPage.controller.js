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
			var that = this;
			this.patIndex = oEvent.getParameter("arguments").patIdx;
			setTimeout(function() {
				var oPatientData = that.getOwnerComponent().getModel("allUsers").getProperty("/" + that.patIndex);
				
				if (oPatientData) {
					that.patId = oPatientData.id;
					var oSelectedPatient = new JSONModel(oPatientData);			
					that.getView().setModel(oSelectedPatient, "selectedPatient");
				}
			}, 100);
		},

		onPatientSearch : function(oEvent) {
			// add filter for search
		},
		pressPatientShowVideos: function(oEvent) {
			this.oRouter.navTo("patientVideos", {
				patIdx: this.patIndex,
				patId: this.patId
			});
		},
		pressPatientShowTrainingPrograms: function(oEvent) {
			this.oRouter.navTo("patientPrograms", {
				patIdx: this.patIndex,
				patId: this.patId
			});
		}
	});
});