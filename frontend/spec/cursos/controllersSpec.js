describe('CursosListCtrl', function() {
  var cursoMock;
  var $scope, ctrl;

  beforeEach(function() {
    cursoMock = jasmine.createSpyObj('Curso', ['query']);

    module('autentiaDemoApp');

    inject(function($rootScope, $controller, $q) {
      $scope = $rootScope.$new();
      cursoMock.query.and.returnValue($q.when([
        {id: 1, titulo: 'Prueba', activo: true}
      ]));
      ctrl = $controller('CursosListCtrl', {$scope: $scope, Curso: cursoMock});
    });
  });

  it('debería crear 1 curso', function() {
    expect(cursoMock.query).toHaveBeenCalled();
    expect($scope.cursos.length).toBe(1);
  });

});
