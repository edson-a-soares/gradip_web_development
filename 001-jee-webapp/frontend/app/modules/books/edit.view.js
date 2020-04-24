define([
    "application",
    "underscore",
    "text!modules/books/templates/edit.html",
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
            const data = Backbone.Syphon.serialize(this);
            this.trigger("data:submit", data);
        }

    });

});