define([
    'backbone'
], function(Backbone) {

    return Backbone.Model.extend({
        defaults: {
            title: 'Title here.',
            author: 'Author name.',
            summary: 'Some description here.',
            releaseYear: '01-2015',
            identity: 'UUID'
        }
    });

});
