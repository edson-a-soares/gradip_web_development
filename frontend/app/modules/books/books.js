define([
    'application',
    'modules/books/list.view',
    'modules/books/repository'
], function (Application, BooksListView, BooksRepository) {

    var BooksModuleLoader = Marionette.Object.extend({
        initialize: function(options) {

            Application.on("books:create", function (options) {
                require([
                    "modules/books/create.view"
                ], function (BooksCreateView) {
                    var createView = new BooksCreateView();
                    createView.on("data:submit", function (data) {
                        console.log(data);

                        $.when(BooksRepository.add(data))
                            .done(function (xhr) {})
                            .fail(function (xhr) {});
                        createView.trigger("dialog:close");
                    });
                    Application.dialogRegion.show(createView);
                })
            });

            Application.mainRegion.show(new BooksListView());

            Application.on("books:edit", function (options) {});

            Application.on("books:remove", function (options) {});

        }
    });

    return new BooksModuleLoader();

});
