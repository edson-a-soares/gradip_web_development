define([
    'application',
    'modules/notification/notification.view'
], function (Application, NotificationView) {
    return {
        init: function (message, type) {
            var notificationView = new NotificationView({
                model: new Backbone.Model({
                    message: message,
                    type: type
                })
            });

            Application.notificationRegion.show(notificationView);
        }
    }
});