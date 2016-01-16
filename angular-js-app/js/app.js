var app = angular.module('blog', [ ]);

app.controller('HomeController', ['$scope', '$http', function($scope, $http) {
  $scope.helloWorld = 'Aplicatii Web cu suport Java!';

  $scope.persoane = [];
  $scope.keys = [];

  $scope.person = {};
  $scope.editPerson = {};

$('#myModal').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget) // Button that triggered the modal
  var recipient = button.data('whatever') // Extract info from data-* attributes
  var modal = $(this)
  modal.find('.modal-title').text('New message to ' + recipient)
  modal.find('.modal-body input').val(recipient)  
});

  $http.get('http://localhost:8080/Persoana').then(
    function successCallback(response) {

    $scope.persoane = response;
    $scope.keys = Object.keys(response.data[0]);
  });




  $scope.addPersoana = function(person) {
    $scope.persoane.data.push(person);
    $http.post('http://localhost:8080/Persoana', person);
    $scope.person = {};
  };

  $scope.setUpdatePerson = function(person) {
    $scope.editPerson = person;
  };

  $scope.updatePerson = function() {
    $http.put('http://localhost:8080/Persoana', $scope.editPerson);
    $scope.editPerson = {};
  };

  $scope.deletePersoana = function(id) {
    $http.delete('http://localhost:8080/Persoana/' + id)
    .then(
      function successCallback(response) {
      },
      function errorCallback(response) {
        angular.element('[data-id=' + id + ']').remove();
    });
  };




 //  Resursa Fruct

  $scope.fructe = [];
  $scope.keys = [];

  $scope.fruct = {};
  $scope.editFruct = {};

  $http.get('http://localhost:8080/Fruct').then(
    function successCallback(response) {

    $scope.fructe = response;
    $scope.keys = Object.keys(response.data[0]);
  });


  $scope.addFruct = function(fruct) {
    $scope.fructe.data.push(fruct);
    $http.post('http://localhost:8080/Fruct', fruct);
    $scope.fruct = {};
  };

  $scope.setUpdateFruct = function(fruct) {
    $scope.editFruct = fruct;
  };

  $scope.updateFruct = function() {
    $http.put('http://localhost:8080/Fruct', $scope.editFruct);
    $scope.editFruct = {};
  };

  $scope.deleteFruct = function(id) {
    $http.delete('http://localhost:8080/Fruct/' + id)
    .then(
      function successCallback(response) {
      },
      function errorCallback(response) {
        angular.element('[data-id=' + id + ']').remove();
    });


  };


  //Elev

  $scope.elevi = [];
  $scope.keys = [];

  $scope.elev = {};
  $scope.editElev = {};

  $http.get('http://localhost:8080/Elev').then(
    function successCallback(response) {

    $scope.Elev = response;
    $scope.keys = Object.keys(response.data[0]);
  });


  $scope.addElev = function(elev) {
    $scope.elevi.data.push(elev);
    $http.post('http://localhost:8080/Elev', elev);
    $scope.elev = {};
  };

  $scope.setUpdateElev = function(elev) {
    $scope.editElev = elev;
  };

  $scope.updateElev = function() {
    $http.put('http://localhost:8080/Elev', $scope.editElev);
    $scope.editElev = {};
  };

  $scope.deleteElev = function(id) {
    $http.delete('http://localhost:8080/Elev/' + id)
    .then(
      function successCallback(response) {
      },
      function errorCallback(response) {
        angular.element('[data-id=' + id + ']').remove();
    });


  };

   //Cetatean

  $scope.cetateni = [];
  $scope.keys = [];

  $scope.cetateni = {};
  $scope.editCetatean = {};

  $http.get('http://localhost:8080/Cetatean').then(
    function successCallback(response) {

    $scope.cetateni = response;
    $scope.keys = Object.keys(response.data[0]);
  });


  $scope.addCetatean = function(cetatean) {
    $scope.medicamente.data.push(cetatean);
    $http.post('http://localhost:8080/medicament', cetatean);
    $scope.cetatean = {};
  };

  $scope.setUpdateCetatean = function(cetatean) {
    $scope.editCetatean = cetatean;
  };

  $scope.updateCetatean = function() {
    $http.put('http://localhost:8080/Cetatean', $scope.editCetatean);
    $scope.editCetatean = {};
  };

  $scope.deleteCetatean = function(id) {
    $http.delete('http://localhost:8080/Cetatean/' + id)
    .then(
      function successCallback(response) {
      },
      function errorCallback(response) {
        angular.element('[data-id=' + id + ']').remove();
    });


  };

  
}]);