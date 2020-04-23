define([
    'application',
    'modules/books/list.view',
    'modules/books/repository',
    'modules/books/book.router',
    'components/preloader.view'
], function (Application, BooksListView, repository, BooksRouter, Preloader ) {

    const ModuleLoader = Marionette.Object.extend({

        initialize: function () {

            Application.redirectTo("#books");

            Application.on("books:create", function () {
                require([
                    "modules/books/create.view"
                ], function (BookCreateView) {

                    const createView = new BookCreateView();
                    createView.on("data:submit", function (payload) {
                        $.when(repository.add(payload))
                            .done(function (xhr) {})
                            .fail(function (xhr) {});

                        createView.trigger("dialog:close");
                    });
                    Application.dialogRegion.show(createView);
                })
            });

            Application.on("books:edit", function (identity) {
                require([
                    'modules/books/edit.view'
                ], function (BookEditView) {

                    const editView = new BookEditView();
                    $.when(repository.bookOf(identity))
                        .done(function (aBook) {
                            editView.model = aBook;
                            Application.dialogRegion.show(editView);
                        });

                    editView.on("data:submit", function (payload) {
                        $.when(repository.add(payload))
                            .done(function (xhr) {})
                            .fail(function (xhr) {});

                        editView.trigger("dialog:close");
                    });

                })
            });

            Application.on("books:remove", function (identity) {

                require([
                    'modules/books/delete.view'
                ], function (BookDeleteView) {

                    const deleteView = new BookDeleteView();
                    $.when(repository.bookOf(identity))
                        .done(function (aBook) {
                            deleteView.model = aBook;
                            Application.dialogRegion.show(deleteView);
                        });

                    deleteView.on("data:submit", function (payload) {
                        $.when(repository.remove(payload.identity))
                            .done(function (xhr) {})
                            .fail(function (xhr) {});

                        deleteView.trigger("dialog:close");
                    });

                })

            });

            Application.on("books:load", function () {

                Application.mainRegion.show(new Preloader());
                $.when(repository.allBooks())
                    .done(function (aCollection) {
                        setTimeout(function () {
                            Application.mainRegion.show(new BooksListView({collection: aCollection}));
                        }, 250);
                    });

            });

        }

    });

    new BooksRouter();
    return new ModuleLoader();

});
