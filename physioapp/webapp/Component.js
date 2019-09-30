sap.ui.define([
	"sap/ui/core/UIComponent",
	"sap/ui/Device",
	"sapcp/cf/strongpeople/physioapp/model/models",
	"sap/ui/model/json/JSONModel"
], function (UIComponent, Device, models, JSONModel) {
	"use strict";

	return UIComponent.extend("sapcp.cf.strongpeople.physioapp.Component", {

		metadata: {
			manifest: "json"
		},

		/**
		 * The component is initialized by UI5 automatically during the startup of the app and calls the init method once.
		 * @public
		 * @override
		 */
		init: function () {
			// call the base component's init function
			UIComponent.prototype.init.apply(this, arguments);

			// enable routing
			this.getRouter().initialize();

			// set the device model
			this.setModel(models.createDeviceModel(), "device");

			$.ajax({
				method: "GET",
				url: "/api/users/patients",
				dataType: "JSON"
			}).done(function(oData){
				var oModel = new JSONModel(oData);
				this.setModel(oModel, "allUsers");
			}.bind(this)).error(function(oError) {
				console.log(oError);
			});

			$.ajax({
				method: "GET",
				url: "/api/users/ownuser",
				dataType: "JSON"
			}).done(function(data){
				var oModel = new JSONModel(data);
				this.setModel(oModel, "myUser");
			}.bind(this)).error(function(oError) {
				console.log(oError);
			});

			$.ajax({
				method: "GET",
				url: "/api/programs/",
				dataType: "JSON"
			}).done(function(data){
				var oModel = new JSONModel(data);
				this.setModel(oModel, "patientPrograms");
			}.bind(this)).error(function(oError) {
				console.log(oError);
			});
		}
	});
});