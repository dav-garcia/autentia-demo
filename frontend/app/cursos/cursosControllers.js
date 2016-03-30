var mod = angular.module('cursos', ['ngResource']);

mod.controller('CursosListCtrl', ['$scope', 'Curso',
  function($scope, Curso) {
    $scope.cursos = Curso.query();
    $scope.cursosSafe = [].concat($scope.cursos);
  }]);

mod.controller('CursosDetailCtrl', ['$scope', '$routeParams', '$location', 'Curso', 'Profesor',
  function($scope, $routeParams, $location, Curso, Profesor) {
    var id = parseInt($routeParams.id);
    $scope.curso = (id ? Curso.get({id: id}) : new Curso());
    $scope.profesores = Profesor.query();
    $scope.niveles = ['BASICO', 'INTERMEDIO', 'AVANZADO'];

    $scope.onSubmit = function() {
      if ('id' in $scope.curso && $scope.curso.id) {
        $scope.curso.$update();
      } else {
        $scope.curso.$save(function(data) {
          $location.path('/cursos/' + data.id);
        });
      }
    }
  }]);
