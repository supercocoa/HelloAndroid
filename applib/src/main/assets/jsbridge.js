var global = this;

(function () {
    var _javaCls = {};
    var _jsCls = {};


    var _formatJavaToJS = function (javaObj) {
        if (javaObj === undefined || javaObj === null) return false;

        return JSON.parse(javaObj.toString());
    };

    var _methodFunc = function (instance, clsName, methodName, args) {
        var selectorName = methodName;
        var ret = instance ? Bridge.call(instance, selectorName, JSON.stringify(args)) :
            Bridge.call(clsName, selectorName, JSON.stringify(args));
        return _formatJavaToJS(ret)
    };

    var _customMethods = {
        __c: function (methodName) {
            if (!this.__obj && !this.__clsName) return this[methodName].bind(this);
            var self = this;
            return function () {
                var args = {"bridgeObjects": Array.prototype.slice.call(arguments)};
                return _methodFunc(self.__obj, self.__clsName, methodName, args)
            }
        },

        super: function () {
            var slf = this;
            return {__obj: slf.__obj, __clsName: slf.__clsName, __isSuper: 1}
        },
    };

    for (var method in _customMethods) {
        if (_customMethods.hasOwnProperty(method)) {
            Object.defineProperty(Object.prototype, method, {
                value: _customMethods[method],
                configurable: false,
                enumerable: false
            })
        }
    }


    var _load = function (clsName) {
        if (!global[clsName]) {
            global[clsName] = {
                __clsName: clsName
            }
        }
        return global[clsName]
    };

    global.load = function (clsNames) {
        var lastLoad;
        clsNames.split(',').forEach(function (clsName) {
            lastLoad = _load(clsName.trim())
        });
        return lastLoad
    };

    global.newObject = function (claName) {
        return _formatJavaToJS(Bridge.newObject(claName));
    };

    global.newInt = function (i) {
        return _formatJavaToJS(Bridge.newInt(i));
    };

    global.newString = function (s) {
        return _formatJavaToJS(Bridge.newString(s));
    };

    global.log = function (tag, s) {
        if (s instanceof String) {
            s = s.toString();
        }
        if (typeof s == "string") {
            Bridge.logString(tag, s);
        } else {
            var s_ = {"bridgeObject": s};
            Bridge.logObject(tag, JSON.stringify(s_));
        }
    };


})();