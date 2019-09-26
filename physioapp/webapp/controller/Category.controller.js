sap.ui.define([
	"sap/ui/core/mvc/Controller"
], function (Controller) {
	"use strict";

	return Controller.extend("sapcp.cf.strongpeople.physioapp.controller.Category", {
		onInit: function () {
			var that = this;
			setTimeout(function() {
				that.getView().setModel(that.getOwnerComponent().getModel("myUser"), "selectedRole");
			}, 1000);
		},
		
		physioCategoryPress: function(oEvent) {
			var oRouter = sap.ui.core.UIComponent.getRouterFor(this);
			oRouter.navTo("patientsMasterList", {
				patIdx: "0"
			});
		},
		
		patientCategoryPress: function(oEvent) {
			
		}
		
	});

});