define([
    'application',
    'modules/books/list.view',
    'modules/books/repository'
], function (Application, BooksListView, repository ) {

    const BooksModuleLoader = Marionette.Object.extend({

        initialize: function (options) {

            Application.on("books:create", function (options) {
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

            Application.on("books:edit", function (options) {
                require([
                    'modules/books/edit.view'
                ], function (BookEditView) {

                    const editView = new BookEditView();
                    $.when(repository.bookOf("9c09c073bb84" /* options.bookId */))
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

            Application.on("books:remove", function (options) {

                require([
                    'modules/books/delete.view'
                ], function (BookDeleteView) {

                    const deleteView = new BookDeleteView();
                    $.when(repository.bookOf("9c09c073bb84" /* options.bookId */))
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

            $.when(repository.allBooks())
                .done(function (aCollection) {
                    Application.mainRegion.show(new BooksListView({ collection : aCollection }));
                });

        }

    });

    return new BooksModuleLoader();

});
