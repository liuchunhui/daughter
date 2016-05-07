/**
 * @file student_info.js
 * @author liuchunhui
 */
'use strict';
var StudentInfo = angular.module('StudentInfoMdl', []);
StudentInfo.config(function($interpolateProvider) {
    $interpolateProvider.startSymbol('//');
    $interpolateProvider.endSymbol('//');
});
StudentInfo.config(['$locationProvider', function($locationProvider) {
    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    }).hashPrefix('');
}]);
StudentInfo.controller('StudentInfoCtr', ['$scope', '$http', '$location', StudentInfoCtr]);
function StudentInfoCtr($scope, $http, $location) {
    $scope.nav = {
        index: 'WAIMAI'
    };

    $scope.init = function () {
    };
}
