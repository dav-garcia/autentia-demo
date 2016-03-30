var mod = angular.module('cursos');

mod.factory('Curso', ['$resource',
  function($resource) {
    return $resource('/api/curso/:id', { id: '@id' }, {
      update: {
        method: 'PUT'
      }
    });
  }]);
