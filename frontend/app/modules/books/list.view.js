define([
    "application",
    "underscore",
    "text!modules/books/templates/list.html"
], function (Application, _, template) {

    return Marionette.LayoutView.extend({

        template: _.template(template),

        events: {
            "click .edit" : "editBook",
            "click .delete" : "removeBook"
        },

        editBook: function () {
            Application.trigger("books:edit");
        },

        removeBook: function () {
            Application.trigger("books:remove");
        }

    });

});
