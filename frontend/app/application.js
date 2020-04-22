define([
    "marionette",
    "underscore",
    "text!environment.json",
    "components/dialog.region",
    "components/notification.region"
], function(Marionette, _, Environment, DialogRegion, NotificationRegion) {

    const Application = new Marionette.Application();

    Application.State       = Backbone.Events;
    Application.Environment = JSON.parse(Environment);

    Application.addRegions({
        mainRegion: "#main-region",
        headerRegion: "#header-region",
        dialogRegion: DialogRegion.extend({el: "#modal-region"}),
        notificationRegion: NotificationRegion.extend({el: "#notification-region"})
    });

    Application.getURI = function(resource) {
        return Application.Environment.URI + resource;
    };

    Application.on("notification", function (message, type) {
        require([
            "modules/notification/notification"
        ],function (Notification) {
            Notification.init(message, type);
        });
    });

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
