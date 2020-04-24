define([
    'backbone'
], function(Backbone) {

    return Backbone.Model.extend({
        defaults: {
            title: 'Title here.',
            author: 'Author name.',
            summary: 'Some description here.',
            release_date: '2015-05',
            identity: 'UUID'
        }
    });

});
