sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"sap/ui/model/json/JSONModel"
], function (Controller, JSONModel) {
	"use strict";

	return Controller.extend("sapcp.cf.strongpeople.physioapp.controller.App", {
		onInit: function () {
			$.ajax({
				method: "GET",
				url: "/api/users/",
				dataType: "JSON"
			}).done(function(oData){
				var oModel = new JSONModel(oData);
				this.getOwnerComponent().setModel(oModel, "allUsers");
			}.bind(this)).error(function(oError) {
				console.log(oError);
			});

			$.ajax({
				method: "GET",
				url: "/api/users/ownuser",
				dataType: "JSON"
			}).done(function(data){
				var oModel = new JSONModel(data);
				this.getOwnerComponent().setModel(oModel, "myUser");
			}.bind(this)).error(function(oError) {
				console.log(oError);
			});
		}
	});
});