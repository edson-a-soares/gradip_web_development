define([
    'backbone',
    'modules/books/book.model'
], function (Backbone, Book) {

    return Backbone.Collection.extend({
        model: Book
    });

});
