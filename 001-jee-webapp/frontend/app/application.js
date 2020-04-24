define([
    "marionette",
    "underscore",
    "text!environment.json",
    "components/dialog.region"
], function(Marionette, _, Environment, DialogRegion) {

    const Application = new Marionette.Application();

    Application.State       = Backbone.Events;
    Application.Environment = JSON.parse(Environment);

    Application.addRegions({
        mainRegion: "#main-region",
        headerRegion: "#header-region",
        dialogRegion: DialogRegion.extend({el: "#modal-region"})
    });

    Application.redirectTo = function (url) {
        document.location = url;
    };

    Application.getURI = function(resource) {
        return Application.Environment.URI + resource;
    };

    Application.on("start", function () {
        if(Backbone.history) {
            require([
                "modules/books/books",
                "modules/controls/header"
            ], function () {
                Backbone.history.start();
            });
        }
    });

    return Application;

});
