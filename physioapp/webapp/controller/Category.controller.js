sap.ui.define([
	"sap/ui/core/mvc/Controller"
], function (Controller) {
	"use strict";

	return Controller.extend("sapcp.cf.strongpeople.physioapp.controller.Category", {
		onInit: function () {

		},
		
		physioCategoryPress: function(oEvent) {
			var oRouter = sap.ui.core.UIComponent.getRouterFor(this);
			oRouter.navTo("actions");
		},
		
		patientCategoryPress: function(oEvent) {
			
		}
		
	});

});