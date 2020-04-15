define([
    "application",
    "underscore",
    "text!modules/controls/templates/header.html"
], function (Application, _, template) {

    return Marionette.ItemView.extend({

        template: _.template(template),

        triggers: {
            'click #create-book' : 'books:create:clicked'
        }

    });

});
