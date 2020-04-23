define([
    'application',
    'modules/books/book.model',
    'modules/books/book.collection',
], function (Application, Book, BooksCollection) {

    function create(payload) {

        const defer = $.Deferred(),

        dataObject = {
            title: payload.title,
            author: payload.author,
            summary: payload.summary,
            release_date: payload.release_date
        };

        console.log(dataObject);

        $.ajax({
            url: Application.getURI('/books'),
            type: 'post',
            crossDomain:true,
            data: JSON.stringify(dataObject),
            beforeSend: function() {},
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }

        }).done(function (response) {
            defer.resolve(response);
        }).fail(function (xhr) {});

        return defer.promise();
    }

    function edit(data) {

        const defer = $.Deferred(),

            dataObject = {
                title: data.title,
                author: data.author,
                summary: data.summary,
                release_date: data.release_date,
                identity: data.identity
            };

        $.ajax({
            url: Application.getURI(`/books/id/${data.identity}`),
            type: 'put',
            dataType: 'json',
            beforeSend: function() {},
            data: JSON.stringify(dataObject),
            contentType: 'application/json'

        }).done(function (response) {
            defer.resolve(response);
            Application.trigger("books:load");

        }).fail(function (xhr) {
            defer.reject(JSON.parse(xhr.responseText));
        });

        return defer.promise();

    }

    return {

        add : function(data) {
            if ( data.hasOwnProperty("identity") )
                edit(data);
            else
                create(data);
        },

        allBooks : function () {
            const defer = $.Deferred(),
                aCollection = new BooksCollection();

            aCollection.url = Application.getURI(`/books`);
            aCollection.fetch().done(function () {
                defer.resolve(aCollection);
            });

            return defer.promise();
        },

        remove : function(identity) {
            const defer = $.Deferred();

            $.ajax({
                url: Application.getURI(`/books/id/${identity}`),
                type: 'delete',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                crossDomain: true,
                beforeSend: function() {}

            }).done(function (response) {
                defer.resolve(new Book(response));
                Application.trigger("books:load");

            }).fail(function (xhr) {
                defer.reject(xhr)
            });

            return defer.promise();
        },

        bookOf: function (identity) {
            const defer = $.Deferred(),
                aBook = new Book();

            aBook.url = Application.getURI(`/books/id/${identity}`);
            aBook.fetch()
                .done(function () {
                    defer.resolve(aBook);
                }).fail(function (xhr) {
                    defer.reject(xhr);
                });

            return defer.promise();
        }

    };
});
