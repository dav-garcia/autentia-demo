var app = angular.module('autentiaDemoApp', [
  'ngRoute',
  'smart-table',
  'cursos',
  'profesores'
]);

app.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider
    .when('/cursos', {
      'templateUrl': 'cursos/cursos-list.html',
      'controller': 'CursosListCtrl'
    })
    .when('/cursos/:id', {
      'templateUrl': 'cursos/cursos-detail.html',
      'controller': 'CursosDetailCtrl'
    })
  }]);

app.directive('clickView', ['$location',
  function($location) {
    return {
      link: function(scope, element, attrs) {
        element.on('click', function() {
          scope.$apply(function() {
              $location.path(attrs.clickView);
          });
        });
      }
    }
  }]);
