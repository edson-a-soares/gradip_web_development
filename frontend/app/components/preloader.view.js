define([
    'marionette',
    'underscore',
    'text!components/templates/preloader.html'
], function(Marionette, _, template){

    return Marionette.ItemView.extend({

        className : "preloader",

        template: _.template(template),

    });

});