/**
 * @file index.js
 * @author liuchunhui
 */
'use strict';  // 严格模式
var index = angular.module('indexMdl', []);
index.config(function ($interpolateProvider) {  // 替换模板{{}}为//*//
    $interpolateProvider.startSymbol('//');
    $interpolateProvider.endSymbol('//');
});
index.config(['$locationProvider', function ($locationProvider) {
    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    }).hashPrefix('');
}]);
index.controller('indexCtr', ['$scope', '$http', IndexCtr]);
function IndexCtr($scope, $http) {
    $scope.nav = {
        index: '首页'
    };
}
