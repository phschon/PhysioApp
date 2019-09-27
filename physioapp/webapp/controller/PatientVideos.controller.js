sap.ui.define([
	"sap/ui/core/mvc/Controller"
], function (Controller) {
	"use strict";

	return Controller.extend("sapcp.cf.strongpeople.physioapp.controller.PatientVideos", {
		onInit: function () {
			this.oRouter = sap.ui.core.UIComponent.getRouterFor(this);
			this.oRouter.attachRoutePatternMatched(this._onObjectMatched, this);
		},
		_onObjectMatched: function(oEvent) {
			var that = this;
			this.patIndex = oEvent.getParameter("arguments").patIdx;
			this.patId = oEvent.getParameter("arguments").patId;
		},
		goBack: function() {
			this.oRouter.navTo("patientsMasterList", {
				patIdx: this.patIndex
			});
		}
	});
});