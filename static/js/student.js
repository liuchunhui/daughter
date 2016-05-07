/**
 * @file student.js
 * @author liuchunhui
 */
'use strict';
var StudentList = angular.module('StudentMdl', []);
StudentList.config(function($interpolateProvider) {
    $interpolateProvider.startSymbol('//');
    $interpolateProvider.endSymbol('//');
});
StudentList.config(['$locationProvider', function($locationProvider) {
    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    }).hashPrefix('');
}]);
StudentList.controller('StudentCtr', ['$scope', '$http', '$location', StudentCtr]);
function StudentCtr($scope, $http, $location) {
    $scope.nav = {
        index: 'WAIMAI'
    };

    $scope.init = function () {

        var studentlist = [
            {
                SID: '0001',
                name: '张三',
                sex: '男',
                major: '计算机',
                grade: '12级',
                birth: '1990-02-01',
                set: '操作'
            }
        ];
        var id = '#studentlist';
        var columns = [
            {data: 'SID'},
            {data: 'name'},
            {data: 'sex'},
            {data: 'major'},
            {data: 'grade'},
            {data: 'birth'},
            {data: 'set'}
        ];
        utils.initTable(id, studentlist, columns);

    };
}
