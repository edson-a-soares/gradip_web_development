require.config({
    baseUrl: "app",
    paths: {
        almond: "../node_modules/almond/almond",
        bootstrap: "../node_modules/bootstrap/dist/js/bootstrap",
        popper: "../node_modules/popper.js/dist/umd/popper",
        "backbone": "../node_modules/backbone/backbone",
        "route.filter": "../node_modules/backbone-async-route-filters/backbone-route-filter-amd",
        "backbone.select": "../node_modules/backbone.select/dist/amd/backbone.select",
        underscore: "../node_modules/underscore/underscore",
        text: "../node_modules/requirejs-text/text",
        jquery: "../node_modules/jquery/dist/jquery",
        marionette: "../node_modules/backbone.marionette/lib/backbone.marionette",
        "backbone.syphon": "../node_modules/backbone.syphon/lib/backbone.syphon",
        "jquery.ui": "../node_modules/jquery-ui-dist/jquery-ui",
        "jquery.cookie": "../node_modules/js-cookie/src/js.cookie",
        "jquery.maskedinput": "../node_modules/jquery.maskedinput/src/jquery.maskedinput"
    },
    shim: {
        "jquery.maskedinput": ['jquery'],
        "backbone": {
            deps: ["jquery","underscore"],
            exports: "Backbone"
        },
        "route.filter": {
            deps: ["backbone"]
        },
        underscore: {
            exports: "_"
        },
        "jquery.ui":["jquery"],
        marionette: {
            deps: ["backbone"],
            exports: "Marionette"
        },
        bootstrap: {
            deps: ["jquery","popper"]
        }
    }
});

require(["application"],
    function(Application){
        Application.start();
    }
);
