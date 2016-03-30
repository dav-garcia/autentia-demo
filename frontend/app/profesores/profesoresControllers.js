var mod = angular.module('profesores', ['ngResource']);

mod.controller('ProfesoresListCtrl', ['$scope', 'Profesor',
  function($scope, Profesor) {
    $scope.profesores = Profesor.query();
  }]);

mod.controller('ProfesoresDetailCtrl', ['$scope', '$routeParams', 'Profesor',
  function($scope, $routeParams, Profesor) {
    var id = parseInt($routeParams.id);
    $scope.profesor = (id ? Profesor.get({id: id}) : new Profesor());
  }]);
