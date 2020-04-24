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

        editBook: function (e) {
            e.preventDefault();
            const identity = $(e.currentTarget).data("id");
            Application.trigger("books:edit", identity);
        },

        removeBook: function (e) {
            e.preventDefault();
            const identity = $(e.currentTarget).data("id");
            Application.trigger("books:remove", identity);
        }

    });

    return Marionette.CompositeView.extend({

        tagName: 'table',

        className: 'table table-striped table-hover',

        template: _.template(tableTmpl),

        childView: BookTableRowView,

        onShow: function () {
            this.collection.fetch();
            this.render();
        },

        childViewContainer: 'tbody'

    });

});
