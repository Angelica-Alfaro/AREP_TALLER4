var apiclient = (function () {

    var getStrings = function (callback) {
        $.getJSON("/string", function (data) {
            callback(data);
        });}

    var saveString = function (myString) {
        return $.ajax({
            url: "/string",
            type: "POST",
            data: myString,
            contentType: "application/json",
        });
        };

    return {
        getStrings: getStrings,
        saveString : saveString, 
    };
})();