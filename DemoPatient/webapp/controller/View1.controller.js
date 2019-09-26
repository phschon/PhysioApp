sap.ui.define([
	"sap/ui/core/mvc/Controller"
], function (Controller) {
	"use strict";

	return Controller.extend("DemoPatient.DemoPatient.controller.View1", {
		onInit: function () {
			$.ajax({
				method: "GET",
				url: "/api/programs/",
				dataType: "JSON"
			}).done(function (data) {;
				var oModel = new JSONModel(data);
				/*this.getOwnerComponent().setModel(oModel, "myUser");*/
			}.bind(this)).error(function (oError) {
				console.log(oError);
			});
		},

		onDisplayTraining: function (Event) {
			var oRouter = sap.ui.core.UIComponent.getRouterFor(this);
			oRouter.navTo("training");
		},

		onDisplayProfile: function (Event) {
			var oRouter = sap.ui.core.UIComponent.getRouterFor(this);
			oRouter.navTo("profile");
		},

		onDisplayMedicalFile: function (Event) {
			var oRouter = sap.ui.core.UIComponent.getRouterFor(this);
			oRouter.navTo("medicalFile");
		}
	});
});