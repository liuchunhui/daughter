/**
 * @file grade.js
 * @author liuchunhui
 */
'use strict';
var Grade = angular.module('GradeMdl', ['ui.router']);
Grade.config(function($interpolateProvider) {
    $interpolateProvider.startSymbol('//');
    $interpolateProvider.endSymbol('//');
});
Grade.config(['$locationProvider', function($locationProvider) {
    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    }).hashPrefix('');
}]);

Grade.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

    //$urlRouterProvider.otherwise('/grade');
    $stateProvider
        .state('student', {
            url: '#student',
            templateUrl: '/grade/student',
            controller: 'gradeStudentCtr'
        })
        .state('class', {
            url: '#class',
            templateUrl: '/grade/class',
            controller: 'gradeClassCtr'
        })
        .state('fail', {
            url: '#fail',
            templateUrl: '/grade/fail',
            controller: 'gradeFailCtr'
        })
}]);
Grade.controller('GradeCtr', ['$scope', '$http', '$location', GradeCtr]);
function GradeCtr($scope, $http, $location) {
    $scope.nav = {
        index: 'WAIMAI'
    };

    $scope.url = {
        student: '#student',
        class: '#class',
        fail: '#fail'
    };

    $scope.init = function () {

    };
}

// 学生成绩管理
Grade.controller('gradeStudentCtr', ['$scope', '$http', function ($scope, $http) {

    $scope.init = function () {
        console.log('gradeStudentCtr');
    }
}]);

// 班级成绩管理
Grade.controller('gradeStudentCtr', ['$scope', '$http', function ($scope, $http) {

    $scope.init = function () {
        console.log('gradeClassCtr');
    }
}]);

// 补考学生成绩管理
Grade.controller('gradeStudentCtr', ['$scope', '$http', function ($scope, $http) {

    $scope.init = function () {
        console.log('gradeFailCtr');
    }
}]);

