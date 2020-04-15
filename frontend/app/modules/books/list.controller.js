define([
    "application",
    "modules/common.layout/layout.view",
    "model/site.collection",
    "modules/site/list/list.view",
    "components/loading.view"
], function (Application, LayoutView, SiteCollection, ListView, LoadingView) {

    return Marionette.Controller.extend({

        initialize: function (options) {
            this.region = options.region;
            this.account = options.account;
        },

        list: function() {
            var that       = this,
                layout     = new LayoutView(),
                collection = new SiteCollection(),
                loading    = new LoadingView();

            collection.url = Application.getURI('books');

            this.region.show(layout);

            layout.contentRegion.show(loading);

            $.when(collection.fetch()).done(function () {

                var listView = new ListView({
                    collection: collection,
                    account: that.account
                });

                layout.contentRegion.show(listView);
            });
        },

        onClose: function () {
            this.region.close();
        }

    });

});
