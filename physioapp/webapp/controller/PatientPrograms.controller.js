sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"sap/ui/model/json/JSONModel",
	"sap/ui/model/Filter"
], function (Controller, JSONModel, Filter) {
	"use strict";

	return Controller.extend("sapcp.cf.strongpeople.physioapp.controller.PatientPrograms", {
		onInit: function () {
			this.oRouter = sap.ui.core.UIComponent.getRouterFor(this);
			this.oRouter.attachRoutePatternMatched(this._onObjectMatched, this);
		},
		_onObjectMatched: function(oEvent) {
			var that = this;
			this.patIndex = oEvent.getParameter("arguments").patIdx;
			this.patId = oEvent.getParameter("arguments").patId;
			setTimeout(function() {
				var aPatientProgramData = that.getOwnerComponent().getModel("patientPrograms").getData();
				
				var oSelectedPatientProgramData = aPatientProgramData.filter(function(oPatientProgramData) {
					return oPatientProgramData.patientId === that.patId;
				});

				var oSelectedProgram = new JSONModel(oSelectedPatientProgramData[0]);
				that.getView().setModel(oSelectedProgram, "selectedProgram");
			}, 100);
		},
		goBack: function() {
			this.oRouter.navTo("patientsMasterList", {
				patIdx: this.patIndex
			});
		},
		onPatientProgramItemPress: function() {

		}
	});
});