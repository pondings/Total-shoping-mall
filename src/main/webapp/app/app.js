'use strict';

/** WMS App module */
angular.module('app', [
/* common modules */
'app.core', 'app.widgets',
/* Feature modules */
'app.navbar','app.emp', 'app.prod','app.prodType','app.user','app.customer','app.login' ]);
/* validate */

/* Employee */
angular.module('app.emp', [ 'app.core', 'app.widgets', 'jcs-autoValidate' ])
		.run([ 'validator', function(validator) {
			validator.setValidElementStyling(false);
		} ]);

/* Product */
angular.module('app.prod', [ 'app.core', 'app.widgets', 'jcs-autoValidate' ])
		.run([ 'validator', function(validator) {
			validator.setValidElementStyling(false);
		} ]);

/* Product Type */
angular.module('app.prodType', [ 'app.core', 'app.widgets', 'jcs-autoValidate' ])
.run([ 'validator', function(validator) {
	validator.setValidElementStyling(false);
} ]);

/* User */
angular.module('app.user', [ 'app.core', 'app.widgets', 'jcs-autoValidate' ])
.run([ 'validator', function(validator) {
	validator.setValidElementStyling(false);
} ]);

/* Customer */
angular.module('app.customer', [ 'app.core', 'app.widgets', 'jcs-autoValidate' ])
.run([ 'validator', function(validator) {
	validator.setValidElementStyling(false);
} ]);

/* Login */
angular.module('app.login', [ 'app.core', 'app.widgets', 'jcs-autoValidate' ])
.run([ 'validator', function(validator) {
	validator.setValidElementStyling(false);
} ]);

/* require module */
angular.module('app.core', [
/* Angular modules... */
/* Cross-app modules... */
/* 3rd-party module */
'ui.router' ]);

var app = angular.module('app.widgets', [ 'ui.bootstrap',
		'picardy.fontawesome', 'ngBootbox', 'oitozero.ngSweetAlert', 'flash',
		'wt.responsive', 'smart-table' ]);

/* Navbar Feature */
angular.module('app.navbar',['app.core']);

/* navbar Employee Feature*/
angular.module('app.emp',['app.core','app.widgets']);

/* navebar Customer Feature*/
angular.module('app.customer',['app.core','app.widgets']);

/* navebar Product Feature*/
angular.module('app.prod',['app.core','app.widgets']);

/* navebar Product Type Feature*/
angular.module('app.prodType',['app.core','app.widgets']);

/* navebar User Feature*/
angular.module('app.user',['app.core','app.widgets']);


