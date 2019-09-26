sap.ui.define([
    "sap/ui/core/mvc/Controller",
    "sap/ui/model/Filter",
], function (Controller, Filter) {
	"use strict";

	return Controller.extend("sapcp.cf.strongpeople.physioapp.controller.PatientsMasterList", {
		onInit: function () {
            this.oRouter = sap.ui.core.UIComponent.getRouterFor(this);
        },
        onPatientSearch: function(oEvent) {
            var aFilters = [];
			var sQuery = oEvent.getSource().getValue();
			if (sQuery && sQuery.length > 0) {
				var filter = new Filter("firstName", sap.ui.model.FilterOperator.Contains, sQuery);
				aFilters.push(filter);
			}

			// update list binding
			var oList = this.byId("patientsList");
			var binding = oList.getBinding("items");
			binding.filter(aFilters, "Application");
        },
        onPatientPressMasterPage: function(oEvent) {
            var oContext = oEvent.getSource().getBindingContext('allUsers');
			var sPath = oContext.sPath;
			var iStart = sPath.lastIndexOf('/') + 1;
			var iPatIndex = sPath.substring(iStart, sPath.length);
			this.oRouter.navTo("patientsMasterList", {
				patIndex: iPatIndex
			});
		},
		handleCreateNewPatient: function(oEvent) {
			this.oRouter.navTo("createPatient");
		},
	});

});