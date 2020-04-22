define([
    'application',
    'modules/controls/header.view'
], function (Application, HeaderView) {

    const HeaderModuleLoader = Marionette.Object.extend({

        initialize: function (options) {

            var headerView = new HeaderView();

            headerView.on("books:create:clicked", function () {
                Application.trigger("books:create");
            });

            Application.headerRegion.show(headerView);

        }

    });

    return new HeaderModuleLoader();

});
