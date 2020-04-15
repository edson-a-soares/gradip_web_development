define([
    'marionette'
], function(Marionette){
    return Marionette.Region.extend({

        onShow: function(view) {
            var that = this;

            this.listenTo(view, "dialog:close", this.closeDialog);

            setTimeout(function () {
                that.closeDialog();
            }, 6000);
        },

        closeDialog: function(){
            this.stopListening();
            this.empty();
        }

    });
});