var apiclient = (function () {

    var getStrings = function (callback) {
        $.getJSON("/string", function (data) {
            callback(data);
        });}

    var addString = function (myString) {
        return $.ajax({
            url: "/string",
            type: "POST",
            data: JSON.stringify(myString),
            contentType: "application/json",
        });
        };

    return {
        getStrings: getStrings,
        addString : addString, 
    };
})();