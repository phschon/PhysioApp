sap.ui.define([
	"sap/ui/core/mvc/Controller"
], function (Controller) {
	"use strict";

	return Controller.extend("DemoPatient.DemoPatient.controller.Training", {
		onInit: function () {
		},
		
		onDisplayProgress: function(Event ) {
			var oRouter = sap.ui.core.UIComponent.getRouterFor(this);
			oRouter.navTo("progress");
		},		
		
		onDisplayMedicalFile: function(Event){
			var oRouter = sap.ui.core.UIComponent.getRouterFor(this);
			oRouter.navTo("medicalFile");			
		},
		
		onModuleSelected: function(Event ) {
			var oRouter = sap.ui.core.UIComponent.getRouterFor(this);
			oRouter.navTo("Module");
		}		
	});
});