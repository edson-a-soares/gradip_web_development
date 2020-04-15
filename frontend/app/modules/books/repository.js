define([
    'application'
], function (Application) {

    return {
        add: function (data) {
            var defer = $.Deferred(),
                dataObject = {
                    title: data.title,
                    author: data.author,
                    summary: data.summary,
                    release_date: data.release_date
                };

            $.ajax({
                url: Application.getURI('books'),
                type: 'post',
                dataType: 'json',
                data: JSON.stringify(dataObject),
                contentType: 'application/json'

            }).done(function (response) {
                defer.resolve(response);
            }).fail(function (xhr) {
                defer.reject(JSON.parse(xhr.responseText));
            });

            return defer.promise();
        }
    };
});
