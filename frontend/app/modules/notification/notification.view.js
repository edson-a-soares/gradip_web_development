define([
    "application",
    "text!modules/notification/templates/notification.html"
], function (Application, notificationTpl) {
    return Marionette.ItemView.extend({
        template: _.template(notificationTpl),
        className: 'notification-content',
        triggers: {
            "click .js-cancel": "dialog:close"
        },

        onShow: function () {
            this.$el.removeClass('notification-success')
                .removeClass('notification-error');

            if (this.model.get("type") === 'success') {
                this.$el.addClass('notification-success');
            } else if (this.model.get("type") === 'error') {
                this.$el.addClass('notification-error');
            }
        }
    });
});