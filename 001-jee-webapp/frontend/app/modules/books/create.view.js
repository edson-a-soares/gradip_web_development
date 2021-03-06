define([
    "application",
    "underscore",
    "text!modules/books/templates/create.html",
    "backbone.syphon"
], function (Application, _, template) {

    return Marionette.ItemView.extend({

        className: "modal-dialog",

        template: _.template(template),

        triggers: {
            "click .btn-js-cancel": "dialog:close"
        },

        events: {
            "click .btn-js-send-data": "sendData"
        },

        sendData: function(e) {
            e.preventDefault();
            var data = Backbone.Syphon.serialize(this);
            this.trigger("data:submit", data);
        }

    });

});