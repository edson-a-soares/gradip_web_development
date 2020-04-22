define([
    "application",
    "underscore",
    'text!modules/books/templates/table.html',
    'text!modules/books/templates/table.row.html'
], function (Application, _, tableTmpl, rowTmpl) {

    const BookTableRowView = Marionette.ItemView.extend({

        tagName : 'tr',

        template: _.template(rowTmpl),

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

    return Marionette.CompositeView.extend({

        tagName: 'table',

        className: 'table table-striped table-hover',

        template: _.template(tableTmpl),

        childView: BookTableRowView,

        childViewContainer: 'tbody'

    });

});
