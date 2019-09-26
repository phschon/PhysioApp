sap.ui.define([
	"sap/ui/core/mvc/Controller"
], function (Controller) {
	"use strict";

	return Controller.extend("DemoPatient.DemoPatient.controller.View1", {
		onInit: function () {
		},
		
		onDisplayTraining: function(Event ) {
			var oRouter = sap.ui.core.UIComponent.getRouterFor(this);
			oRouter.navTo("training");
		},
		
		onDisplayMedicalFile: function(Event){
			var oRouter = sap.ui.core.UIComponent.getRouterFor(this);
			oRouter.navTo("medicalFile");			
		}
	});
});