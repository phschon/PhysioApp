sap.ui.define([
	"sap/ui/core/mvc/Controller"
], function (Controller) {
	"use strict";

	return Controller.extend("DemoPatient.DemoPatient.controller.View1", {
		onInit: function () {
			debugger;
			$.ajax({
				method: "GET",
				url: "/api/programs/",
				dataType: "JSON"
			}).done(function(data){
				debugger;
				var oModel = new JSONModel(data);
				/*this.getOwnerComponent().setModel(oModel, "myUser");*/
			}.bind(this)).error(function(oError) {
				debugger;
				console.log(oError);
			});	
		},
		
		onDisplayTraining: function(Event) {
			var oRouter = sap.ui.core.UIComponent.getRouterFor(this);
			oRouter.navTo("training");
		},
		
		onDisplayMedicalFile: function(Event){
			var oRouter = sap.ui.core.UIComponent.getRouterFor(this);
			oRouter.navTo("medicalFile");			
		}
	});
});