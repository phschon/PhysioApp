sap.ui.define([
	"sap/ui/core/mvc/Controller"
], function (Controller) {
	"use strict";

	return Controller.extend("DemoPatient.DemoPatient.controller.Profile", {
		onInit: function () {},

		onDisplayTraining: function (Event) {
			var oRouter = sap.ui.core.UIComponent.getRouterFor(this);
			oRouter.navTo("training");
		},

		onDisplayProfile: function (Event) {
			var oRouter = sap.ui.core.UIComponent.getRouterFor(this);
			oRouter.navTo("profile");
		},

		onDisplayProgress: function (Event) {
			var oRouter = sap.ui.core.UIComponent.getRouterFor(this);
			oRouter.navTo("progress");
		}

	});
});