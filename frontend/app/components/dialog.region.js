define([
    'marionette',
    'bootstrap'
], function(Marionette){
    return Marionette.Region.extend({

        onShow: function(view){

            this.listenTo(view, "dialog:close", this.closeDialog);

            const self = this;
            this.$el.modal({
                backdrop: "static",
                modal: true,
                title: view.title,

                close: function(e, ui){
                    self.closeDialog();
                }
            });
        },

        closeDialog: function(){
            this.stopListening();
            this.empty();
            this.$el.modal('hide')
        }

    });

});
