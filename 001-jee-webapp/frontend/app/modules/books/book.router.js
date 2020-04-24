define([
    'application',
    'marionette'
], function (Application, Marionette) {

    return Marionette.AppRouter.extend({

        routes: {
            'books': 'loadBooks',
        },

        loadBooks: function () {
            Application.trigger("books:load");
        },

    });

});
