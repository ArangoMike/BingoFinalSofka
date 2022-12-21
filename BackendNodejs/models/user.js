const { Schema, model }  = require ('mongoose');


const userSchema = Schema({
    nickname:{
        type: String,
        required: true,      
    },
   password:{
    type: String,
    required: true
   },
   email:{
    type: String,
    required: true,
   },
   online:{
    type: Boolean,
    default: false
   }
});


module.exports = model('User', userSchema);