var mod = angular.module('profesores');

mod.factory('Profesor', ['$resource',
  function($resource) {
    return $resource('/api/profesor/:id', { id: '@id' }, {
      update: {
        method: 'PUT'
      }
    });
  }]);
