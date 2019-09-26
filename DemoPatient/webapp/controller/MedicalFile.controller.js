sap.ui.define([
	"sap/ui/core/mvc/Controller"
], function (Controller) {
	"use strict";

	return Controller.extend("DemoPatient.DemoPatient.controller.MedicalFile", {
		onInit: function () {
		},
		
		onDisplayTraining: function(Event ) {
			var oRouter = sap.ui.core.UIComponent.getRouterFor(this);
			oRouter.navTo("training");
		},		
		
		onDisplayProgress: function(Event){
			var oRouter = sap.ui.core.UIComponent.getRouterFor(this);
			oRouter.navTo("progress");			
		}
		
	});
});